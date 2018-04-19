package ru.suika.store;

import org.junit.Test;
import ru.suika.models.Message;
import ru.suika.models.Role;
import ru.suika.models.User;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class MessageTest {
   @Test
    public void testMessageCreateEditDelete() throws Exception {
        final MessageStorage storage = new MessageStorage();
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        Message message = new Message();
        message.setUser(user);
        message.setText("Loltext");
        HashSet<Message> messages = new HashSet<>();
        messages.add(message);
        user.setMessages(messages);
        final int id = storage.add(message);
        System.out.println(message.getText()+"++"+message.getId());
        message = storage.get(id);
        System.out.println(message.getText()+" "+message.getId());
        storage.delete(id);
        assertEquals(null,storage.get(id));
        assertEquals(null,storage.findMessageByText(message.getText()));
        storage.close();
    }
}
