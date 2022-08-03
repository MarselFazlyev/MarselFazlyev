
class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите радиус окружности в см:");
        int radius = scanner.nextInt();
        final double pI = 3.14;
        double area = pI * radius * radius;
        System.out.println("Площадь круга:" + area + "см");
        double length = 2 * pI * radius;
        System.out.println("Длина окружности:" + length + "см");
    }


}

