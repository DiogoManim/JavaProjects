public class CircularLinkedList<T> {
    private Node<T> last;   // Último nó da lista
    private int size;       // Tamanho da lista

    // Construtor (cria lista vazia)
    CircularLinkedList() {
        last = null;
        size = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // Devolve true se a lista estiver vazia ou falso caso contrário
    public boolean isEmpty() {
        return (size == 0);
    }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty()) return null;
        return last.getNext().getValue();
    }

    // Retorna o último valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty()) return null;
        return last.getValue();
    }

    // Roda a lista (o primeiro passa a ser o novo último da lista)
    public void rotate() {
        if (!isEmpty())     // Se estiver vazia não faz nada
            last = last.getNext();
    }

    // Adiciona v ao início da lista
    public void addFirst(T v) {
        if (isEmpty()){
            last = new Node<T>(v, null);
            last.setNext(last);
        } else {
            Node<T> newNode = new Node<>(v, last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        addFirst(v);
        last = last.getNext();
    }

    // Remove o primeiro elemento da lista (se for vazia não faz nada)
    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) last = null;
        else last.setNext(last.getNext().getNext());
        size--;
    }

    // Remove o último elemento da lista (se for vazia não faz nada)
    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
           last = null;
        } else {
           Node<T> cur = last.getNext();
           for (int i=0; i<size-2; i++)
              cur = cur.getNext();
           last = cur;
           last.setNext(last.getNext().getNext());
        }
        size--;
     }

    // Converte a lista para uma String
    public String toString() {
        String str = "{";      
        if (!isEmpty()) {
            Node<T> cur = last.getNext();
            for (int i=0; i<size; i++) {
                str += cur.getValue();
                if (cur != last) str += ",";
                cur = cur.getNext();
            }
        }         
      str += "}";
      return str;
    }
}