package lesson02.online;

import java.io.*;

public class Bank {
    private Account[] clients = {new Account(150, 100, "pass", "Maria")};

    public Bank(){

    }

    public Bank(String fileName) throws IOException {
        initializeClients(fileName);
    }

    public void initializeClients(String fileName) throws IOException {
        File fileObject = new File(fileName);
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileObject);
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis!=null){
                fis.close();
            }
            if (ois != null){
                ois.close();
            }
        }
    }

    public Account getAccount(String identifiant, String code){
        for (Account account: clients){
            if (account.getIdentifiantClient().equals(identifiant)) {
            }
        }
    }

    public Account createAccount(){
        return null;
    }

    public void saveData(){
        File fileObject = new File("clients");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileObject))){
            oos.writeObject(clients);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
