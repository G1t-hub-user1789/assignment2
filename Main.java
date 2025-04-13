public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(4);
        heap.insert(2);
        heap.insert(7);
        heap.insert(1);
        System.out.println(heap.extractMin()); // 1
        System.out.println(heap.getMin());     // 2
    }
}
