package beauty_of_data_structure_and_algorithm;

import java.util.Arrays;

public class SortDemo {

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 6, 3, 4};
        bubbleSort(array, 6);
        System.out.println("array冒泡排序后：" + Arrays.toString(array));

        int[] array1 = {2, 5, 1, 6, 3, 4, 8, 7};
        insertSort(array1, 8);
        System.out.println("array1插入排序后：" + Arrays.toString(array1));
    }

    //1 - 冒泡排序
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

    //2 - 插入排序
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

    //3 - 选择排序


}
