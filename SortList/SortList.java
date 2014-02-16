public class SortList {
	public static void main(String[] args) {
		SortList prog = new SortList();
		prog.run();
	}
	
	public void run() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		n2.next = n3;
		n3.next = n1;
		n2 = sortList(n2);
		printList(n2);
	}
	
	public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode slow = head, fast = head.next, last = slow;
	        while (fast != null) {
	            last = slow;
	            slow = slow.next;
	            fast = fast.next;
	            if (fast != null)
	                fast = fast.next;
	        }
	        ListNode h1 = head, h2 = slow;
	        last.next = null;
	        h1 = sortList(h1);
	        h2 = sortList(h2);
	        return merge(h1, h2);
	    }
    
	public ListNode merge(ListNode h1, ListNode h2) {
	        ListNode dh = new ListNode(Integer.MIN_VALUE);
	        ListNode curr = dh;
	        while (h1 != null && h2 != null) {
	            if (h1.val < h2.val) {
	                curr.next = h1;
	                h1 = h1.next;
	            } else {
	                curr.next = h2;
	                h2 = h2.next;
	            }
	            curr = curr.next;
	        }
	        if (h1 != null)
	            curr.next = h1;
	        if (h2 != null)
	            curr.next = h2;
	        return dh.next;
	    }

			public void printList(ListNode h) {
				while (h != null) {
					System.out.print(h.val + " ");
					h = h.next;
				}
				System.out.println();
			}
}