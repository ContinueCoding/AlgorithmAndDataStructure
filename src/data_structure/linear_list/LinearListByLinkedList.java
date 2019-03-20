package data_structure.linear_list;

/**
 * 链表实现线性表 - Java具体实现可参考LinkedList源码！
 * <p>
 * 特点：
 * *链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的
 * 指针链接次序实现的。链表由一系列节点组成，这些节点不必在内存中相连。每个节点由
 * 数据部分Data和链部分Next，Next指向下一个节点，这样当添加或者删除时，只需要改变
 * 相关节点的Next的指向，效率很高。
 * <p>
 * *此处只考虑单链表，暂不考虑双向列表和循环列表！
 * <p>
 * 其他：
 * 链表的实现还有其它的方式，常见的有循环单链表，双向链表，循环双向链表。
 * <p>
 * *循环单链表：主要是链表的最后一个节点指向第一个节点，整体构成一个链环。
 * <p>
 * *双向链表：主要是节点中包含两个指针部分，一个指向前驱元，一个指向后继元，JDK中LinkedList集合类的实现就是双向链表。
 * <p>
 * *循环双向链表：是最后一个节点指向第一个节点。
 */
public class LinearListByLinkedList<E> {

    //1 - 链表的节点
    static class Node<E> {
        E item;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    //2 - 定义好节点后，使用前一般是对头节点和尾节点进行初始化
    Node<E> head = null;
    Node<E> tail = null;

    //3 - 添加第一个节点
    /*
        //创建一个新的节点 并让head指向此节点
        head = new Node("nodedata1", null);

        //让尾节点也指向此节点
        tail = head;
     */

    //4 - 添加一个链表（尾部添加）
    /*
        //创建新节点 同时和最后一个节点连接起来
        tail.next = new Node("node1data2");

        //尾节点指向新的节点
        tail = tail.next;
     */

    //5 - 顺序遍历链表
    /*
        Node<String> current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
     */

    //6 - 倒序遍历链表（单链表）

    //倒序遍历链表主要用了递归的思想
    static void printListRev(Node<String> head) {
        if (head != null) {
            printListRev(head.next);
            System.out.println(head.item);
        }
    }

    //7 - 翻转单链表 - 主要是[逐一改变两个节点间的链接关系]来完成!!!
    //单链表反转非递归
    static Node<String> reverseList(Node<String> head) {
        if (head == null) {
            return null;
        }

        Node<String> nodeResult = null;

        Node<String> nodePre = null;
        Node<String> current = head;
        while (current != null) {
            Node<String> nodeNext = current.next;

            if (nodeNext == null) {
                //到达链表尾部了
                nodeResult = current;
            }

            //翻转
            current.next = nodePre;
            nodePre = current;
            current = nodeNext;
        }

        return nodeResult;
    }

    //单链表翻转递归实现
    static Node<String> reverseListRecursive(Node<String> head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node<String> result = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return result;
    }

    //8 - 判断单链表是否有环
    /*
        *最容易想到的思路是存一个所有 Node 地址的 Hash 表，从头开始遍历，
         将 Node 存到 Hash 表中，如果出现了重复，则说明链表有环。

        *一个经典的方法是双指针（也叫快慢指针），使用两个指针遍历链表，
         一个指针一次走一步，另一个一次走两步，如果链表有环，两个指针必然相遇。
     */

    static boolean hasCycle(Node<String> head) {
        if(head == null) {
            return false;
        }

        Node<String> slow = head;
        Node<String> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

}
