package algorithm.sort;

import java.util.Arrays;

/**
 * 排序算法 - 从小到大排序！
 *
 *  【1 - 插入排序】
 *      1-1 直接插入排序
 *
 *      1-2 Shell排序
 *
 *  【2 - 选择排序】
 *      2-1 直接选择
 *
 *      2-2 堆排序
 *
 *  【3 - 交换排序】
 *      3-1 冒泡排序
 *
 *      3-2 快速排序
 *
 *  【4 - 归并排序】
 *
 *  【5 - 基数排序】
 *
 *
 *  P.S.
 *      https://www.cnblogs.com/bjh1117/p/8335628.html
 *      https://www.cnblogs.com/bjh1117/p/8343886.html
 *
 *      https://segmentfault.com/a/1190000014008568 八大基础排序总结
 */
public class SortDemo {

    //region 1 - 插入排序

    /**
     * 1-1 直接插入排序
     *  基本思想：是将一个记录插入到已排好序的有序表中，从而得到一个新的、记录数增1的有序表。
     *
     *  分析：最好情况下，当待排序序列中记录已经有序时，则需要n-1次比较，不需要移动，时间复杂度为O(n)。
     *       最差情况下，当待排序序列中所有记录正好逆序时，则比较次数和移动次数都达到最大值，时间复杂度为 O(n^2) 。
     *       平均情况下，时间复杂度为 O(n^2)。
     *
     *  性能：
     *      时间复杂度：平均 - O(n^2); 最佳 - O(n); 最差 - O(n^2);
     *      空间复杂度：O(1)
     *
     *  稳定性：稳定！
     */
    public static void insertSort(int[] array) {
        ////外层向右的index，即作为比较对象的数据的index
        for (int index = 1; index < array.length; index++) {
            //用作比较的数据 or 需要插入的数据！
            int insertData = array[index];
            int leftIndex = index - 1;

            //当比到最左边或者遇到比temp小的数据时，结束循环
            while (leftIndex >= 0 && array[leftIndex] > insertData) {
                //将已排序的序列中比insertData大的数往后移动一个位置！
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }

            //把temp放到空位上
            array[leftIndex + 1] = insertData;
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 1-2 Shell排序 - 又称缩小增量排序
     *
     *  基本思想、具体流程：
     * 　　1、将包含n个元素的数组，分成n/2个数组序列，第一个数据和第n/2+1个数据为一对...
     * 　　2、对每对数据进行比较和交换，排好顺序；
     * 　　3、然后分成n/4个数组序列，再次排序；
     * 　　4、不断重复以上过程，随着序列减少并直至为1，排序完成。
     *
     *  直观上看：就是把数列进行分组(不停使用插入排序)，直至从宏观上看起来有序，最后插入排序起来就容易了(无须多次移位或交换)。
     *
     *          *可以用一个序列来表示增量：{n/2,(n/2)/2...1}，每次增量都/2。
     *
     *  性能：
     *      时间复杂度：平均 - O(n^1.3); 最佳 - O(n); 最差 - O(n^2);
     *      空间复杂度：O(1)
     *
     *  稳定性：稳定！
     */
    public static void shellSort(int[] array) {
        //增量每次都减半
        for (int step = array.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < array.length; i++) {

                //记录需要插入的元素
                int j = i;
                int temp = array[j];

                // j - step 就是代表与它同组隔壁（左侧）的元素 - 插入排序！
                while (j - step >= 0 && array[j - step] > temp) {
                    array[j] = array[j - step];
                    j = j - step;
                }

                //插入到正确位置
                array[j] = temp;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    //endregion

    //region TODO 2 - 选择排序

    /**
     * 2-1 简单选择排序
     *  基本思想：设排序序列的记录个数为n，进行n-1次选择，每次在n-i+1(i = 1,2,...,n-1)个记录
     *          中选择关键字最小的记录作为有效序列中的第i个记录。
     *
     *  分析：简单选择排序过程中需要进行的比较次数与初始状态下待排序的记录序列的排列情况无关。
     *       当i=1时，需进行n-1次比较；当i=2时，需进行n-2次比较；依次类推，共需要进行的比较
     *       次数是(n-1)+(n-2)+…+2+1=n(n-1)/2，即进行比较操作的时间复杂度为 O(n^2) ，
     *       进行移动操作的时间复杂度为 O(n) 。总的时间复杂度为 O(n^2)。
     *
     *  性能：
     *      时间复杂度：平均 - O(n^2); 最佳 - O(n^2); 最差 - O(n^2);
     *      空间复杂度：O(1)
     *
     *  稳定性：不稳定！
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            //每次从未排序数组中找到最小值的index
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            //将最小值放在最前面
            if(minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * TODO 2-2 堆排序 - VIP！！！
     *
     *
     */
    public static void heapSort() {

    }

    //endregion

    //region 3 - 交换排序

    /**
     * 3-1 冒泡排序
     *  基本思想：设排序序列的记录个数为n，进行n-1次遍历，每次遍历从开始位置依次往后比较前后相邻元素，
     *          这样较大的元素往后移，n-1次遍历结束后，序列有序。
     *
     *  注意：如果在某次遍历中没有发生交换，那么就不必进行下次遍历，因为序列已经有序 - flag标记位。
     *
     *  性能：
     *      时间复杂度：平均 - O(n^2); 最佳 - O(n); 最差 - O(n^2);
     *      空间复杂度：O(1)
     *
     *  稳定性：稳定！
     */
    public static void bubbleSort(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * TODO 3-2 快速排序 - VIP!!!
     *
     *  基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
     *          然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以[递归]进行，以此达到整个数据变成有序序列。
     *
     *  更简单的理解：在数组中找一个支点(任意),经过一趟排序后，支点左边的数都要比支点小，支点右边的数都要比支点大！
     *
     *  性能：
     *      时间复杂度：平均 - O(n*logn); 最佳 - O(n*logn); 最差 - O(n^2);
     *      空间复杂度：O(n*logn)
     *
     *  稳定性：不稳定！
     *
     *  TODO：http://www.cnblogs.com/noKing/archive/2017/11/29/7922397.html 快速排序 & 优化！
     *
     * @param array 待排序数组
     * @param left  数组最左侧元素index
     * @param right 数组最右侧元素index
     */
    public static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;

        //支点
        int pivot = array[(left + right) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描（此while保证了第一趟排序支点的左边比支点小，支点的右边比支点大！）
        while (i <= j) {

            //从最左侧正序寻找，直到找到比支点大的数
            while (array[i] < pivot) {
                i++;
            }

            //从最右侧逆序寻找，直到找到比支点小的数
            while (array[j] > pivot) {
                j--;
            }

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                //继续while循环，查找下一组需要交换的元素！
                i++;
                j--;
            }
        }

        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if(left < j) {
            quickSort(array, left, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if(right > i) {
            quickSort(array, i, right);
        }
    }


    //endregion

    //region TODO 4 - 归并排序

    /**
     * 4 归并排序
     *
     *  基本思想：将待排序序列分为两部分，对每部分递归地应用归并排序，在两部分都排好序后进行合并。
     *
     *  注意：
     *
     *  性能：
     *      时间复杂度：平均 - O(log2n); 最佳 - O(log2n); 最差 - O(log2n);
     *      空间复杂度：O(n)
     *
     *  稳定性：稳定！
     */
    public static void mergeSort(int[] array) {


        System.out.println(Arrays.toString(array));
    }

    //endregion

    //region TODO 5 - 基数排序


    //endregion
}
