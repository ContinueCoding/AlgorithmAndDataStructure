package data_structure_and_algorithm.linear_list;

/**
 * 数组实现线性表 - Java具体实现可参考ArrayList源码！
 *
 *  特点：
 *      *用一组连续的存储单元依次存储线性表的数据元素；
 *      *虽然数组一旦创建之后，它的大小就无法改变了，但是当数组不能再存储线性表中的新元素时，
 *       可以创建一个新的大的数组来替换当前数组。这样就可以使用数组实现动态的数据结构。
 *
 *  总结：
 *      *优点在于可以通过下标来访问或者修改元素，比较高效，
 *
 *      *主要缺点在于插入和删除的花费开销较大，比如当在第一个位置前插入一个元素，
 *       那么首先要把所有的元素往后移动一个位置。
 *
 *      *为了提高在任意位置添加或者删除元素的效率，可以采用链式结构来实现线性表。
 */
public class LinearListByArray {

    //1 - 创建一个更大的数组来替换当前数组
    public void expandListSize() {
        int[] oldArray = new int[10];
        int[] newArray = new int[20];

        for(int i = 0; i< oldArray.length ; i++) {
            newArray[i] = oldArray[i];
        }

        // 也可以使用System.arraycopy方法来实现数组间的复制
        // System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);

        oldArray = newArray;
    }

    //2 - 在数组index位置添加元素e
    public void add(int index, int e) {
        /*
        if (index > size || index < 0) {
            System.out.println("位置不合法...");
        }

        //如果数组已经满了，就扩容！
        if (size >= oldArray.length) {
            // 扩容函数可参考代码1
        }

        for (int i = size - 1; i >= index; i--) {
            oldArray[i + 1] = oldArray[i];
        }

        //将数组elementData从位置index的所有元素往后移一位
        // System.arraycopy(oldArray, index, oldArray, index + 1,size - index);

        oldArray[index] = e;

        size++;
         */
    }

}
