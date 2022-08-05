public class BinaryMathOperations implements MathOperationable {

    @Override
    public String binarySum(String a, String b) {
        int c = Integer.parseInt(a, 2);
        int d = Integer.parseInt(b, 2);
        int sum = c + d;
        return Integer.toBinaryString(sum);
    }

    @Override
    public String binaryMult(String a, String b) {
        int c = Integer.parseInt(a, 2);
        int d = Integer.parseInt(b, 2);
        int mult = c * d;
        return Integer.toBinaryString(mult);
    }
}
