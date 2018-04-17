package ru.suika.store;

import ru.suika.models.User;
import ru.suika.service.Settings;

import javax.swing.plaf.nimbus.State;
import java.security.Permission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class JdbcStorage implements Storage {
    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * @return Весь список клиентов
     */
    @Override
    public Collection<User> values() {
        final List<User> users = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from client")) {
            while (rs.next()) {
                users.add(new User(rs.getInt("uid"), rs.getString("name"), null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Добавление пользователя в БД
     * @param user Нужный пользователь
     * @return
     */
    @Override
    public int add(User user) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into client (name) values (?)",Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

    /**
     * Исправление пользователя в БД с заданным id
     * @param user пользователь с нужным id и новым name
     */
    @Override
    public void edit(final User user) {

        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE client AS client SET name = \'"+user.getLogin()+"\' WHERE client.uid = ?;",Statement.RETURN_GENERATED_KEYS)) {
          statement.setInt(1, user.getId());
          statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        /**
         * Работает с конкотацией, без нее пока нет
         */
        try(final PreparedStatement statement = this.connection.prepareStatement("DELETE FROM client AS client WHERE client.uid = \'"+id+"\';", Statement.RETURN_GENERATED_KEYS)){
            //statement.setString(1,"'"+id+"'");
            System.out.println(id+" "+this.get(id));
            System.out.println("'"+Integer.toString(id)+"'");
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from client where uid=(?)")){
            statement.setInt(1, id);
            try(final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new User(rs.getInt("uid"), rs.getString("name"), null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User %s does not exists", id));
    }

    /**
     * Возвращает клиента со значениями, взятыми из базы данных
     * @param login Имя клиента
     * @return Клиент
     */
    @Override
    public User findByLogin(String login) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from client where client.name = (?)")){
            statement.setString(1, login);
            try(final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new User(rs.getInt("uid"), rs.getString("name"), null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User %s does not exists ", login));
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}