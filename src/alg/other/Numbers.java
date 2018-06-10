package alg.other;

public class Numbers {

    private static final int ASCII_SHIFT = 55;

    public static String decimalToAnotherRepresentation(int base, int input) {
        StringBuilder builder = new StringBuilder();
        int current = input;
        while (true) {
            int div = current / base;
            if (div > 0) {
                append(builder, current - (div * base));
                current = div;
            } else {
                append(builder, current);
                break;
            }

        }
        return builder.reverse().toString();
    }

    private static void append(StringBuilder builder, int sign) {
        if (sign < 10) {
            builder.append(sign);
        } else {
            builder.append((char) (sign + ASCII_SHIFT));
        }
    }

    public static void test() {
        System.out.println(decimalToAnotherRepresentation(36, 35));
        System.out.println(decimalToAnotherRepresentation(2, 255));
        System.out.println(decimalToAnotherRepresentation(10, 123456789));
        System.out.println(decimalToAnotherRepresentation(30, 900901));
    }
}
