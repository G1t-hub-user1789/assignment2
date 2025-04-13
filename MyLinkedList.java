public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T value;
        MyNode next;
        MyNode prev;

        MyNode(T value) {
            this.value = value;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.value;
    }

    public void remove(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;

        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;

        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;

        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean exists(Object obj) {
        MyNode current = head;
        while (current != null) {
            if (current.value.equals(obj)) return true;
            current = current.next;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T val = current.value;
                current = current.next;
                return val;
            }
        };
    }
}
