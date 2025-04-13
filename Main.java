public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("MyArrayList: " + arrayList.get(1)); // 20

        // Test MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        System.out.println("MyLinkedList: " + linkedList.get(0)); // Hello

        // Test MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("MyStack pop: " + stack.pop()); // 2

        // Test MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("MyQueue dequeue: " + queue.dequeue()); // A

        // Test MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(50);
        heap.insert(10);
        heap.insert(30);
        System.out.println("MyMinHeap min: " + heap.getMin()); // 10
    }
}


