package SingleLinkedList;

public class LinkedListTestC {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.add("apple");
        l.add("pear");

        // testing insert()
        l.insert("orange", 2);
        l.add("banana");
        System.out.println(l.get(0) + " should be apple");
        System.out.println(l.get(1) + " should be pear");
        System.out.println(l.get(2) + " should be orange");
        System.out.println(l.get(3) + " should be banana");
        System.out.println();

        // testing remove()
        l.remove(3);
        l.add("kiwifruit");
        System.out.println(l.get(0) + " should be apple");
        System.out.println(l.get(1) + " should be pear");
        System.out.println(l.get(2) + " should be orange");
        System.out.println(l.get(3) + " should be kiwifruit");
    }
}
