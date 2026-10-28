public class ArrayQueue {
    private int[] elements;
    private int head;
    private int tail;
    private int size;
    public ArrayQueue() {
        this.elements = new int[4];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        tail = (tail + 1) % elements.length;
        elements[tail] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[head];
    }
}
