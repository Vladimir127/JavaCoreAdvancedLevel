package lesson02.online;

public class Main {
    public static void main(String[] args) throws PositiveCreditException, NegativeDebitException {
        Bank bank = new Bank();
        Account account = bank.getAccount("Maria", "pass");
        account.credit(150);
    }
}
