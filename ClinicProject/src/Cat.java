/**
 * Кот
 * Created by suika1 on 07.01.2018.
 */
public class Cat extends Animal {

    public Cat(String name){
        super(name);
    }

    @Override
    public void makeSound(){
        System.out.printf("%s said %s",this.getName(),"Hello, I'm cat, meow!");
    }

    @Override
    public void setName(String name){
        super.setName(name);
    }

}
