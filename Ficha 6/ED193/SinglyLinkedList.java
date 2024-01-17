public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista
 
   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }
 
   // Retorna o tamanho da lista
   public int size() {
      return size;
   }
 
   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
    
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }
 
   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }
 
   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }
 
   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Retorna o valor na posição pos (ou null se não existir essa posição)
   public T get(int pos) {
      Node<T> cur = first;
      if (pos < 0) { return null; }
      for (int i = 0; i < pos; i++) {
         cur = cur.getNext();
         if (cur == null) { return null; }
      }
      return cur.getValue();
   }
 
   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }
 
   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   // Remove e retorna o elemento na posição pos (devolve null se não existe)
   public T remove(int pos) {
      if (pos < 0 || pos >= size) { return null; }
      T ans = get(pos);
      if (pos == 0) {
         removeFirst();
      } else {
         Node<T> cur = first;
         for (int i = 0; i< pos - 1; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
         size--;
      }
      return ans;
   }

   // Copia a lista para uma nova
   public SinglyLinkedList<T> copy() {
      SinglyLinkedList<T> ans = new SinglyLinkedList<>();
      Node<T> cur = first, last = null;
      while (cur != null) {
         Node<T> newNode = new Node<>(cur.getValue(), null);
         if (last == null) ans.first = newNode;
         else last.setNext(newNode); 
         last = newNode;
         ans.size++;
         cur = cur.getNext();
      }
      return ans;
   }

   // Duplica todos os elementos da lista
   public void duplicate(){
      Node<T> cur = first;
      while (cur != null) {
         Node<T> newNode = new Node<>(cur.getValue(), cur.getNext());
         cur.setNext(newNode);
         size++;
         cur = cur.getNext().getNext();
      }
   }

   // Conta os elementos da lista e retorna o valor inteiro
   public int count(T value) {
      int count = 0;
      Node<T> cur = first;
      for (int i = 0; i < size; i++) {
         if (first.getValue().equals(value)) { 
            removeFirst();
         }
         if (cur.getValue().equals(value)) 
            count++;
         cur = cur.getNext();
      }
      return count;
   }

   // Remove todas as ocorrências de um dado elemento
   public void removeAll(T value) {
      while(!isEmpty() && first.getValue().equals(value)) removeFirst();
      Node <T> cur = first;
      while (cur != null && cur.getNext() != null) {
         if (cur.getNext().getValue().equals(value)){
            cur.setNext(cur.getNext().getNext());
            size--;
         } else {
            cur = cur.getNext();
         }
      }
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }
}