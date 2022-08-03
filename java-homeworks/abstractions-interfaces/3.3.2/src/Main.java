public class Main {

    public static void main(String[] args) {
        Account account1 = new SavingsAccount(300);
        Account account2 = new CreditAccount();
        Account account3 = new CheckingAccount(1500);

        account1.transfer(account3, 25);
        account1.addMoney(200);
        account1.pay(78);
        account1.transfer(account2, 470);


        account2.pay(200);
        account2.addMoney(150);
        account2.transfer(account1, 60);

        account3.transfer(account1, 523);
        account3.addMoney(158);
        account3.pay(877);
        account3.pay(284);


    }
}
