/**
 * Клиника
 * Created by suika1 on 07.01.2018.
 */
public class Clinic {
    public final int MAX_SIZE = 10;
    /**
     *Список клиентов
     */
    private final Client[] clients;

    public Clinic(final int size){
        this.clients = new Client[size];
    }

    /**
     * Показать состояние базы данных
     */
    public void showDataBase(){
        for (Client client : this.clients) {
            if (client != null)
                System.out.println("Client " + client.getId() + " has "
                        + client.getPet().getClass().getName() + " " + client.getPet().getName());
        }

    }

    /**
     * Добавить клиента
     */
    public void addClient(final int position, final Client newClient){
        for (Client client: this.clients)
            if (client != null && client.getId().equals(newClient.getId())
                    && client.getPet().getName().equals(newClient.getPet().getName())
                    && client.getPet().getClass() == newClient.getPet().getClass()) {
                System.out.println("Этот клиент с этим питомцем уже есть в базе данных");
            }
        this.clients[position] = newClient;
    }

    /**
     * Получаем клиентов по имени питомца
     * @param name Имя питомца
     * @return Клиенты
     */
    public Client[] findClientsByPetName(final String name){
        int count = 0;                                      //счетчик количества совпадений по иимени питомца
        for (Client client : this.clients) {                //в цикле определяем количество совпадений
            if (client != null && client.getPet().getName().equals(name)) {
                ++count;
            }
        }
        Client[] newClients = new Client[count];
        int position = 0;
        if (count < 1){
            System.out.println("Такой питомец не зарегестрирован.");
        }else {
            for (Client client : this.clients) {
                if (client != null && client.getPet().getName().equals(name)) {
                    System.out.println("Pet " + client.getPet().getName() + " belongs to " + client.getId());
                    newClients[position] = client;
                    position++;
                }
            }
        }
        return newClients;
    }

    /**
     * Получаем питомцов по имени клиента
     * @param id Имя клиента
     * @return питомцы
     */
    public Pet[] findPetsByClientId(final String id){
        int count = 0;                                      //счетчик количества совпадений по иимени питомца
        for (Client client : this.clients) {                //в цикле определяем количество совпадений
            if (client != null && client.getId().equals(id)) {
                ++count;
            }
        }
        Pet[] pets = new Pet[count];
        int position = 0;
        if (count<1){
            System.out.println("Клиент не найден.");
        }else {
            for (Client client : this.clients) {
                if (client != null && client.getId().equals(id)) {
                    System.out.println("Client " + client.getId() + " has a pet " + client.getPet().getName());
                    pets[position] = client.getPet();
                    position++;
                }
            }
        }
        return pets;
    }

    /**
     * Изменение имени питомца
     * @param id Id клиента
     * @param newPetName Новое имя питомца
     */
    public void changePetName(String id, String newPetName){
        int count = 0;
        for (Client client : this.clients){
            if (client != null && client.getId().equals(id)){
                count++;
                client.getPet().setName(newPetName);
            }
        }
        if (count == 0) System.out.println("Клиент не найден.");
    }

    /**
     * Изменение id клиента
     * @param petName Имя питомца
     * @param newId Новое id
     */
    public void changeClientId(String petName, String newId){
        int count = 0;
        for (Client client : this.clients){
            if (client != null && client.getPet().getName().equals(petName)){
                count++;
                client.setId(newId);
            }
        }
        if (count == 0) System.out.println("Питомец не найден");
    }
}
