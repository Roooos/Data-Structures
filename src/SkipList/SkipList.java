package SkipList;

class SkipList {
	private SkipListNode[] head;
	private int n;
	
	public static void main(String[] args) {
		SkipList sl = new SkipList();
		
		sl.createTestList();
		sl.print();
		
		System.out.println(""+ sl.inList("Anne"));
		System.out.println(""+ sl.inList("Ben"));
		System.out.println(""+ sl.inList("Charlie"));
		System.out.println(""+ sl.inList("Don"));
		System.out.println(""+ sl.inList("Ernie"));
		
		sl.insert("Bob");
		sl.insert("Anne");
		sl.insert("Steve");
		sl.print();
	}
	
	public SkipList() {
		head = new SkipListNode[] {null, null, null, null, null};
		n = 0;
	}
	
	public void createTestList() {
		SkipListNode anne = new SkipListNode("Anne", 3);
		SkipListNode ben = new SkipListNode("Ben", 1);
		SkipListNode charlie = new SkipListNode("Charlie", 2);
		SkipListNode don = new SkipListNode("Don", 1);
		SkipListNode ernie = new SkipListNode("Ernie", 3);    	
		n = 5;
		
		ernie.next[0] = null;
		ernie.next[1] = null;
		ernie.next[2] = null;
		
		don.next[0] = ernie;
		
		charlie.next[0] = don;
		charlie.next[1] = ernie;
		
		ben.next[0] = charlie;
		
		anne.next[0] = ben;
		anne.next[1] = charlie;
		anne.next[2] = ernie;
		
		head[0] = anne;
		head[1] = anne;
		head[2] = anne;
	}
	
	public void print() {
		
		for(int i = 4; i >= 0; i--){
			
			while(head[i] == null) {
				i--;
			}
			SkipListNode node = head[i];
			do {
				System.out.printf(node.element + ", ");
				node = node.next[i];
			}while(node != null);
			
			System.out.printf("\n");
		}
	}
	
	public boolean inList(String s) {
		int i = n-1;
		
		while(head[i] == null) {
			i--;
		}
		SkipListNode node = head[i];
		
		if(node.element.compareTo(s) == 0) return true;
		
		while(i >= 0){
			if(node.next[i]==null) i--;
			else {	
				int compare = node.next[i].element.compareTo(s);
				
				if(compare == 0) return true;
				else if(compare > 0) i--;
				else node = node.next[i];
			}	
		}
		return false;
	}
	
	public void insert(String s) {
		SkipListNode newNode = new SkipListNode(s);
		SkipListNode node = head[n-1];
		int size = newNode.next.length;
		int i = size-1;
		boolean headNode = true;
		
		System.out.println(size);
		
		while(i >= 0 && headNode) {
			if(head[i] == null) {
				if(i < 5) {
					head[i] = newNode;
					newNode.next[i] = null;
				}
				i--;
			}else {
				if(head[i].element.compareTo(s) <= 0) {
					headNode = false;
					
				}else {
					newNode.next[i] = head[i];
					head[i] = newNode;
					i--;
				}
			}
		}
		node = head[i];
		
		while(i >= 0) {
			if(node.next[i] == null) {
				if(i <= size) {
					node.next[i] = newNode;
					newNode.next[i] = null;
					i--;
				}else {
					i--;
				}
			}else {
				if(node.next[i].element.compareTo(s) <= 0) {
					node = node.next[i];
				}else {
					newNode.next[i] = node.next[i];
					node.next[i] = newNode;
					i--;
				}
			}
		}
	}
}
