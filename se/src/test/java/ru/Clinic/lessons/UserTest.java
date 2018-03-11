package ru.Clinic.lessons;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by user on 17.01.2018.
 */
public class UserTest {

    @Test
    public void ArrayListTests(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("1","first",new Cat(new Animal("Johny"))));
        users.add(new User("2","second",new Cat(new Animal("Walker"))));
        System.out.println(users.get(0));
        assertEquals(users.get(0),new User("1","first",new Cat(new Animal("Johny"))));
        assertTrue(users.contains(new User("1","first",new Cat(new Animal("Johny")))));
    }

    @Test
    public void HashSetTest(){
        Set<User> users = new HashSet<User>();
        users.add(new User("1","1",new Cat(new Animal("Johny"))));
        users.add(new User("2","second",new Cat(new Animal("Waru"))));
        users.add(new User("1","1",new Cat(new Animal("Johny"))));
        assertEquals(2,users.size());
    }

    @Test
    public void HashMapTest(){
        User pit = new User("1","1",new Cat(new Animal("Johny")));
        User dim = new User("1","1",new Cat(new Animal("Johny")));
        User max = new User("1","1",new Cat(new Animal("Johny")));
        assertEquals(pit,dim);
        assertEquals(dim,max);
        assertEquals(pit,max);
    }

    @Test
    public void consistent(){
        User pit = new User("1","1",new Cat(new Animal("Johny")));
        User dim = new User("1","1",new Cat(new Animal("Johny")));
        for (int i=0;i<10;i++){
            assertEquals(pit,dim);
        }
    }



}