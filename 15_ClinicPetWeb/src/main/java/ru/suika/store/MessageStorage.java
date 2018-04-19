package ru.suika.store;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.suika.models.Message;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Класс для работы с БД сообщений
 */
public class MessageStorage {
    private final SessionFactory factory;

    public MessageStorage(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Collection<Message> values(){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            return session.createQuery("from Messages").list();
        }finally {
            tx.commit();
            session.close();
        }
    }

    public int add(final Message message){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            System.out.println("text = "+message.getText()+"\nid = "+message.getId());
            session.save(message);
            System.out.println("text = "+message.getText()+"\nid = "+message.getId());
            return message.getId();
        }finally {
            System.out.println("Do not be angry, IDEA -__-");
            tx.commit();
            session.close();
        }
    }

    public void edit(Message message){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.update(message);
        }finally {
            tx.commit();
            session.close();
        }
    }

    public void delete(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(get(id));
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Message get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Message) session.get(Message.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Message findMessageByText(String text) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Message as message where message.text=:text");
            try {
                query.setString("text", text);
                return (Message) query.iterate().next();
            }catch (NoSuchElementException e){
                System.out.println("No such element");
                return null;
            }
        } finally {
            tx.commit();
            session.close();
        }
    }

    public int generateId() {
        return 0;
    }

    public void close() {
        this.factory.close();
    }

}