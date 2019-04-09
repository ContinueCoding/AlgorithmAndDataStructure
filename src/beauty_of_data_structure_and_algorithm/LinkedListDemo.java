package beauty_of_data_structure_and_algorithm;

/**
 * 链表（第06~07讲）
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        Node<String> list1 = new Node<>("A", null);
        list1.next = new Node<>("B", null);
        list1.next.next = new Node<>("C", null);
        list1.next.next.next = new Node<>("D", null);

        //翻转
        printList(list1);
        list1 = reverseList(list1);
        list1 = reverseListRecursive(list1);
        printList(list1);

        //检测环
        Node<String> list2 = list1;
        //list2.next.next.next.next = list2.next; //构造环
        System.out.println("list2是否有环：" + hasCycle(list2));

        //找中间结点
        list1.next.next.next.next = new Node<>("E", null);
        System.out.println("list1的中间结点是：" + getMiddleNode(list1).data);

    }


    //region 链表常见题目
    //1-单链表翻转(非递归)
    private static Node<String> reverseList(Node<String> head) {
        if(head == null) {
            return null;
        }

        Node<String> result = null;

        //就地翻转
        Node<String> prev = null;
        Node<String> curr = head;
        Node<String> currNext = null;
        while (curr != null) {
            currNext = curr.next;

            if(currNext == null) {
                result = curr;
            }

            //翻转
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return result;
    }

    //1-单链表翻转(递归)
    private static Node<String> reverseListRecursive(Node<String> head) {
        //递归结束条件（仅剩一个结点时）
        if(head == null || head.next == null) {
            return head;
        }

        //递归
        Node<String> result = reverseListRecursive(head.next);

        //翻转头结点
        head.next.next = head;
        head.next = null;

        return result;
    }

    //2-链表中环的检测
    private static boolean hasCycle(Node<String> head) {
        if(head == null || head.next == null) {
            return false;
        }

        //快慢指针
        Node<String> slow = head;
        Node<String> fast = head.next;

        //结束条件（仅判断快指针非空即可）
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //每循环一次，判断一次是否有环！
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    //3 - 单链表找中间节点（无环单链表） - 类似2
    //TODO 区分单数、偶数个结点。
    static Node<String> getMiddleNode(Node<String> head) {
        if(head == null) {
            return null;
        }

        Node<String> slow = head;
        Node<String> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //endregion

    private static void printList(Node<String> head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data + " -> ");
            head = head.next;
        }
        System.out.println("List: " + sb.toString() + "null");
    }

    /**
     * 1 - 基于链表实现LRU缓存淘汰算法简单思路：
     *  1）如果需要的数据已经在链表中，则返回数据，且把数据移到链表头部；
     *
     *  2）如果需要的数据不在链表中，则从其他数据源获取到之后在加入链表中：
     *      *如果此时链表未满，则直接插入链表头部；
     *      *如果此时链表已满，则删除尾部的数据，将新数据插入链表头部。
     *
     *
     * 2 - 判断链表存储的字符串是否为回文字符串：
     *      思路：快慢指针找到链表中点，然后逆序前半部分，判断前后2部分是否相同即可！
     */

    //单链表节点
    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    //双向链表节点
    static class BiNode<T> {
        T data;
        BiNode<T> prev;
        BiNode<T> next;

        public BiNode(T data, BiNode<T> prev, BiNode<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
