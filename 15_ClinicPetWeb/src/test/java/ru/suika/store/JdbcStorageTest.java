package ru.suika.store;

import org.junit.Test;
import ru.suika.models.User;
import ru.suika.store.JdbcStorage;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import static org.junit.Assert.*;

/**
 * @author suika1
 * @since 29.04.2015
 */
public class JdbcStorageTest {

    @Test
    public void testValues() throws Exception{
        final JdbcStorage storage = new JdbcStorage();
        for (User user : storage.values()){
            System.out.println(user.getId()+" "+user.getLogin());
        }
    }

    @Test
    public void testCreate() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final int id = storage.add(new User(-1, "test2", null));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
        storage.close();
    }

    @Test
    public void testGet() {
        final JdbcStorage storage = new JdbcStorage();
        final User user = storage.get(11);
        System.out.println(user.getLogin());
        assertEquals("Ivan",user.getLogin());
        storage.close();
    }

    @Test
    public void testDelete() {
        final JdbcStorage storage = new JdbcStorage();
        final User user = storage.get(9);
        System.out.println(user.getLogin());
        storage.delete(user.getId());
        System.out.println(user.getLogin());
        storage.close();
    }

    @Test
    public void findByLogin() {
        final JdbcStorage storage = new JdbcStorage();
        final User user = storage.findByLogin("test1");
        assertEquals("test1",user.getLogin());
        assertEquals(11,user.getId());
    }

    @Test
   public void testEdit(){
        final JdbcStorage storage = new JdbcStorage();
        User user = new User(10,"mamkuipal",null);
        storage.edit(user);
        assertEquals("mamkuipal",storage.get(10).getLogin());
   }
}