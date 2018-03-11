package ru.suika.servlets;

import ru.Clinic.lessons.Animal;
import ru.Clinic.lessons.Dog;
import ru.Clinic.lessons.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Класс, реализующий клиент-серверное приложение для простого ввода питомцев и поиска питомцев в массиве
 */
public class ClinicServlet extends HttpServlet {


    //Массив питомцев
    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();
    //совершил ли пользователь ошибку при вводе
    boolean error = false;
    //ищет ли пользователь питомца, или же он добавляет питомца
    boolean isSearching = false;


    /**
     * Get - запрос к серверу
     * @param req запрос
     * @param resp ответ
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (!error) {
            writer.append(
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "     <title>Clinic Pets</title>" +
                            "</head>" +
                            "<body>" +
                            "     <form action='" + req.getContextPath() + "/' method='post'>" +
                            "         Name : <input type='text' name='name'>" +
                            "         <input type='submit' value='Submit'>" +
                            "     <form>" +
                            "     <form action='" + req.getContextPath() + "/' method='post'>" +
                            "         Name : <input type='text' name='search'>" +
                            "         <input type='submit' value='Search'>" +
                            "     <form>");
            if (isSearching == false) {
                writer.append(this.viewPets());
            }else{
                writer.append(this.viewPets(req.getParameter("search")));
            }
            writer.append("</body>" +
            "</html>"
            );
        }else{
            writer.append("<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "     <title>Clinic Pets</title>" +
                    "</head>" +
                    "<body>" +
                    "   <h>Mistake was made</h>" +
                    "</body>" +
                    "</html>"
            );
            error = false;
        }
        writer.flush();
    }

    /**
     * Post-запрос к серверу
     * @param req запрос
     * @param resp ответ
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("name").equals("")){
            this.pets.add(new Dog(new Animal(req.getParameter("name"))));
            isSearching = false;
        }else if (!req.getParameter("search").equals("")){
            isSearching = true;
        }else{
            error = true;
        }
        doGet(req, resp);
    }

    /**
     * Просмотр питомцев при добавлении клиентом
     * @return Все питомцы
     */
    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
            for (Pet pet : this.pets) {
                sb.append("<tr><td style='border : 1px solid black'>").append(pet.getName()).append("</td></tr>");
            }

        sb.append("</table>");
        return sb.toString();
    }

    /**
     * Просмотр питомцев по поисковому имени
     * @param searchName Имя искомого питомца
     * @return Все питомцы с искомым именем
     */
    private String viewPets(String searchName){
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (Pet pet : this.pets) {
            if (searchName.equals(pet.getName()))
                sb.append("<tr><td style='border : 1px solid black'>").append(pet.getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }


}
