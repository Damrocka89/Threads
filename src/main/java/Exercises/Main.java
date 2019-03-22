package Exercises;

public class Main {
    public static void main(String[] args) {
        final Exercises.BankAccount account=new Exercises.BankAccount("12345-678",1000.00);

        new Thread(()->{
            account.deposit(300.00);
            System.out.println(account.getBalance());
            account.withdraw(50.00);
            System.out.println(account.getBalance());
        }).start();

        new Thread(()->{
            account.deposit(203.75);
            System.out.println(account.getBalance());
            account.withdraw(100.00);
            System.out.println(account.getBalance());
        }).start();

    }
}
