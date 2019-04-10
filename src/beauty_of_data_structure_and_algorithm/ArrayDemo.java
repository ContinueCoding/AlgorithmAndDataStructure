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

    //TODO 自定义泛型Array类
    static class GenericArray<T> {
        private T[] data;
        private int size;

        public GenericArray() {
            this(10);
        }

        public GenericArray(int capacity) {
            data = (T[]) new Object[capacity];
            size = 0;
        }

        //获取容量
        public int getCapacity() {
            return data.length;
        }

        // 获取当前元素个数
        public int count() {
            return size;
        }

        // 判断数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        // 修改 index 位置的元素
        public void setIndex(int index, T e) {
            checkIndex(index);
            data[index] = e;
        }

        // 获取对应 index 位置的元素
        public T getIndex(int index) {
            checkIndex(index);
            return data[index];
        }

        // 查看数组是否包含元素e
        public boolean contains(T e) {
            for (int i = 0; i < size; i++) {
                if(data[i].equals(e)) {
                    return true;
                }
            }

            return false;
        }

        // 获取对应元素的下标, 未找到，返回 -1
        public int findIndexOf(T e) {
            for (int i = 0; i < size; i++) {
                if(data[i].equals(e)) {
                    return i;
                }
            }

            return -1;
        }

        // 在 index 位置，插入元素e(其他元素往后移), 时间复杂度 O(m+n)
        public void add(int index, T e) {
            checkIndex(index);

            //扩容：2倍
            if(size == data.length) {
                resize(size * 2);
            }

            //搬移数据
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }

            //插入数据到指定位置
            data[index] = e;
            size ++;
        }

        // 向数组头插入元素
        public void addFirst(T e) {
            add(0, e);
        }

        // 向数组尾插入元素
        public void addLast(T e) {
            add(size, e);
        }

        // 删除 index 位置的元素，并返回
        public T remove(int index) {
            checkIndexForRemove(index);

            T result = data[index];
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size --;

            /*
            //TODO 缩容(条件)
            if (size == data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            */

            return result;
        }

        public T removeFirst() {
            return remove(0);
        }

        public T removeLast() {
            return remove(size - 1);
        }

        public void removeElement(T e) {
            int index = findIndexOf(e);
            if(index != -1) {
                remove(index);
            }
        }

        //-----------------private方法------------------

        //扩容方法，时间复杂度 O(n)
        private void resize(int capacity) {
            T[] newData = (T[]) new Object[capacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }

        private void checkIndex(int index) {
            if(index < 0 || index > size) {
                throw new IllegalArgumentException("Invalid index for add/set: " + index);
            }
        }

        private void checkIndexForRemove(int index) {
            if(index < 0 || index >= size) {
                throw new IllegalArgumentException("Invalid index for remove: " + index);
            }
        }
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
