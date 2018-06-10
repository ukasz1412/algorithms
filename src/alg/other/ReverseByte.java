package alg.other;

public class ReverseByte {
    public static void reverse_bytes(byte[] data) {
        if (data.length == 0) return;
        int start = 0;
        int end = data.length - 1;
        if (start == end) {
            data[0] = reverseBits(data[0]);
            return;
        }
        while (start < end) {
            byte reversedEnd = reverseBits(data[end]);
            data[end] = reverseBits(data[start]);
            data[start] = reversedEnd;
            ++start;
            --end;
        }
        if (start == end) {
            data[start] = reverseBits(data[start]);
        }
    }

    public static byte reverseBits(byte a) {
        byte result = 0;
        int i = 0;
        int bits = 8;
        while (i < bits) {
            byte shift = (byte) ((a << (bits - i -1)) & 0xFF);
            byte rev = (byte) ((0x80 >> i) & shift);
            result |= rev;
            a >>= 1;
            ++i;
        }

        return result;
    }

    public static void test() {
        byte[] t1 = {126, 117, 96};
        printArray(t1);
        reverse_bytes(t1);
        printArray(t1);

        System.out.println();
        byte[] t2 = {123, 108, 33, 79};
        printArray(t2);
        reverse_bytes(t2);
        printArray(t2);
    }

    private static void printByte(byte b) {
        System.out.print(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
    }

    private static void printArray(byte[] data) {
        System.out.print("[ ");
        for (byte b : data) {
            printByte(b);
            System.out.print(" ");
        }
        System.out.println("]");
    }
}
