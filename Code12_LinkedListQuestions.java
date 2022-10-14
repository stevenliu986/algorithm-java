public class Code12_LinkedListQuestions {
    public static void main(String[] args) {

    }

    // 1. K个结点的组内逆序调整
    // 给定一个单链表的头结点head，和一个正数k，实现k个结点的小组内部逆序，如果最后一组不够k个就不调整
    // 如：调整前：1->2->3->4->5->6->7->8, k=3
    //    调整后：3->2->1->6->5->4->7->8
    public static class ReverseNodesInKGroup {
        public static ListNode getKGroupEnd(ListNode start, int k) {
            while (--k != 0 && start != null) {
                start = start.next;
            }
            return start;
        }

        public static void reverse(ListNode start, ListNode end) {
            end = end.next;
            ListNode pre = null;
            ListNode next;
            ListNode cur = start;
            while (cur != end) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            start.next = end;
        }

        public static ListNode reverseKGroup(ListNode head, int k) {
            ListNode start = head;
            ListNode end = getKGroupEnd(start, k);
            // 如果链表的长度小于k，则直接返回头结点
            if (end == null) return head;
            // 代码跑到这里说明第一组凑齐了。将head指向第一组的end，最后要返回这个head
            head = end;
            reverse(start, end);
            ListNode lastEnd = start;
            while (lastEnd.next != null) {
                start = lastEnd.next;
                end = getKGroupEnd(start, k);
                if (end == null) return head;
                reverse(start, end);
                lastEnd.next = end;
                lastEnd = start;
            }
            return head;
        }

        public static class ListNode {
            public int value;
            public ListNode next;
        }

    }


    // 2. 两个链表相加
    // 给定两个链表的头结点head1和head2, 认为从左到右是某个数字从低位到高位，返回相加之后的链表
    // 如： 4->3->6  2->5->3。返回 6->8->9。解释： 634+352=986

}
