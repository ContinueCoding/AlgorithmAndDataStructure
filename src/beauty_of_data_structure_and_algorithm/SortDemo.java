package beauty_of_data_structure_and_algorithm;

import java.util.Arrays;

/**
 * 排序算法
 *  如何分析一个排序算法：
 *      1）算法的执行效率：
 *          *最好、最坏、平均情况时间复杂度；
 *          *时间复杂度的系数、常数、低阶；
 *          *比较次数或交换（移动）次数。
 *
 *      2）算法的内存消耗：
 *          *O(1) \ O(n)：排序的数据量很大时尤为重要；
 *
 *      3）算法的稳定性：
 *          *如果参与排序的字段有多个，且有优先级时，稳定性是必须要考虑的因素。
 *
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] array0 = {2, 5, 1, 6, 3, 4};
        bubbleSort(array0, 6);
        System.out.println("array0冒泡排序后：" + Arrays.toString(array0));

        int[] array1 = {2, 5, 1, 6, 3, 4, 8, 7};
        insertSort(array1, 8);
        System.out.println("array1插入排序后：" + Arrays.toString(array1));

        int[] array2 = {2, 5, 1, 6, 8, 7, 3, 4};
        selectSort(array2);
        System.out.println("array2选择排序后：" + Arrays.toString(array2));

        int[] array3 = {9, 2, 5, 1, 10, 6, 8, 7, 3, 4};
        mergeSort(array3, 10);
        System.out.println("array3归并排序后：" + Arrays.toString(array3));

        int[] array4 = {8, 2, 6, 1, 5, 9, 4, 3, 7};
        quickSort(array4, 9);
        System.out.println("array4快速排序后：" + Arrays.toString(array4));

        int[] array5 = {8, 2, 6, 1, 5, 9, 4, 3, 10, 7};
        quickSort2(array5, 0, 9);
        System.out.println("array5快速排序（2）后：" + Arrays.toString(array5));
    }

    /**
     * 1 - 冒泡排序
     *
     *  *空间复杂度：O(1);
     *  *稳定性：稳定；
     *  *时间复杂度：最好 - O(n); 最坏 - O(n^2); 平均 - O(n^2)
     *
     * @param array 数组
     * @param n 数组长度
     */
    public static void bubbleSort(int[] array, int n) {
        if(n <= 1) {
            return;
        }

        //标记位
        boolean hasChange = false;
        for (int i = 0; i < n; i++) {
            hasChange = false;
            for (int j = 0; j < n - i - 1; j ++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    hasChange = true;
                }
            }

            //某次遍历过程中没有交换，则已经有序！
            if(!hasChange) {
                break;
            }
        }
    }

    /**
     * 2 - 插入排序
     *
     *  *空间复杂度：O(1);
     *  *稳定性：稳定；
     *  *时间复杂度：最好 - O(n); 最坏 - O(n^2); 平均 - O(n^2)
     *
     * @param array 数组
     * @param n 数组长度
     */
    public static void insertSort(int[] array, int n) {
        if(n <= 1) {
            return;
        }

        //查找插入的位置
        for (int i = 1; i < n; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(array[j] > temp) {
                    array[j + 1] = array[j];//数据后移
                } else {
                    //必须break！
                    break;
                }
            }

            //插入指定位置
            array[j + 1] = temp;
        }
    }

    //插入排序版本二：
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
     * 3 - 选择排序
     *
     *  *空间复杂度：O(1);
     *  *稳定性：不稳定；
     *  *时间复杂度：最好 - O(n^2); 最坏 - O(n^2); 平均 - O(n^2)
     *
     * @param array 数组
     */
    public static void selectSort(int[] array) {
        if(array == null || array.length <= 1) {
            return;
        }

        //外层循环代表本次查找的最小值需要替换的位置
        for (int i = 0; i < array.length - 1; i++) {
            //初始值 - 本次循环后需要替换的位置
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
    }

    /**
     * 4 归并排序
     *
     *  *空间复杂度：O(n);
     *  *稳定性：稳定；
     *  *时间复杂度：最好\最坏\平均 - O(nlogn)
     *
     * @param array array
     * @param n length
     */
    public static void mergeSort(int[] array, int n) {
        mergeSortRecursive(array, 0, n-1);
    }

    /**
     * 归并排序递归过程
     * @param array array
     * @param start array的起始index
     * @param end array的结束index（含）
     */
    private static void mergeSortRecursive(int[] array, int start, int end) {
        //终止条件
        if(start >= end) {
            return;
        }

        int middle = (start + end)/2;
        mergeSortRecursive(array, start, middle);//递归左半边数组
        mergeSortRecursive(array, middle + 1, end);//递归右半边数组
        merge(array, start, middle, end);//merge已排好序的2个子数组
    }

    //合并array数组的前[start, middle)、后[middle, end)2部分
    private static void merge(int[] array, int start, int middle, int end) {
        //空间复杂度
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= end) {
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            array[start + l] = temp[l];
        }
    }

    /**
     * 5 快速排序
     *
     *  *空间复杂度：O(1);
     *  *稳定性：不稳定；
     *  *时间复杂度：最好 - O(nlogn); 最坏 - O(n^2); 平均 - O(nlogn)
     *
     * @param array 数组
     * @param length 数组长度
     */
    public static void quickSort(int[] array, int length) {
        quickSortRecursive(array, 0, length - 1);
    }

    //快速排序的递归过程 & 终止条件
    private static void quickSortRecursive(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }

        int partition = partition(array, start, end);
        quickSortRecursive(array, start, partition - 1);
        quickSortRecursive(array, partition + 1, end);
    }

    /*
        快速排序的分区函数：选择一个pivot，然后把array分为小于pivot、大于pivot的两部分，然后返回pivot的下标

        思路：
     */
    private static int partition(int[] array, int start, int end) {

        int pivot = array[end];

        int i = start;
        for (int j = i ; j < end; j ++) {
            if(array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
        }

        //i即为pivot的下标
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    /**
     * 5-2 快速排序2 - VIP!!!
     *
     *  基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
     *          然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以[递归]进行，以此达到整个数据变成有序序列。
     *
     *  更简单的理解：在数组中找一个支点(任意),经过一趟排序后，支点左边的数都要比支点小，支点右边的数都要比支点大！
     *
     *  性能：
     *      时间复杂度：平均 - O(n*logn); 最佳 - O(n*logn); 最差 - O(n^2);
     *      空间复杂度：O(1)
     *
     *  稳定性：不稳定！
     *
     *  TODO：http://www.cnblogs.com/noKing/archive/2017/11/29/7922397.html 快速排序 & 优化！
     *
     * @param array 待排序数组
     * @param left  数组最左侧元素index
     * @param right 数组最右侧元素index
     */
    private static void quickSort2(int[] array, int left, int right) {
        int i = left;
        int j = right;

        //支点 - 取中间的元素作为pivot
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
            quickSort2(array, left, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if(right > i) {
            quickSort2(array, i, right);
        }
    }

}
