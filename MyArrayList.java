public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        data = new Object[10];
        size = 0;
    }

    public boolean exists(Object obj) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(obj)) return true;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = data[i];
        return result;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return (T) data[index++];
            }
        };
    }
}
