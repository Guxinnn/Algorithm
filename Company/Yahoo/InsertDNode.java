package Company.Yahoo;

import leetcode.LinkedList.DNode;

/**
 * Created by Doodle on 2/11/18.
 */
public class InsertDNode {
    private DNode head;

    public InsertDNode() {
        head = new DNode(8);
    }
    public void sortInsert(DNode newNode) {

        DNode curr = null;

        if (head == null) head = newNode;
        else if (head.val >= newNode.val) {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        } else {
            curr = head;
            while (curr.next != null && curr.next.val < newNode.val) {
                curr = curr.next;
            }

            // if not insert at the end
            if (curr.next != null) {
                newNode.next = curr.next;
                curr.next.prev = newNode;
            }

            curr.next = newNode;
            newNode.prev = curr;
        }
    }

    public void printList() {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        InsertDNode i = new InsertDNode();

        i.sortInsert(new DNode(5));
        i.sortInsert(new DNode(3));
        i.sortInsert(new DNode(12));

        i.printList();
    }
}
