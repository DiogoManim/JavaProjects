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
        if (isEmpty()) return null;
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty()) return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    public void removeFirst() {
        if(!isEmpty()) {
            first = first.getNext();
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) first = null;
        else {
            Node<T> cur = first;
            while (cur.getNext().getNext() != null)
                cur = cur.getNext();
            cur.setNext(null);
        }
        size--;
    }

    @Override
    public String toString(){
        String ans = "{";
        Node<T> cur = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) ans += ",";
            ans += cur.getValue();
            cur = cur.getNext();
        }
        ans += "}";
        return ans;
    }
}