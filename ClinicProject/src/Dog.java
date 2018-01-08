/**
 * Собака
 * Created by suika1 on 07.01.2018.
 */
public class Dog extends Animal {

    public Dog(String name){
        super(name);
    }

    @Override
    public void makeSound(){
        System.out.printf("%s said %s",this.getName(),"Hello, I'm a dog, gav-gav!");
    }

    @Override
    public void setName(String name){
        super.setName(name);
    }
}
