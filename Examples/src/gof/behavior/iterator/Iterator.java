package gof.behavior.iterator;

public interface Iterator<T> {
    Boolean hasNext();

    T next();
}
