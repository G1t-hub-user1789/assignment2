public interface MyList<T> extends Iterable<T> {
    void add(T item);
    T get(int index);
    void remove(int index);
    int size();
    void clear();
    boolean exists(Object obj);
    Object[] toArray();
}
