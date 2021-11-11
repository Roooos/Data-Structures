package SingleLinkedList;

class LinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int n;
	
	public void addFirst(Object o) {
		if(head == null) {
			tail = head;
		}
		head = new ListNode(o, head);
		n++;
	}	
	
	public void add(Object o) {
		if(head == null) {
			addFirst(o);
			tail = head;
		}
		else{
			ListNode node = new ListNode(o, null);
			
			tail.next = node;
			tail = node;
			n++;
		}
	}
	
	public Object get(int i) {
		if (i<0 || i>=n) {
			return null;
		}
		
		ListNode node = head;
		
		for (int j=0; j<i; j++) {
			node = node.next;
		}
		
		return node.element;
	}
	
	public void insert(Object o, int i) {
		if (i<0 || i>n)
			return;
		
		if (i==0) {
			addFirst(o); 
			return;
		}
		if(i==n) {
			add(o);
			return;
		}
		
		ListNode node = head;  
		
		for (int j=0; j<i-1; j++) {
			node = node.next;
		}
		
		node.next = new ListNode(o, node.next);
		n++;
	}
	
	public void remove(int i) {
		if (i<0 || i>=n)
			return;
		
		if (i==0) {
			head = head.next; 
			n--; 
		return; 
		}
		
		ListNode node = head;  
		
		for (int j=0; j<i-1; j++) {
			node = node.next;
		}
		
		if(i==n-1) {
			tail = node;
			node.next = null;
			return;
		}
		
		node.next = node.next.next;
		n--;
	}
}