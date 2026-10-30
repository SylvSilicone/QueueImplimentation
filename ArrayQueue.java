public class ArrayQueue<T> implements QueueInterface<T> {
    private Object[] elements;
    private int head;
    private int size;

    public ArrayQueue() {
        elements = new Object[4];
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
        ensureCapacity();
        elements[(head + size) % elements.length] = item;
        size++;
        return item;
    }

    @Override
    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return elementAt(head);
    }

    @Override
    public T remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
    
        T item = elementAt(head);
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        if (size == 0) {
            head = 0;
        }
        return item;
    }

    @Override
    public void clear() {
        elements = new Object[4];
        head = 0;
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] expanded = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                expanded[i] = elements[(head + i) % elements.length];
            }
            elements = expanded;
            head = 0;
        }
    }

    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        return (T) elements[index];
    }
}
