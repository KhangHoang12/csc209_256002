package co.kulwadee.csc209.lect01;

public class AccountTest {
    public static void main(String[] args) {
        // create an co.kulwadee.csc209.lect01.Account object and assign it to myAccount
        Account account1 = new Account("Micheal");
        Account account2 = new Account("Linda");

        System.out.printf("Name in account1 is: %n%s%n", account1.getName());
        System.out.printf("Name in account2 is: %n%s%n", account2.getName());

    }

}
