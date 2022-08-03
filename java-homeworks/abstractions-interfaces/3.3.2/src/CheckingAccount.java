public class CheckingAccount extends AccountImpl {


    public CheckingAccount(int balance) {
        super(balance);
        this.name = " Расчетный счет";
        System.out.println("Начальный баланс Расчетного  счета равен " + balance + " рублей.");
    }

    @Override
    public boolean pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(" Вы совершили пдатеж с расчетного счета на сумму " + amount + " рублей.");
            System.out.println(" Текущий баланс расчетного счета составляет " + balance + " рублей.");
            System.out.println();
            return true;
        } else {
            System.out.println("Cумма платежа превышает Ваш баланс расчетного счета.");
            System.out.println();
            return false;
        }


    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (balance >= amount && account.addMoney(amount)) {
            balance -= amount;
            System.out.println("Осуществлен перевод с расчетного  счета  на " + account + " в количестве " + amount + " рублей.");
            System.out.println("Текущий баланс расчетного счета составляет " + balance + " рублей.");
            System.out.println();
            return true;

        } else {
            System.out.println("Сумма перевода превышает текущий баланс по расчетному  счету!");
            System.out.println();
            return false;
        }

    }

    @Override
    public boolean addMoney(int amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Баланс Вашего расчетного  счета увеличен на " + amount + " и составляет теперь " + balance + " рублей.");
            System.out.println();
            return true;
        } else {
            System.out.println(" Введено некорректное число.");
            System.out.println();
            return false;
        }

    }
}
