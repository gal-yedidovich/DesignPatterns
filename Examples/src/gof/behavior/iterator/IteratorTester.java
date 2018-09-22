package gof.behavior.iterator;

public class IteratorTester {
    public static void main(String[] args) {
        String[] items = {"bubu", "Groot", "Deadpool"};

        Container<String> arrayList = new MyArrayList<>(items);
        Container<String> linkedList = new MyLinkedList<>(arrayList);

        Iterator<String> iterator = arrayList.getIterator();

        System.out.println("Linked List");
        while (iterator.hasNext()) {
            System.out.println('\t' + iterator.next());
        }

        iterator = linkedList.getIterator();

        System.out.println("Linked List");
        while (iterator.hasNext()) {
            System.out.println('\t' + iterator.next());
        }
    }
}
