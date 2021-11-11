package DoublyLinkedList;

class DoublyLinkedList {
    private ListNode2 head;
    private ListNode2 tail;
    private int n;

	public void addFirst(Object o) {
		if(head==null) {
			ListNode2 newNode = new ListNode2(o, null, null);
			
			head = newNode;
			tail = newNode;
			n++;
		}
		else{
			ListNode2 newNode = new ListNode2(o, null, head);
		
			head.prev = newNode;
			head = newNode;
			n++;
		}
	}
	
	 private void add(Object o) {
	    	if(head == null) {
				addFirst(o);
			}
			else{
				ListNode2 node = new ListNode2(o, tail, null);
				
				tail.next = node;
				tail = node;
				n++;
			}
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
		
		ListNode2 node = head;  
		
		for (int j=0; j<i-1; j++) {
			node = node.next;
		}
		
		ListNode2 newNode = new ListNode2(o, node, node.next);
		
		node.next = newNode;
		
		node = newNode.next;
		
		node.prev = newNode;
		
		n++;
	}
	
	public void remove(int i) {
		if (i<0 || i>=n)
			return;
		
		if (i==0) {
			if(n==1) {
				head=null;
				tail=null;
				n--;
				return;
			}
			head = head.next;
			head.prev = null;
			n--; 
		return; 
		}
		
		ListNode2 node = head;  
		
		for (int j=0; j<i-1; j++) {
			node = node.next;
		}
		
		if(i==n-1) {
			tail = node;
			node.next = null;
			return;
		}
		
		node.next = node.next.next;
		
		node = node.next;
		node.prev = node.prev.prev;
		
		n--;
	}

	public void print() {
        if (head == null) {
            System.out.println("list empty.");
            return;
        }

        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;
        }
        System.out.println();
    }
}
