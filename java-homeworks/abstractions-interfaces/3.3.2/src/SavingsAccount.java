public class SavingsAccount extends AccountImpl {

    public SavingsAccount(int balance) {
        super(balance);
        this.name = " Cберегательный счет";
        System.out.println("Начальный баланс Сберегательного счета равен " + balance + " рублей.");
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Некорректная операция- Вы не можете заплатить по Сбер.счету.");
        System.out.println();
        return false;
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (account.addMoney(amount) && balance >= amount) {
            balance -= amount;
            System.out.println("Осуществлен перевод со сберегательного счета  на " + account + " в количестве " + amount + " рублей.");
            System.out.println("Текущий баланс cберегательного счета составляет " + balance + " рублей.");
            System.out.println();
            return true;
        } else if (balance < amount) {
            System.out.println("Сумма перевода превышает текущий баланс по сберегательному счету!");
            System.out.println();
            return false;
        } else {
            System.out.println("Перевод со сбер. счета не произведен, овердрафт на кредитном счете не  предусмотрен");
            return false;
        }


    }

    @Override
    public boolean addMoney(int amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Баланс Вашего сберегательного счета увеличен на " + amount + " и составляет теперь " + balance + " рублей.");
            System.out.println();
            return true;
        } else {
            System.out.println("Введено некорректное число.");
            System.out.println();
            return false;
        }

    }
}
