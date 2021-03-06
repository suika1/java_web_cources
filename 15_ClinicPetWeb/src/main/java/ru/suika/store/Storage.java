package ru.suika.store;

import ru.suika.models.User;

import java.util.Collection;

public interface Storage {

    public Collection<?> values();

    public int add(final User user);

    public void edit(final User user);

    public void delete(final int id);

    public User get(final int id);

    public User findByLogin(final String login);

    public int generateId();

    public void close();
}
