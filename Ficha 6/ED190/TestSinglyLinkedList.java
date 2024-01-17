public class TestSinglyLinkedList {
   public static void main(String[] args) {
         
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();   
         
      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=5; i++)
         list.addLast(i);
      System.out.println(list);
   
      SinglyLinkedList<Integer> newList = new SinglyLinkedList<>();
      newList = list.copy();
      System.out.println(newList);
   }
}