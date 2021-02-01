package lesson02.online;

public class Account {
    private double balance;
    private double maxOverdraft;
    private String code;
    private String identifiantClient;

    public Account(double balance, double maxOverdraft, String code, String identifiantClient) {
        this.balance = balance;
        this.maxOverdraft = maxOverdraft;
        this.code = code;
        this.identifiantClient = identifiantClient;
    }

    public void debit(double summ) throws NegativeDebitException{
        if (summ < 0){
            throw new NegativeDebitException("Summ cannot be " + summ);
        }
        balance += summ;
    }

    public void credit(double summ) throws PositiveCreditException{
        if (summ > 0){
            throw new PositiveCreditException("Summ cannot be " + summ);
        }
        balance += summ;
    }

    public void consulterBalance(){
        System.out.println("Your balance is " + balance + " $");
    }
}
