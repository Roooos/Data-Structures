package SingleLinkedList;

public class LinkedListTestA {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        // testing addFirst()
        l.addFirst("apple");
        l.addFirst("pear");
        l.addFirst("orange");
        System.out.println(l.get(0) + " should be orange");
        System.out.println(l.get(1) + " should be pear");
        System.out.println(l.get(2) + " should be apple");
        System.out.println();

        // testing insert()
        l.insert("banana", 2);
        System.out.println(l.get(0) + " should be orange");
        System.out.println(l.get(1) + " should be pear");
        System.out.println(l.get(2) + " should be banana");
        System.out.println(l.get(3) + " should be apple");
        System.out.println();

        // testing remove()
        l.remove(2);
        System.out.println(l.get(0) + " should be orange");
        System.out.println(l.get(1) + " should be pear");
        System.out.println(l.get(2) + " should be apple");
    }
}
