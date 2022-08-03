public interface Account {
    boolean pay(int amount);

    boolean transfer(Account account, int amount);

    boolean addMoney(int amount);


}
