public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.add(item); // добавляем в конец
    }

    public T dequeue() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty");
        T first = list.get(0);
        list.remove(0); // удаляем из начала
        return first;
    }

    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty");
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
