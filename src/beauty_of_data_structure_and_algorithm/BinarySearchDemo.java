package beauty_of_data_structure_and_algorithm;

/**
 * 二分查找
 *
 *  1 需要注意的3点：
 *      *循环结束条件：low<=high!
 *      *mid的取值：mid = low + ((high - low) >> 1)!
 *      *low、high的更新：+1\-1
 *
 *  2 二分查找的变体
 *
 */
public class BinarySearchDemo {

    public static void main(String[] args) {

        int[] array = {3, 12, 16, 28, 33, 45, 58, 60, 72, 81, 90, 99};

        System.out.println("非递归：16在array的index = " + binarySearch(array, 16));

        System.out.println("递归：90在array的index = " + binarySearch2(array, 90));

    }

    /**
     * 1 - 二分查找非递归实现
     *
     * @param array 已排序数组
     * @param value 要查找的值
     * @return value所在array的index，如果-1则不存在。
     */
    private static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] == value) {
                return mid;
            } else if(array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 1 - 2 二分查找递归实现
     *
     * @param array 有序数组
     * @param value 要查找的值
     * @return value所在array的index，如果-1则不存在。
     */
    private static int binarySearch2(int[] array, int value) {
        return binarySearchRecursive(array, 0, array.length - 1, value);
    }

    private static int binarySearchRecursive(int[] array, int low, int high, int value) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] == value) {
                return mid;
            } else if(array[mid] < value) {
                return binarySearchRecursive(array, mid + 1, high, value);
            } else {
                return binarySearchRecursive(array, low, mid - 1, value);
            }
        }

        return -1;
    }

}
