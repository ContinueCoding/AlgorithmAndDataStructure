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

    public static final double EPSILON = 0.000001;

    public static void main(String[] args) {

        int[] array = {3, 12, 16, 28, 33, 45, 58, 60, 72, 81, 90, 99};

        System.out.println("非递归：16在array的index = " + binarySearch(array, 16));

        System.out.println("递归：90在array的index = " + binarySearch2(array, 90));

        System.out.println("二分求平方根：24.6的平方根 = " + getSqrt(24.6));
        System.out.println("Math.sqrt()求平方根：24.6的平方根 = " + Math.sqrt(24.6));
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

    /**
     * 2 - 使用二分法求解一个数的平方根（正数），要求精确到小数点后6位。
     *
     * @param value value(>0)
     * @return value的平方根（正数）
     */
    private static double getSqrt(double value) {
        double low = 0;
        double high = Math.max(value, 1);
        double result = low + (high - low) / 2;

        int count = 1;

        while(Math.abs(result * result - value) > EPSILON & count < 100) {

            if(result * result < value) {
                low = result;
            } else {
                high = result;
            }

            result = low + (high - low) / 2;

            count++;
        }

        System.out.println("getSqrt() - count = " + count);
        return result;
    }

}
