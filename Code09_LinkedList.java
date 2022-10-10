/**
 * 单链表：值，一条next指针。单链表实现队列和栈。
 * 双链表：值，一条next指针，一条last指针。
 * 单双链表经典问题：给定单（双）链表的头head，完成链表的逆序调整
 */

public class Code09_LinkedList {
    public static void main(String[] args) {

    }

    // 单结点
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 双结点
    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    // 单链表反转
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 双链表反转
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head.last = next;
            head = next;
        }
        return pre;
    }
}
