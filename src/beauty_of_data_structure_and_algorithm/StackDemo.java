package beauty_of_data_structure_and_algorithm;

import java.util.Arrays;

//栈 - 第08讲
public class StackDemo {

    public static void main(String[] args) {

        //1 - 数组栈
        ArrayStack arrayStack = new ArrayStack(6);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        arrayStack.pop();
        arrayStack.printStack();

        //2 - 链表栈
        LinkListStack listStack = new LinkListStack();
        listStack.push("A");
        listStack.push("B");
        listStack.push("D");
        listStack.push("E");
        listStack.pop();
        listStack.printStack();

    }

    //TODO 栈的应用
    /**
     * 1 - []{}()括号的匹配 - 单个栈；
     *
     * 2 - 模拟浏览器的前进后退 - 两个栈；
     *
     * 3 - 表达式求值（数字、加减乘除4种运算符） - 两个栈
     */

    //基于[数组]实现栈 - 指定栈的大小！
    static class ArrayStack{

        private String[] data;
        private int size;//当前元素个数
        private int length;//数组长度

        public ArrayStack(int length) {
            this.length = length;
            data = new String[length];
            size = 0;
        }

        /**
         * 入栈
         * @param string 入栈元素
         * @return 入栈是否成功
         */
        public boolean push(String string) {
            if(size == length) {
                return false;
            }

            data[size] = string;
            size ++;
            return true;
        }

        /**
         * 出栈
         * @return 栈顶元素
         */
        public String pop(){
            if(size == 0) {
                return null;
            }

            String result = data[size-1];
            //data[size-1] = null;
            size--;
            return result;
        }

        public void printStack(){
            System.out.println("Stack: " + Arrays.toString(data));
        }
    }

    //TODO 基于[链表]实现栈 - 操作链表头部!!!
    static class LinkListStack {
        //仅需栈顶指针即可（next指向后续元素）
        private Node top;

        public LinkListStack() {
            top = null;
        }

        //在链表头部插入栈顶元素
        public void push(String string) {
            Node node = new Node(string, null);

            if (top == null) {
                top = node;
            } else {
                node.next = top;
                top = node;
            }

        }

        //出栈链表头部数据
        public String pop() {
            if (top == null) {
                return null;
            }

            String result = top.data;
            top = top.next;
            return result;
        }

        //打印Stack
        public void printStack() {
            StringBuilder sb = new StringBuilder();
            while (top != null) {
                sb.append(top.data + " -> ");
                top = top.next;
            }
            System.out.println("List: " + sb.toString() + "null");
        }
    }

    //链表结点（String）
    static class Node{
        String data;
        Node next;

        Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
