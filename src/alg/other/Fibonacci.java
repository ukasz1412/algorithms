package alg.other;

public class Fibonacci {

    private static final int F0 = 1;
    private static final int F1 = 1;

    public static long  sumEvenValued_solution1(int limit) {
        long sum = 0;
        int fn1 = F0, fn2 = F1;
        boolean fn1Even = false;
        boolean fn2Even = false;

        int i = 0;

        while (i <= limit) {
            int f3tmp = nextNumber(fn1, fn2);
            //Both numbers are odd - so next one is even
            if (!fn1Even && !fn2Even) {
                sum += f3tmp;
                ++i;
                fn2Even = true;
            //odd / even combination
            } else if (fn2Even) {
                fn1Even = true;
                fn2Even = false;
            //even / odd combination
            } else {
                fn1Even = false;
                fn2Even = false;
            }
            fn1 = fn2;
            fn2 = f3tmp;

        }
        return sum;
    }

    private static int nextNumber(int f1, int f2) {
        return f1 + f2;
    }

    public static long  sumEvenValued_solution2(int limit) {
        long sum = 0;
        int fn1 = F0, fn2 = F1;

        int i = 0;

        while (i <= limit) {
            //store temp f(n)
            int nextEven = nextNumber(fn1, fn2);
            sum += nextEven;
            //calculate next odd pair
            //fn1 now represents f(n+1)
            fn1 = nextNumber(fn2, nextEven);
            //this is f(n+2) = f(n) + f(n+1)
            fn2 = nextNumber(fn1, nextEven);
            ++i;

        }
        return sum;
    }

    public static void test() {
        long res1 = Fibonacci.sumEvenValued_solution1(100);
        long res2 = Fibonacci.sumEvenValued_solution2(100);
        System.out.println("Solution 1 result: " + res1);
        System.out.println("Solution 2 result: " + res2);
        System.out.println("Are the equal: " + (res1 == res2));
    }

}
