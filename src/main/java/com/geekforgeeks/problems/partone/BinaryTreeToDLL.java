package com.geekforgeeks.problems.partone;

/**
 * Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place. The left and right
 * pointers in nodes will be used as previous and next pointers respectively in converted DLL.
 * The order of nodes in DLL must be the same as the order of the given Binary Tree. The first node
 * of Inorder traversal (leftmost node in BT) must be the head node of the DLL.
 *
 * Note: h is the tree's height, and this space is used implicitly for the recursion stack.
 *
 * TreeToList
 *
 * Examples:
 *
 * Input:
 *       1
 *     /  \
 *    3    2
 * Output:
 * 3 1 2
 * 2 1 3
 *
 * Explanation: DLL would be 3<=>1<=>2
 * Input:
 *        10
 *       /   \
 *      20   30
 *    /   \
 *   40   60
 * Output:
 * 40 20 60 10 30
 * 30 10 60 20 40
 *
 * Explanation:  DLL would be 40<=>20<=>60<=>10<=>30.
 * Expected Time Complexity: O(no. of nodes)
 * Expected Space Complexity: O(height of the tree)
 */
public class BinaryTreeToDLL {

    public Node bToDLL(Node root) {
        inOrderTraverseToConvert(root);
        return list.getHead();
    }

    DoublyLinkedList list = new DoublyLinkedList();

    public void inOrderTraverseToConvert(Node subTree) {
        if (subTree == null) {
            return;
        }
        if (subTree.left != null) {
            inOrderTraverseToConvert(subTree.left);
        }

        list.insert(subTree);

        if (subTree.right != null) {
            inOrderTraverseToConvert(subTree.right);
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = tail = null;
            size = 0;
        }

        void insert(Node node) {
            if (head == null || size == 0) {
                head = new Node(node.data);
                tail = head;
                size++;
                return;
            }
            node.left = tail;
            tail.right = node;
            tail = tail.right;
            size++;
        }

        Node getHead() {
            return head;
        }
    }

    class Node {
        Node left, right;
        int data;

        public Node(int data) {
            left = right = null;
        }
    }
}
