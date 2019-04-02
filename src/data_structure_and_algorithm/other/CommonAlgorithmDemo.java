package data_structure_and_algorithm.other;

/**
 * 其他常用算法介绍
 *
 */
public class CommonAlgorithmDemo {

    //region 算法思想分类
    //1 - 递归算法 - 斐波纳契数列
    /**
     * 递归实现斐波那契数列 - 简单 & 效率低！
     * @param index 第index个值
     * @return
     */
    public static long fibonacci(int index) {
        if(index == 0) {
            return 0;
        } else if(index == 1) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }

    //非递归实现
    public static long fibonacci2(int index) {
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

        //循环求第index个值！
        for (int i = 3; i <= index; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }

    //递归求最大公约数
    public int gcd(int a, int b) {
        if(a == 0) {
            return b;
        } else {
            return gcd(b, a%b);
        }
    }

    //非递归求最大公约数
    public int gcd2(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //2 - 分治算法
    /*
        分治算法的思想是将待解决的问题分解为几个规模较小但类似于原问题的子问题，
        递归地求解这些子问题，然后合并这些子问题的解来建立最终的解。分治算法中
        关键地一步其实就是递归地求解子问题。关于分治算法的一个典型例子就是上面
        介绍的归并排序。
     */


    //3 - 动态规划算法
    /*
        动态规划与分治方法相似，都是通过组合子问题的解来求解待解决的问题。但是，
        分治算法将问题划分为互不相交的子问题，递归地求解子问题，再将它们的解组合起来，
        而动态规划应用于子问题重叠的情况，即不同的子问题具有公共的子子问题。
        动态规划方法通常用来求解最优化问题。
     */

    //4 - 贪心算法

    //5 - 回溯算法等等等等
    //endregion

    //region TODO 1 - 15道使用频率极高的基础算法题
    //http://www.codeceo.com/article/15-algorithms-question.html


    //endregion


    //region TODO 2 - 二叉树算法题
    //https://blog.csdn.net/luckyxiaoqiang/article/details/7518888


    //endregion

    //region TODO 4 - 字符串算法题
    //http://blog.chinaunix.net/uid-20498361-id-1940276.html

    //endregion

    // region TODO 4 - 链表算法题
    //https://blog.csdn.net/kerryfish/article/details/24043099

    //endregion

}
