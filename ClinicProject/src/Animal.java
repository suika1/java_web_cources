/**
 * Животное
 * Created by suika1 on 07.01.2018.
 */
public class Animal implements Pet {

    private String name;

    public Animal(String name){
        this.name = name;
    }

    public void makeSound(){
        System.out.println(String.format("%s said: %s", this.name, "Hello, I'm an animal !"));
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
