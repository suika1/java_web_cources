/**
 * Тест работы классов животных
 * Created by user on 07.01.2018.
 */
public class CatDogTest {
    public static void main(String[] arg) {
        Animal utk = new Animal("Utkonos");
        Cat c = new Cat("Misha");
        Dog d = new Dog("Pochi");
        CatDog cd = new CatDog(c, d);

        System.out.printf("utk's name is %s \n", utk.getName());
        utk.makeSound();
        System.out.printf("\ncat's name is %s\n", c.getName());
        c.makeSound();
        c.setName("Haru");
        System.out.printf("\ncat's new name is %s\n", c.getName());
        c.makeSound();
        System.out.printf("\ndog's name is %s\n", d.getName());
        d.makeSound();
        d.setName("Mikky");
        System.out.printf("\ndog's new name is %s\n", d.getName());
        d.makeSound();
        System.out.println("");

        cd.makeSound();
        System.out.printf("\nCatDog's name is : %s\n", cd.getName());
        cd.setName("Cotopyos");
        System.out.printf("\nCatDog's new name is : %s\n", cd.getName());
        cd.makeSound();
    }
}
