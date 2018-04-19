package ru.suika.store;

import org.junit.Test;
import ru.suika.models.Role;

import static junit.framework.Assert.assertEquals;

public class RoleStorageTest {
    @Test
    public void testRoleCreateEditDelete() throws Exception {
        final RoleStorage storage = new RoleStorage();
        Role role = new Role();
        role.setName("admin");
        final int id = storage.add(role);
        System.out.println(role.getName()+" "+role.getId());
        role = storage.get(id);
        System.out.println(role.getName()+" "+role.getId());
        storage.delete(id);
        assertEquals(null,storage.get(id));
        assertEquals(null,storage.findRoleByName(role.getName()));
        storage.close();
    }


}
