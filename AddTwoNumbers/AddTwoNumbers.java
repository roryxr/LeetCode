pblic class AddTwoNumbers {
	public static void main(String[] args) {
		AddTwoNumbers prog = new AddTwoNumbers();
		prog.run();
	}

	public void run() {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode l3 = new ListNode(3);
		//l2.next = l3;
		ListNode result = addTwoNumbers(l1, l2);
		printList(result);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(l1 == null && l2 == null) return null;
		if(len(l1) > len(l2)) l2 = addZeros(l2, len(l1)-len(l2));
		else if(len(l1) < len(l2)) l1 = addZeros(l1, len(l2) - len(l1));
		//System.out.println(len(l1) + " " + len(l2));
		int carry = 0;
		int sum = l1.val + l2.val;
		if(sum >= 10) {
			carry = 1;
			sum -= 10;
		}
		ListNode head = new ListNode(sum);
		ListNode curr = head;
		l1 = l1.next;
		l2 = l2.next;
		while(l1 != null) {
			sum = l1.val + l2.val + carry;
			if(sum >= 10) {
				carry = 1;
				sum -= 10;
			}
			else carry = 0;
			curr.next = new ListNode(sum);
			curr = curr.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(carry == 1) curr.next = new ListNode(1);
		return head;
	}

	public int len(ListNode l) {
		int count = 0;
		while(l != null) {
			count++;
			l = l.next;
		}
		return count;
	}
	public ListNode addZeros(ListNode l, int count){
		if(l == null) {
			ListNode head = new ListNode(0);
			ListNode curr = head;
			for(int i = 0; i < count - 1; i++) {
				curr.next = new ListNode(0);
				curr = curr.next;
			}
			return head;
		}
		ListNode head = l;
		while(l.next != null) l = l.next;
		for(int i = 0; i < count; i++) {
			l.next = new ListNode(0);
			l = l.next;
		}
		return head;
	}
	public void printList(ListNode l){
		while(l != null) {
			System.out.print(l.val + "->");
			l = l.next;
		}
		System.out.println();
	}
}
