package gof.behavior.iterator;

public class MyLinkedList<T> implements Container<T> {

    private Node<T> head;
    private int count;

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public MyLinkedList(Container<T> iterable) {
        Iterator<T> i = iterable.getIterator();
        while (i.hasNext()) add(i.next());
    }

    public void add(T item) {
        if (head == null) {
            head = new Node<>(item);
        } else {
            Node<T> last = head;
            while (last.next != null) last = last.next;
            last.next = new Node<>(item);
        }
        count++;
    }

    @Override
    public Iterator<T> getIterator() {
        return new MyIterator();
    }

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        Node(T data) {
            this(data, null);
        }
    }

    private class MyIterator implements Iterator<T> {
        Node<T> current = head;

        @Override
        public Boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
