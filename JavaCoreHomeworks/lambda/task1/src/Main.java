
public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(5, 1);
        int c = calc.multiplay.apply(12, 2);
        int d = 0;
        try {
            d = calc.devide.apply(56, 0);
            // в случае деления на ноль возвращаю значение null
            // и перехватываю ошибку NullPointerException.
        } catch (NullPointerException e) {
            System.out.println("Осуществлена невозможная операция:Деление на ноль! ");
        }
        int e = calc.pow.apply(34);
        int g = calc.abs.apply(-2);
        boolean h = calc.isPositive.test(-50);

        calc.println.accept(a);
        calc.println.accept(b);
        calc.println.accept(c);
        calc.println.accept(d);
        calc.println.accept(e);
        calc.println.accept(g);
        System.out.println(h);


    }
}
