package ru.suika.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.suika.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserCreateServletTest extends Mockito {

    final UserCache cache = UserCache.getInstance();

    @Test
    public void createUser() throws ServletException, IOException{
        //Заглушки
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        //Проверяем пустой ли кеш
        assertTrue(cache.values().isEmpty());

        //Отправляем сервлету запрос на добавление пользователя
        new UserCreateServlet().doPost(request,response);

        //Проверяем использовался ли метод getParameter хотя бы 1 раз
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");

        //Не пустой ли сейчас кеш?
        assertFalse(cache.values().isEmpty());

        //удаляем из кеша
        cache.delete(cache.findByLogin("test").getId());
    }
}