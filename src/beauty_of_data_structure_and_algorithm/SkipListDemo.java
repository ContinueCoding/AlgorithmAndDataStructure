package beauty_of_data_structure_and_algorithm;

import java.util.Random;

/**
 * 跳表的一种实现方法。
 * * 跳表中存储的是正整数，并且存储的是不重复的。
 *
 * TODO 理解代码关键点！
 *  1 - 每次插入数据的时候随机产生的level:决定了新节点的层数；
 *  2 - 数组update的作用：用以存储新节点所有层数上，各自的前一个节点的信息；
 *  3 - 节点内的forwards数组：用以存储该节点所有层的下一个节点的信息；
 *  4 - 当所有节点的最大层级变量maxlevel=1的时候，跳表退化成一个普通链表。
 *
 *  跳表性能分析：
 *      1 - 查找、插入、删除的时间复杂度：O(logn);
 *      2 - 跳表的空间复杂度：O(n);
 *      3 - 跳表索引动态更新：随着插入数据的增加，可能导致某两个索引结点之间的数据结点越来越多，
 *                         从而导致跳表退化为单链表！解决方法：通过随机函数解决！当插入结点时，
 *                         通过随机函数的值K，决定将此节点同时插入到1~K级索引中即可！
 *      4 - 跳表实现了基于链表的二分查找！
 *
 */
public class SkipListDemo {
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // 带头链表

    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwards(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node height
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    // 随机 level 次，如果是奇数层数 +1，防止伪随机
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    //跳表结点
    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }
}
