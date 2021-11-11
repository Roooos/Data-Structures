package SingleLinkedList;

public class LinkedListTestB {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        // testing add()
        l.add("apple");
        l.add("pear");
        l.add("orange");
        System.out.println(l.get(0) + " should be apple");
        System.out.println(l.get(1) + " should be pear");
        System.out.println(l.get(2) + " should be orange");
    }
}
