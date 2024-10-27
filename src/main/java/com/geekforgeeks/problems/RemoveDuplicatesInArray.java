package com.geekforgeeks.problems;

import java.util.ArrayList;

/**
 * Given an array arr consisting of positive integers numbers, remove all duplicates numbers.
 *
 * Example:
 *
 * Input: arr[] = [2, 2, 3, 3, 7, 5]
 * Output: [2, 3, 7, 5]
 * Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
 * Input: arr[] = [2, 2, 5, 5, 7, 7]
 * Output: [2, 5, 7]
 * Explanation: After removing the duplicates 2, 5 and 7 we get 2 5 7.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class RemoveDuplicatesInArray {
    public static void main(String[] args) {
        RemoveDuplicatesInArray removeDuplicatesInArray = new RemoveDuplicatesInArray();
        int[] arr1 = {2, 2, 3, 3, 7, 5};
        int[] arr2 = {2, 2, 5, 5, 7, 7};
        int[] arr3 = {2, 2, 3, 3, 7, 5, 1, 1, 3, 3};
        removeDuplicatesInArray.removeDuplicate(arr3).forEach(ele -> System.out.print(ele + " "));
    }

    public ArrayList<Integer> removeDuplicate(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            if (!tree.contains(arr[i])) {
                tree.insert(arr[i]);
                list.add(arr[i]);
            }
        }
        return list;
    }

    class BinarySearchTree {
        Node root;

        BinarySearchTree() {
            this.root = null;
        }

        void insert(int data) {
            if (root == null) {
                this.root = new Node(data);
                return;
            }
            insert(data, root);
        }

        void insert(int data, Node subTree) {
            if (subTree != null) {
                if (data > subTree.data) {
                    if (subTree.right == null) {
                        subTree.right = new Node(data);
                    } else {
                        insert(data, subTree.right);
                    }
                } else if (data < subTree.data) {
                    if (subTree.left == null) {
                        subTree.left = new Node(data);
                    } else {
                        insert(data, subTree.left);
                    }
                }
            }
        }

        boolean contains(int item) {
            if (isEmpty()) {
                return false;
            }
            return contains(item, root);
        }

        boolean contains(int item, Node subTree) {
            if (subTree == null) {
                return false;
            }
            if (item == subTree.data) {
                return true;
            }
            if (item > subTree.data) {
                return contains(item, subTree.right);
            } else {
                return contains(item, subTree.left);
            }
        }

        boolean isEmpty() {
            return this.root == null;
        }
    }

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
