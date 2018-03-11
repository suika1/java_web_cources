package ru.suika.servlets;

import ru.Clinic.lessons.Animal;
import ru.suika.models.User;
import ru.suika.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class UserEditServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", this.USER_CACHE.get(Integer.valueOf(req.getParameter("id"))));
        System.out.println(Integer.valueOf(req.getParameter("id")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ids.set(Integer.valueOf(req.getParameter("id")));
        this.USER_CACHE.edit(new User(this.ids.get(), req.getParameter("login"), req.getParameter("email")));
        System.out.println(this.ids.get());
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}