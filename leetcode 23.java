import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    // Merge K Sorted Lists
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    // Create a linked list
    public static ListNode createList(Scanner sc, int size) {
        if (size == 0) return null;

        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < size; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of linked lists: ");
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {

            System.out.print("Enter size of list " + (i + 1) + ": ");
            int size = sc.nextInt();

            System.out.println("Enter elements in sorted order:");
            lists[i] = createList(sc, size);
        }

        ListNode result = mergeKLists(lists);

        System.out.println("\nMerged Linked List:");
        printList(result);

        sc.close();
    }
}
