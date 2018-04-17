package ru.suika.store;

import org.junit.Test;
import ru.suika.models.User;

import static org.junit.Assert.*;

public class HibernateStorageTest {
    @Test
    public void testCreate() throws Exception {
        final HibernateStorage storage = new HibernateStorage();
        final int id = storage.add(new User(-1, "hibenate", null));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
        assertEquals(id, storage.findByLogin("hibenate").getId());
        storage.delete(id);
        assertNull(storage.get(id));
        storage.close();
    }

    @Test
    public void testEdit() throws Exception{
        final HibernateStorage storage = new HibernateStorage();
        final int id = storage.add(new User(-1, "hibenate21", null));
        final User user = storage.get(id);
        user.setLogin("Lolka1");
        user.getId();
        storage.edit(user);
        assertEquals(id,storage.findByLogin("Lolka1").getId());
        storage.delete(id);
        assertNull(storage.get(id));
        storage.close();
    }
}
