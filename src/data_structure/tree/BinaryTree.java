package data_structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树 - 树型结构是一类非常重要的非线性数据结构，其中以树和二叉树最为常用。
 *
 *  树：是由n（n>=1）个有限节点组成一个具有层次关系的集合。它具有以下特点：
 *      *每个节点有零个或多个子节点；
 *      *没有父节点的节点称为 根 节点；
 *      *每一个非根节点有且只有一个 父节点 ；
 *      *除了根节点外，每个子节点可以分为多个不相交的子树。
 *
 *  【二叉树】：二叉树是每个节点最多有两棵子树的树结构。通常子树被称作“左子树”和“右子树”。
 *        *满二叉树：所有非叶子节点都有左右2个子节点 - 一棵深度为k，且有2^k-1个节点的二叉树称之为 满二叉树 ；
 *        *完全二叉树（堆）：深度为k，有n个节点的二叉树，当且仅当其每一个节点都与深度为k的满二叉树中，序号为1至n的节点对应时，称之为 完全二叉树 。
 *
 *        *常用实现：二叉查找树（排序二叉树）和二叉堆（优先级队列） —— 重要！！！
 *
 *        *3种遍历方法：二叉树主要是由3个基本单元组成，根节点、左子树和右子树。如果限定先左后右，
 *                    那么根据这三个部分遍历的顺序不同，可以分为：
 *                    *[先序遍历 - 根左右]
 *                    *[中序遍历 - 左根右]
 *                    *[后续遍历 - 左右根]
 *
 *  树和二叉树的区别：
 *      *二叉树每个节点最多有2个子节点，树则无限制；
 *      *二叉树中节点的子树分为左子树和右子树，即使某节点只有一棵子树，也要指明该子树是左子树还是右子树，即二叉树是有序的；
 *      *树决不能为空，它至少有一个节点，而一棵二叉树可以是空的。
 *
 *  【二叉查找树\二叉排序树\二叉搜索树】：二叉查找树或者是一棵空树，或者是具有下列性质的二叉树：
 *      (1) 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *      (2) 若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *      (3) 左、右子树也分别为二叉排序树；
 *      (4) 没有键值相等的结点。
 *
 *      *性能分析：对于二叉查找树来说，当给定值相同但顺序不同时，所构建的二叉查找树形态是不同的！
 *              *最坏情况下，当先后插入的关键字有序时，构成的二叉查找树蜕变为单支树，树的深度为n，其平均查找长度(n+1)/2(和顺序查找相同），
 *               最好的情况是二叉查找树的形态和折半查找的判定树相同，其平均查找长度和log2(n)成正比。
 *               平均情况下，二叉查找树的平均查找长度和logn是等数量级的，
 *              所以为了获得更好的性能，通常在二叉查找树的构建过程需要进行“平衡化处理”，之后我们将介绍平衡二叉树和红黑树，这些均可以使查找树的高度为O(log(n))。
 *
 *      *
 *
 *
 *  【堆 - 完全二叉树 - 数组实现】：TODO http://www.cnblogs.com/swiftma/p/6006395.html
 *
 *
 *  【平衡二叉树 - AVL树】：平衡二叉树又称AVL树，它或者是一棵空树，或者是具有下列性质的二叉树：
 *                       它的左子树和右子树都是平衡二叉树，且左子树和右子树的深度之差的绝对值不超过1。
 *
 *
 *  【红黑树】：红黑树是平衡二叉树的一种，它保证在最坏情况下基本动态集合操作的事件复杂度为O(log n)。红黑树和平衡二叉树区别如下：
 *              (1) 红黑树放弃了追求完全平衡，追求【大致平衡】，在与平衡二叉树的时间复杂度相差不大的情况下，
 *                  【保证每次插入最多只需要三次旋转就能达到平衡】，实现起来也更为简单。
 *
 *              (2) 平衡二叉树追求绝对平衡，条件比较苛刻，实现起来比较麻烦，每次插入新节点之后需要旋转的次数不能预知。
 *
 *  【B-树、B+树、B*树】：
 *
 *
 *  TODO: P.S. https://www.cnblogs.com/swiftma/p/5968867.html
 *
 */
public class BinaryTree<E extends Comparable<E>> {

    //0 - 根
    TreeNode<E> root;

    //1 - 二叉树的节点
    class TreeNode<E extends Comparable<E>> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
        }
    }

    //region 2 - 递归（前、中、后序、层次）遍历
    public void preOrder(TreeNode<E> root) {
        if(root != null) {
            System.out.println(root.element + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode<E> root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.element + "");
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode<E> root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.element + "");
        }
    }

    public void levelOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }

        int depth = depth(root);
        for (int i = 1; i <= depth; i++) {
            levelOrder(root, i);
        }
    }

    //层次遍历某层 - 递归！
    private void levelOrder(TreeNode<E> root, int level) {
        if(root == null || level < 1) {
            return;
        }

        if(level == 1) {
            System.out.println(root.element + " ");
            return;
        }

        levelOrder(root.left, level - 1);
        levelOrder(root.right, level - 1);
    }

    //获取树的深度 - 递归！
    public int depth(TreeNode<E> root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
    //endregion

    //region TODO 3 - 非递归（前、中、后序、层次）遍历 - 需要Stack、Queue的辅助!!!
    public void nonRecursivePreOrder(TreeNode<E> root) {
        Stack<TreeNode<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //从根节点开始一直遍历输出其值 以及 其左节点的值！
            while (root != null) {
                System.out.println(root.element + " ");
                stack.push(root);
                root = root.left;
            }

            //遍历完左节点 - 取最底部左节点的右节点重复上述步骤即可！
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public void nonRecursiveInOrder(TreeNode<E> root) {
        Stack<TreeNode<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //从根节点开始一直将其 以及 其左节点入栈！
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //遍历完左节点 - 取最底部左节点输出，然后取其右节点！
            if(!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.element + " ");
                root = root.right;
            }
        }
    }

    //TODO 2个栈 - 有待理解！
    public void nonRecursivePostOrder(TreeNode<E> root) {
        Stack<TreeNode<E>> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while (root != null || !stack1.isEmpty()) {

            while (root != null) {
                stack1.push(root);
                stack2.push(0);
                root = root.left;
            }

            while (!stack1.isEmpty() && stack2.peek() == i) {
                stack2.pop();
                System.out.println(stack1.pop().element + " ");
            }

            if (!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                root = stack1.peek();
                root = root.right;
            }
        }
    }

    //非递归层次遍历
    public void nonRecursiveLevelOrder(TreeNode<E> root) {
        if(root == null) {
            return;
        }

        TreeNode<E> currentNode;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            //取出（get and remove）
            currentNode = queue.poll();

            System.out.println(currentNode.element + " ");

            //先加左后加右
            if(currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }
    //endregion

    //region 4 查找
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if(e.compareTo(current.element) > 0) {
                current = current.right;
            } else if(e.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                return true;
            }
        }

        return false;
    }
    //endregion

    //region 5 插入节点
    public boolean insert(E e) {
        if(root == null) {
            // 如果之前是空二叉树 插入的元素就作为根节点
            root = createNode(e);
        } else {
            // 否则就从根节点开始遍历 - 直到找到合适的父节点
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if(e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else if(e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else {
                    return false;
                }

                //插入
                if(e.compareTo(current.element) > 0) {
                    parent.right = createNode(e);
                } else if(e.compareTo(current.element) < 0) {
                    parent.left = createNode(e);
                }
            }

        }

        return true;
    }

    private TreeNode<E> createNode(E e) {
        return new TreeNode<>(e);
    }
    //endregion

    //region TODO 6 删除节点
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        // 找到要删除的节点的位置
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        // 没找到要删除的节点
        if (current == null) {
            return false;
        }

        // 考虑第一种情况：current节点没有左孩子，那么只需要将patent节点和current节点的右孩子相连！
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            // 考虑第二种情况：current节点有一个左孩子，假设rightMost指向包含current节点的左子树中最大元素的节点，
            // 而parentOfRightMost指向rightMost节点的父节点。那么先使用rightMost节点中的元素值替换current节点
            // 中的元素值，将parentOfRightMost节点和rightMost节点的左孩子相连，然后删除rightMost节点。

            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            // 找到左子树中最大的元素节点
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            // 替换
            current.element = rightMost.element;

            // parentOfRightMost和rightMost左孩子相连
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else {
                parentOfRightMost.left = rightMost.left;
            }
        }

        return true;
    }
    //endregion
}
