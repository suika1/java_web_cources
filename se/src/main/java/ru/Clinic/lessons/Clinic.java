package ru.Clinic.lessons;

/**
 * Клиника
 * Created by suika1 on 07.01.2018.
 */
public class Clinic {
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
                System.out.println("Client " + client.getId() + " has a "+client.getPet().getClass().getSimpleName()+" "+ client.getPet().getName());
        }

    }

    /**
     * Добавить клиента
     */
    public void addClient(final int position, final Client newClient) throws UserException{
        for (Client client: this.clients)
            if (client != null && client.getId().equals(newClient.getId())
                    && client.getPet().getName().equals(newClient.getPet().getName())
                    && client.getPet().getClass() == newClient.getPet().getClass()) {
                throw new UserException("Этот клиент с этим питомцем уже есть в базе данных");
            }
        this.clients[position] = newClient;
    }

    /**
     * Получаем клиентов по имени питомца
     * @param name Имя питомца
     * @return Клиенты
     */
    public Client[] findClientsByPetName(final String name) throws UserException{
        int count = 0;                                      //счетчик количества совпадений по иимени питомца
        for (Client client : this.clients) {                //в цикле определяем количество совпадений
            if (client != null && client.getPet().getName().equals(name)) {
                ++count;
            }
        }
        Client[] newClients = new Client[count];
        int position = 0;
        if (count < 1){
            throw new UserException("Такой питомец не зарегестрирован.");
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
    public Pet[] findPetsByClientId(final String id) throws UserException{
        int count = 0;                                      //счетчик количества совпадений по иимени питомца
        for (Client client : this.clients) {                //в цикле определяем количество совпадений
            if (client != null && client.getId().equals(id)) {
                ++count;
            }
        }
        Pet[] pets = new Pet[count];
        int position = 0;
        if (count<1){
            throw new UserException("Клиент не найден.");
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
    public void changePetName(String id, String newPetName) throws UserException{
        int count = 0;
        for (Client client : this.clients){
            if (client != null && client.getId().equals(id)){
                count++;
                client.getPet().setName(newPetName);
            }
        }
        if (count == 0)
            throw new UserException("Клиент не найден");
    }

    /**
     * Изменение id клиента
     * @param petName Имя питомца
     * @param newId Новое id
     */
    public void changeClientId(String petName, String newId) throws UserException{
        int count = 0;
        for (Client client : this.clients){
            if (client != null && client.getPet().getName().equals(petName)){
                count++;
                client.setId(newId);
            }
        }
        if (count == 0)
            throw new UserException("Питомец не найден");
    }

    /**
     * Удаление записей про клиента
     * @param id id клиента
     */
    public void deleteRecordsById(String id){
        int count = 0;
        int size = 0;
        for (Client client : this.clients){
            if (client != null && client.getId().equals(id)){
                for (Client client1 : this.clients){
                    if (client1 != null)
                        size++;   // считаем размер заполненного массива
                }
                System.out.println("SIZE == "+size+"\n");
                this.clients[count]=this.clients[size];
                this.clients[size]=null;
            }
            count++;
        }
    }

    /**
     * Удаление записей про питомца
     * @param name Имя питомца
     */
   public void deleteRecordsByName(String name){
       int count = 0;
       int size = 0;
       for (Client client : this.clients){
           if (client != null && client.getPet().getName().equals(name)){
               for (Client client1 : this.clients){
                   if (client1 != null)
                       size++;   // считаем размер заполненного массива
               }
               System.out.println("SIZE == "+size+"\n");
               this.clients[count]=this.clients[size];
               this.clients[size]=null;
           }
           count++;
       }
    }
}