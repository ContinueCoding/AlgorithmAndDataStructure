package beauty_of_data_structure_and_algorithm;

/**
 * 二分查找
 *
 *  1 需要注意的3点：
 *      *循环结束条件：low<=high!
 *      *mid的取值：mid = low + ((high - low) >> 1)!
 *      *low、high的更新：+1\-1
 *
 *  2 二分查找的变体 - 4种
 *
 *  3 循环有序数组的二分查找
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


        //二分查找的变体：
        int[] array2 = {1, 3, 4, 5, 6, 8, 8, 8, 13, 15};

        System.out.println("二分查找变体1：第一个8 = " + binarySearch_FindFirst(array2, 8));
        System.out.println("二分查找变体2：最后一个8 = " + binarySearch_FindLast(array2, 8));
        System.out.println("二分查找变体3：第一个大于等于7 = " + binarySearch_FindFirstGE(array2, 7));
        System.out.println("二分查找变体4：第一个小于等于7  = " + binarySearch_FindFirstLE(array2, 7));

        //二分查找循环有序数组
        int[] array3 = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println("循环数组二分查找：6的索引 = " + binarySearch_CircularArray(array3, 6));
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

    //TODO 二分查找变体：数组存在相等的值！

    /**
     * 3-1 二分查找变体1 - 查找第一个值等于给定值的元素！
     *
     * @param array 数组
     * @param value 待查找的元素
     * @return 索引
     */
    private static int binarySearch_FindFirst(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] == value) {
                if(mid == 0 || array[mid - 1] != value) {
                    //如果mid是第一个元素 或者 mid是连续n个相等元素的第一个，则直接返回！
                    return mid;
                } else {
                    //否则，此时mid为连续n个相等元素的第x个（x>=2）,所以此时要更新high的值！
                    high = mid - 1;
                }
            } else if(array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 3-2 二分查找变体2 - 查找最后一个值等于给定值的元素！
     *
     * @param array 数组
     * @param value 待查找的元素
     * @return 索引
     */
    private static int binarySearch_FindLast(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] == value) {
                if((mid == array.length - 1) || array[mid + 1] != value) {
                    //如果mid是最后一个元素 或者 mid是连续n个相等元素的最后一个，则直接返回！
                    return mid;
                } else {
                    //否则，此时mid为连续n个相等元素的第x个（非最后一个）,所以此时要更新low的值！
                    low = mid + 1;
                }
            } else if(array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 3-3 二分查找变体3 - 查找第一个大于等于给定值的元素
     * @param array 数组
     * @param value 待查找值
     * @return 索引
     */
    private static int binarySearch_FindFirstGE(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] >= value) {
                // 如果mid大于等于value，则可以判断在mid左侧（含mid）
                // 如果mid = 0 或 mid左边第一个小于value，则可确定mid就是要找的元素；否则，更新high！
                if(mid == 0 || array[mid - 1] < value) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 3-4 二分查找变体4 - 查找第一个小于等于给定值的元素
     * @param array 数组
     * @param value 待查找值
     * @return 索引
     */
    private static int binarySearch_FindFirstLE(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] <= value) {
                // 如果mid小于等于value，则可以判断在mid右侧（含mid）
                // 如果mid = length - 1 或 mid右边第一个大于value，则可确定mid就是要找的元素；否则，更新low！
                if(mid == array.length - 1 || array[mid + 1] > value) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 4 二分查找扩展 - 循环有序数组！
     *
     *  循环数组特性：以数组中间元素分隔，会把循环数组分为一个有序数组和一个循环有序数组！
     *
     * @param array 数组
     * @param value 待查找值
     * @return 索引
     */
    private static int binarySearch_CircularArray(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(array[mid] == value) {
                return mid;
            } else if(array[low] < array[mid]) {
                //左半部分有序 - 则判断value是否在左侧
                if(array[low] <= value && array[mid] >= value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //右半部分有序 - 则判断value是否在右侧
                if(array[mid] <= value && array[high] >= value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

}
