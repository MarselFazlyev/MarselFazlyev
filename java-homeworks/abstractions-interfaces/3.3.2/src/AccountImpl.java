public abstract class AccountImpl implements Account {
    protected int balance;
    protected String name;

    public AccountImpl(int balance) {
        this.balance = balance;
    }


    public String toString() {
        return name;
    }
}



