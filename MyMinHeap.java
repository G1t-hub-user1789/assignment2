public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");

        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heapifyDown(0, last);
        }

        return min;
    }

    public T getMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            T current = heap.get(index);
            T parentVal = heap.get(parent);
            if (current.compareTo(parentVal) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index, T value) {
        heapRemoveSet(0, value);
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heapRemoveSet(i, heap.get(j));
        heapRemoveSet(j, temp);
    }

    private void heapRemoveSet(int index, T item) {
        heap.remove(index);
        if (index == heap.size()) {
            heap.add(item);
        } else {
            Object[] newData = heap.toArray();
            newData[index] = item;
            heap.clear();
            for (Object o : newData) heap.add((T) o);
        }
    }
}
