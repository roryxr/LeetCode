public class ReverseLinkedList {
	public static void main(String[] args) {
		ReverseLinkedList prog = new ReverseLinkedList();
		prog.run();
	}	

	public void run() {
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l1.next = l2;
		printList(reverseBetween(l1, 1, 2));
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode start = head, prev = null, temp = null, curr = null;
		if (m == n) return head;
		if (m != 1) {
			for (int i = 0; i < m - 1; i++) start = start.next;
			prev = start.next;
		} else {
			prev = start;
		}
		curr = prev.next;
		//System.out.println(m-n);
		for (int i = 0; i < n - m; i++) {
			//System.out.println(prev.val + " " + curr.val);
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		if (m != 1) {
			start.next.next = temp;
			start.next = prev;
		} else {
			head = prev;
			start.next = temp;
		}
		return head;
	}

	public void printList(ListNode n) {
		while(n != null) {
			System.out.print(n.val + "->");
			n = n.next;
		}
		System.out.println();
	}
}
