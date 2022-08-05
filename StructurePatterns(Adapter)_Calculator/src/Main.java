public class Main {
    public static void main(String[] args) {
        System.out.println("СТАРАЯ РЕАЛИЗАЦИЯ КАЛЬКУЛЯТОРА");
        System.out.println("*********************************************");
        Calculator calculator = new Calculator();
        double oldresult = calculator.newFormula().addOperand(10).addOperand(5).calculate(Calculator.Operation.MULT).result();
        System.out.println(oldresult);
        System.out.println();
        System.out.println("НОВАЯ РЕАЛИЗАЦИЯ КАЛЬКУЛЯТОРА");
        System.out.println("*********************************************");
        Ints adapterIntsCalculator = new IntsCalculator();
        int adapterResult =   adapterIntsCalculator.mult(10,5);
        System.out.println(adapterResult);







    }



}
