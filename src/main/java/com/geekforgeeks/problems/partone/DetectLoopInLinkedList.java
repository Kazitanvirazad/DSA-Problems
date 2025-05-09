package com.geekforgeeks.problems.partone;

/**
 * 
 * Given a linked list of N nodes. The task is to check if the linked list has a
 * loop. Linked list can contain self loop.
 * 
 * Example 1:
 * 
 * Input: N = 3 value[] = {1,3,4} x(position at which tail is connected) = 2
 * Output: True Explanation: In above test case N = 3. The linked list with
 * nodes N = 3 is given. Then value of x=2 is given which means last node is
 * connected with xth node of linked list. Therefore, there exists a loop.
 * Example 2:
 * 
 * Input: N = 4 value[] = {1,8,3,4} x = 0 Output: False Explanation: For N = 4
 * ,x = 0 means then lastNode->next = NULL, then the Linked list does not
 * contains any loop. Your Task: The task is to complete the function
 * detectloop() which contains reference to the head as only argument. This
 * function should return true if linked list contains loop, else return false.
 * 
 * Expected Time Complexity: O(N) Expected Auxiliary Space: O(1)
 * 
 * Constraints: 1 ≤ N ≤ 104 1 ≤ Data on Node ≤ 103
 *
 */
public class DetectLoopInLinkedList {
	public static void main(String[] args) {
		DetectLoopInLinkedList detectLoopInLinkedList = new DetectLoopInLinkedList();
		DetectLoopInLinkedList.Node node1 = detectLoopInLinkedList.new Node(1);
		DetectLoopInLinkedList.Node node2 = detectLoopInLinkedList.new Node(3);
		DetectLoopInLinkedList.Node node3 = detectLoopInLinkedList.new Node(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		System.out.println(detectLoop(node1));
	}

	public static boolean detectLoop(Node head) {
		Node sCounter = head;
		Node fCounter = head;

		boolean flag = false;

		while (sCounter != null && fCounter != null && fCounter.next != null) {
			sCounter = sCounter.next;
			fCounter = fCounter.next.next;
			if (sCounter.equals(fCounter)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
}
