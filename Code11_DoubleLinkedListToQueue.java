import java.util.Deque;
import java.util.LinkedList;

/**
 * 双向链表实现双端队列
 */

public class Code11_DoubleLinkedListToQueue {
    public static void main(String[] args) {
        // 测试代码
        testDoubleQueue();
    }

    // 测试双端队列
    public static void testDoubleQueue() {
        MyDoubleQueue<Integer> myDoubleQueue = new MyDoubleQueue<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDoubleQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myDoubleQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDoubleQueue.insertHead(num);
                    test.addFirst(num);
                } else {
                    myDoubleQueue.insertTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDoubleQueue.isEmpty()) {
                    int num1, num2;
                    if (Math.random() < 0.5) {
                        num1 = myDoubleQueue.popHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDoubleQueue.popTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myDoubleQueue.isEmpty()) {
                    int num1, num2;
                    if (Math.random() < 0.5) {
                        num1 = myDoubleQueue.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDoubleQueue.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myDoubleQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myDoubleQueue.isEmpty()) {
            int num1 = myDoubleQueue.popHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static class Node<V> {
        public V value;
        public Node<V> next;
        public Node<V> last;

        public Node(V v) {
            value = v;
            next = null;
            last = null;
        }
    }

    public static class MyDoubleQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // 在头部添加结点
        public void insertHead(V value) {
            Node<V> currentNode = new Node<>(value);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                currentNode.next = head;
                head.last = currentNode;
                head = currentNode;
            }
            size++;
        }

        // 在头部弹出结点
        public V popHead() {
            if (head == null) return null;
            size--;
            V value = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return value;
        }

        // 查看头部结点的值
        public V peekHead() {
            if (head == null) return null;
            return head.value;
        }

        // 在尾部添加结点
        public void insertTail(V value) {
            Node<V> currentNode = new Node<>(value);
            if (tail == null) {
                head = currentNode;
            } else {
                tail.next = currentNode;
                currentNode.last = tail;
            }
            tail = currentNode;
            size++;
        }

        // 在尾部弹出结点
        public V popTail() {
            if (tail == null) return null;
            size--;
            V value = tail.value;
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return value;
        }

        // 查看尾部结点的值
        public V peekTail() {
            if (tail == null) return null;
            return tail.value;
        }
    }
}
