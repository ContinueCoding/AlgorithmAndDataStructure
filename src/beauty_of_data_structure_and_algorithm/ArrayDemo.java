package beauty_of_data_structure_and_algorithm;

import java.util.Arrays;

//数组（第05讲）
public class ArrayDemo {

    public static void main(String[] args) {

        int[] array = new int[10];

        boolean insertResult = insert(array, 1, 22);
        if(insertResult) {
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("插入失败！");
        }

        boolean insertResult2 = insert(array, 3, 18);
        if(insertResult2) {
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("插入失败！");
        }
    }

    /**
     * 将value插入array的第index位置。
     *  *不考虑array的某个位置是否有值；
     *  *不考虑array满的情况（最后一个值丢失）；
     *
     *
     * @param array 待插入数组
     * @param index 需要插入的位置（0 ~ array.length-1）
     * @param value 需要插入的值
     * @return 是否插入成功
     */
     private static boolean insert(int[] array, int index, int value) {
        //边界判断
        if (index < 0 || index >= array.length) {
            return false;
        }

        //数据搬移（倒序）- 时间复杂度：O(n)
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }

        //插入
        array[index] = value;

        return true;
    }

    /**
     * insert()改进：数据搬移耗费时间，对于不需要有序的数组，可以直接把
     *              index原有数据搬到数组末尾，然后把新值插入到index位置！
     */

    /**
     * 数组的删除：为了保持连续性，也需要数据搬移，时间复杂度O(n)。
     *
     * 改进：对于不追求数据连续性的情况，当执行删除时，仅仅标记此位置的数据无效，
     *      在后续需要插入元素 & 空间不足时，才执行数据清空！会提高删除效率！
     *
     *      参考Android SparseArray的实现！
     */

    /**
     * 数组可以随机访问的原因：连续内存 & 相同类型数据！公式如下：
     *
     *      a[i]_address = base_address + i * data_type_size;
     *
     *      a[i][j]_address = base_address + (i * n + j) * data_type_size;
     */
}
