package ru.Clinic.lessons;

/**
 * Created by user on 16.01.2018.
 */
public class User {
    private String id;
    private String name;

    private Cat cat;

    public User(String id, String name, Cat cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cat getCat() {
        return cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return cat != null ? cat.equals(user.cat) : user.cat == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cat != null ? cat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cat=" + cat +
                '}';
    }


}
