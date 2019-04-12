package beauty_of_data_structure_and_algorithm;

import java.util.Arrays;

public class SortDemo {

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 6, 3, 4};

        bubbleSort(array, 6);
        System.out.println("冒泡排序后：" + Arrays.toString(array));

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


    //3 - 选择排序


}
