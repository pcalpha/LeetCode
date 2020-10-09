package cn.com.pcalpha;


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q2_Add2Number {

  public static void main(String[] args) {
//    ListNode x1 = new ListNode(2);
//    ListNode x2 = new ListNode(4);
//    ListNode x3 = new ListNode(3);
//
//    x1.next = x2;
//    x2.next = x3;
//
//    ListNode y1 = new ListNode(5);
//    ListNode y2 = new ListNode(6);
//    ListNode y3 = new ListNode(4);
//
//    y1.next = y2;
//    y2.next = y3;

    ListNode x1 = new ListNode(1);
    ListNode x2 = new ListNode(8);

    x1.next = x2;

    ListNode y1 = new ListNode(0);

    Solution solution = new Solution();
    System.out.println(solution.addTwoNumbers(x1, y1));
    //System.out.println(solution.mi(10));
  }

  static class ListNode {
    int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode x = l1;//获取链表头部
      ListNode y = l2;//获取链表头部
      int overFlag = 0;//进位标志
      ListNode header = new ListNode(0);
      ListNode curr = header;
      do {
        if (null == x) {
          x = new ListNode(0);//已经到链尾的补0
        }
        if (null == y) {
          y = new ListNode(0);//已经到链尾的补0
        }
        int sum = x.val + y.val + overFlag;

        //是否需要进位
        if (sum > 9) {
          overFlag = 1;
        } else {
          overFlag = 0;
        }

        curr.next = new ListNode(sum % 10);//计算结果
        x = x.next;
        y = y.next;
        curr = curr.next;
      } while (x != null || y != null);

      //如果链表最后发生进位，则需要补一位
      if (overFlag == 1) {
        curr.next = new ListNode(1);
      }
      return header.next;
    }
  }
}



