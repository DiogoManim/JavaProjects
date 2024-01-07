public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return(size == 0);
    }

    public void addFirst(T value) {
        Node<T> n = new Node<>(value, first);
        first = n;
        size++;
    }

    public void addLast(T value) {
        Node<T> n = new Node<>(value, null);
        if(isEmpty()){
            first = n;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(n);
        }
        size++;
    }

    public T getFirst() {
        return first.getValue();
    }
}