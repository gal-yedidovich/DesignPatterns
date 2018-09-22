package gof.behavior.iterator;

public class MyArrayList<T> implements Container<T> {

    private T[] elements;

    public MyArrayList(T[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> getIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int index = 0;

        @Override
        public Boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public T next() {
            return elements[index++];
        }
    }
}
