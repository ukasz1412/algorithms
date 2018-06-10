package alg.datastruct;

public class DoublyLinkedList {

    private Node first;
    private Node last;
    private int size;

    public void insertFirst(int value) {
        Node tmp = new Node(value);
        if (first == null) {
            first = tmp;
            last = tmp;
        } else {
            first.prev = tmp;
            tmp.next = first;
            first = tmp;
        }
        ++size;
    }

    public void insertLast(int value) {
        Node tmp = new Node(value);
        if (last == null) {
            first = tmp;
            last = tmp;
        } else {
            last.next = tmp;
            tmp.prev = last;
            last = tmp;
        }
        ++size;
    }

    public void remove(int i) {
        if (i >= size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException size: " + size + ", index: " + i);
        } else {
            if (size == 1) {
                first = null;
                last = null;
            } else if (i == 0) {
                first = first.next;
                first.prev = null;
            } else if (i == size - 1) {
                last = last.prev;
                last.next = null;
            } else {
                Node tmp = first;
                int j = 0;
                while (j < i) {
                    tmp = tmp.next;
                    ++j;
                }
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                tmp.next = null;
                tmp.prev = null;
            }
            --size;
        }
    }

    public void print() {
        Node n = first;
        System.out.print("[");
        while (n != null) {
            System.out.print(n.value +" ");
            n = n.next;
        }
        System.out.print("]");
    }

    public void printReverse() {
        Node n = last;
        System.out.print("[");
        while (n != null) {
            System.out.print(n.value +" ");
            n = n.prev;
        }
        System.out.print("]");
    }

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void test() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(-1);
        list.insertFirst(-2);
        list.insertLast(1);
        list.insertFirst(-3);
        list.insertFirst(-4);
        list.insertLast(4);
        list.insertFirst(-5);

        list.print();
        System.out.println();
        list.printReverse();
        System.out.println();

        list.remove(0);
        list.remove(0);
        list.print();
        System.out.println();

        list.remove(3);
        list.print();
        System.out.println();

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.print();
        System.out.println();

        list.remove(0);
        list.print();
        System.out.println();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
