package algorithm.search;

/**
 * 查找算法
 *
 *  顺序查找
 *      顺序查找又称线性查找。它的过程为：从查找表的最后一个元素开始逐个与给定关键字比较，若某个记录的关键字和给定值比较相等，
 *      则查找成功，否则，若直至第一个记录，其关键字和给定值比较都不等，则表明表中没有所查记录查找不成功，它的缺点是效率低下。
 *
 *  二分查找 - 有序表！
 *      二分查找又称折半查找，对于有序表来说，它的优点是比较次数少，查找速度快，平均性能好。
 *      二分查找的时间复杂度为O(logn)
 *
 *
 */
public class SearchDemo {

    /**
     * 二分查找
     * @param array 数组 - 从小到大排序！
     * @param data 需要查找的数据
     * @return data的index
     */
    public int binarySearch(int[] array, int data) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(array[mid] > data) {
                high = mid - 1;
            } else if(array[mid] < data) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
