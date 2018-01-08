package leetcode.LinkedList;

public class MergeTwoSortedList {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

      if (l1 == null) return l2;
      if (l2 == null) return l1;

      ListNode dummy = new ListNode(0);
      ListNode prev = dummy;

      while (l1 != null && l2 != null) {
          if (l1.val <= l2.val) {
              prev.next = l1;
              prev = prev.next;
              l1 = l1.next;
          } else {
              prev.next = l2;
              prev = prev.next;
              l2 = l2.next;
          }
      }

      if (l1 == null) {
          prev.next = l2;
      }

      if (l2 == null) {
          prev.next = l1;
      }

      return dummy.next;
  }
}