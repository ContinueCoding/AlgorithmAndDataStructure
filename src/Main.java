import algorithm.sort.SortDemo;

import java.util.Arrays;

/**
 * 算法与数据结构
 *
 *  P.S.
 *   https://visualgo.net/zh 算法和数据结构动态可视化
 *   https://www.zhihu.com/question/21318658 知乎：如何学习数据结构？
 *
 *   http://data.biancheng.net/ 数据结构与算法 - C语言版！
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("algorithm and data structure...");

        int[] array = {23,5,35,4,22,67,13,55};

        SortDemo.quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}
