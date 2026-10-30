public class LinkedQueue<T> implements QueueInterface<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private final T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public T add(T item) {
        Node node = new Node(item);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return item;
    }

    @Override
    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public T remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }

        T item = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
