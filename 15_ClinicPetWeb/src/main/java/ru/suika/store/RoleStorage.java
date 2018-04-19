package ru.suika.store;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.suika.models.Role;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Класс для работы с БД ролей
 */
public class RoleStorage {
    private final SessionFactory factory;

    public RoleStorage(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Collection<Role> values(){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            return session.createQuery("from Roles").list();
        }finally {
            tx.commit();
            session.close();
        }
    }

    public int add(final Role role){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(role);
            return role.getId();
        }finally {
           System.out.println("Do not be angry, IDEA c:");
           tx.commit();
           session.close();
        }
    }

    public void edit(Role role){
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.update(role);
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

    public Role get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Role) session.get(Role.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Role findRoleByName(String RoleName) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Role as role where role.name=:roleName");
            try {
                query.setString("roleName", RoleName);
                return (Role) query.iterate().next();
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