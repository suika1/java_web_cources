/**
 * Тест работы класса клиники
 * Created by user on 08.01.2018.
 */
public class ClinicTest {
    public static void main(String[] arg) {
        final Clinic clinic = new Clinic(10);

        clinic.addClient(0, new Client("Brown", new Cat("Digy")));
        clinic.addClient(1, new Client("Nick", new Dog("Sparky")));
        clinic.addClient(2, new Client("Ann", new CatDog(new Cat("Tom"), new Dog("Piccy"))));
        clinic.addClient(3, new Client("Keto", new Dog("Mako")));
        clinic.showDataBase();
        clinic.findClientsByPetName("Sparky");
        clinic.findPetsByClientId("Ann");
        clinic.changeClientId("Mako", "Charlie");
        clinic.changePetName("Brown","Hola");
        clinic.showDataBase();
    }
}
