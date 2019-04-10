package beauty_of_data_structure_and_algorithm;

//递归
public class RecursionDemo {

    public static void main(String[] args) {

        System.out.println("斐波那契数列（n = 9）：" + fibonacci(9));
        System.out.println("斐波那契数列（n = 9）：" + fibonacci2(9));
        System.out.println();

        System.out.println("最大公约数（24， 36）：" + gcd(36, 24));
        System.out.println("最大公约数（24， 36）：" + gcd2(24, 36));
        System.out.println();

        System.out.println("最大公约数（24， 36）：" + lcm(24, 36));
        System.out.println();

        System.out.println("台阶方法（10）：" + getCount(10));
        System.out.println("台阶方法（10）：" + getCount2(10));
        System.out.println();


    }

    //1 - fibonacci数列
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static long fibonacci2(int index) {
        //1-定义初始值
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;

        if (index == 0) {
            return f0;
        } else if (index == 1) {
            return f1;
        } else if (index == 2) {
            return f2;
        }

        //2 - 循环求第index个值！
        for (int i = 3; i <= index; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }

    //2 - 最大公约数
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        //System.out.println("gcd(): a = " + a + ", b = " + b);
        return gcd(b, a % b);
    }

    public static long gcd2(long a, long b) {
        long r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    //3 - 最小公倍数
    public static long lcm(long a, long b) {
        long ab = a * b;
        return ab / gcd(a, b);
    }

    //4 - 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走n个台阶有多少种走法？
    public static long getCount(long n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return getCount(n - 1) + getCount(n - 2);
    }

    public static long getCount2(long n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        long ret = 0;
        long pre = 2;
        long prepre = 1;

        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }

        return ret;
    }

    //TODO 5 河内塔

}
