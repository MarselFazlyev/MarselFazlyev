public class Main {
    public static void main(String[] args) {
        BinaryMathOperations fasad = new BinaryMathOperations();
//        int value1 = Integer.parseInt("11000011",2);//десятичная форма числа 11000011 (195)
//        int value2 = Integer.parseInt("111",2);//десятичная форма числа 11000011 (7)

        String binaryResultSum = fasad.binarySum("11000011","111");
        String binaryResultMult = fasad.binaryMult("11000011", "111");
        System.out.println("****************ДВОИЧНАЯ ФОРМА РЕЗУЛЬТАТОВ ОПЕРАЦИЙ****************");
        System.out.println(binaryResultSum);
        System.out.println(binaryResultMult);

        int decimalResultSum = Integer.parseInt(binaryResultSum,2);
        int decimalResultMult = Integer.parseInt(binaryResultMult,2);
        System.out.println("****************ДЕСЯТИЧНАЯ ФОРМА РЕЗУЛЬТАТОВ ОПЕРАЦИЙ****************");
        System.out.println(decimalResultSum);
        System.out.println(decimalResultMult);










    }
}
