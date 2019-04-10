package beauty_of_data_structure_and_algorithm;

//队列
public class QueueDemo {

    public static void main(String[] args) {

    }

    //1-基于数组的队列 - TODO【重点】enqueue支持数据搬移！
    static class ArrayQueue {
        private String[] data;
        private int capacity;
        //头（出队）、尾（入队）
        private int head, tail;

        public ArrayQueue(int capacity) {
            data = new String[capacity];
            this.capacity = capacity;
        }

        /**
         * 入队 - 数据搬移
         *
         * @param item 元素
         * @return 成功与否
         */
        public boolean enqueue(String item) {
            //队尾没有空间时才考虑数据搬移！！！
            if (tail == capacity) {
                if (head == 0) {
                    //队列满
                    return false;
                }

                //队列头有空余空间 - 搬移head~tail之间的元素到0~tail-head之间！
                for (int i = head; i < tail; i++) {
                    data[i - head] = data[i];
                }

                //搬移完毕 - 更新head、tail
                tail -= head;
                head = 0;
            }

            data[tail] = item;
            tail++;
            return true;
        }

        /**
         * 出队
         *
         * @return 元素
         */
        public String dequeue() {
            //队列空条件
            if (head == tail) {
                return null;
            }

            String result = data[head];
            head++;
            return result;
        }


    }

    //2-基于链表的队列 - TODO 【重点】dequeue时考虑只有一个元素的情况（更新tail指针）！
    static class LinkListQueue {
        private Node head, tail;

        /**
         * 入队 - 肯定成功 - 操作tail
         *
         * @param data data
         */
        public void enqueue(String data) {
            if(tail == null) {
                //添加第一个元素
                Node newNode = new Node(data, null);
                head = tail = newNode;
            } else {
                //从队尾插入新元素
                tail.next = new Node(data, null);
                tail = tail.next;
            }
        }

        /**
         * 出队 - 操作head
         *
         * @return
         */
        public String dequeue() {
            if(head == null) {
                return null;
            }

            String result = head.data;
            head = head.next;

            //TODO 只有一个元素的队列（head = tail, 指向唯一的元素），执行一次出队后，需要置空tail！
            if(head == null) {
                tail = null;
            }

            return result;
        }

    }

    static class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //3-循环队列（数组） - TODO 【重点】队空、队满条件 & 循环+1
    //浪费一个空间！
    static class CircularQueue {
        private String[] data;
        private int capacity;
        private int head, tail;

        public CircularQueue(int capacity) {
            data = new String[capacity];
            this.capacity = capacity;
        }

        /**
         * 入队
         *
         * @param item
         * @return
         */
        public boolean enqueue(String item) {
            //队满条件
            if ((tail + 1) % capacity == head) {
                return false;
            }

            data[tail] = item;
            tail = (tail + 1) % capacity;
            return true;
        }

        /**
         * 出队
         *
         * @return
         */
        public String dequeue() {
            //队空条件！
            if (head == tail) {
                return null;
            }

            String result = data[head];
            head = (head + 1) % capacity;
            return result;
        }
    }
}
