public class CreditAccount extends AccountImpl {

    public CreditAccount() {
        super(0);
        this.name = "Кредитный счет";
        System.out.println("Начальный баланс Кредитного счета равен " + this.balance + " рублей.");

    }

    @Override
    public boolean pay(int amount) {
        balance -= amount;
        System.out.println(" Вы совершили пдатеж с кредитного счета на сумму " + amount + " рублей.");
        System.out.println(" Текущий баланс кредитного счета составляет " + balance + " рублей.");
        System.out.println();
        return true;

    }

    @Override
    public boolean transfer(Account account, int amount) {
        System.out.println("Некорректная операция- Вы не можете совершать переводы денежных средств  по Кред.счету.");
        System.out.println();
        return false;

    }

    @Override
    public boolean addMoney(int amount) {
        if (balance < 0 && amount >= 0 && amount <= Math.abs(balance)) {
            balance += amount;
            System.out.println("Ваш кредитный счет пополнен на " + amount + " рублей.");
            System.out.println("Баланс Вашего кредитного счета составляет " + balance + " рублей.");
            System.out.println();
            return true;
        } else if (amount > Math.abs(balance)) {
            System.out.println("Сумма пополнения баланса  по Вашему кредитному счету превышает задолженность по кредиту.");
            System.out.println("Баланс Вашего кредитного  счета составляет " + balance + " рублей.");
            System.out.println();
            return false;
        } else if (balance == 0) {
            System.out.println("Данный кредитный счет не нуждается в пополнении.");
            System.out.println();
            return false;
        } else System.out.println("Некорректная операция по кредитному счету.");
        System.out.println();
        return false;

    }
}
