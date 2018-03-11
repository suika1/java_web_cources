package ru.suika.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.Clinic.lessons.Animal;
import ru.Clinic.lessons.Dog;
import ru.suika.models.User;
import ru.suika.store.UserCache;
import ru.suika.servlets.UserCreateServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserDeleteServletTest extends Mockito{

    private final UserCache cache = UserCache.getInstance();

    @Test
    public void deleteUser() throws IOException, ServletException {
        //Заглушки
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        cache.add(new User(0,"123","suika"));
        //Just for me
        System.out.println(cache.values());
        when(request.getParameter("id")).thenReturn("0");
        new UserDeleteServlet().doGet(request,response);

        verify(request, atLeast(1)).getParameter("id");

        //Just for me x2
        System.out.println(cache.values());

        }
}