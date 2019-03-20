package data_structure.stack_queue;

import java.util.*;

/**
 * 特殊的线性表 - 栈和队列 - 通过LinkedList可以实现栈和队列的操作！！！
 *
 *  特点：
 *      *栈和队列也是比较常见的数据结构，它们是比较特殊的线性表，因为：
 *          *对于栈来说，访问、插入和删除元素只能在栈顶进行，
 *          *对于队列来说，元素只能从队列尾插入，从队列头访问和删除。
 *
 *  总结：
 *      栈：栈是限制插入和删除只能在一个位置上进行的表，该位置是表的末端，叫作栈顶，
 *         对栈的基本操作有push(进栈)和pop(出栈)，前者相当于插入，后者相当于删除
 *         最后一个元素。栈有时又叫作LIFO(Last In First Out)表，即后进先出。
 *
 *         因为栈也是一个表，所以任何实现表的方法都能实现栈。我们打开JDK中的类Stack的源码，
 *         可以看到它就是继承类Vector的。当然，Stack是Java2前的容器类，现在我们可以使用
 *         LinkedList来进行栈的所有操作。
 *
 *      队列：队列是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，
 *           而在表的后端（rear）进行插入操作，和栈一样，队列是一种操作受限制的线性表。
 *           进行插入操作的端称为队尾，进行删除操作的端称为队头。
 *
 *           普通的队列是一种先进先出的数据结构，而优先队列中，元素都被赋予优先级。当访问元素的时候，
 *           具有最高优先级的元素最先被删除。优先队列在生活中的应用还是比较多的，比如医院的急症室为病
 *           人赋予优先级，具有最高优先级的病人最先得到治疗。在Java集合框架中，类PriorityQueue就
 *           是优先队列的实现类，具体大家可以去阅读源码。
 *
 *           注意：PriorityQueue是一种树结构（堆）！！！
 */
public class StackAndQueue {

    //Stack: push \ pop
    private void stackDemo() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.pop());//C
    }

    //Queue:
    private void queueDemo() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println(queue.poll());//A
    }

}
