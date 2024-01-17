public class TestSinglyLinkedList {
   public static void main(String[] args) {
         
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();   
         
      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=5; i++)
         list.addLast(i);
      System.out.println(list);
   
      System.out.println(list.get(0));
      System.out.println(list.get(4));
      System.out.println(list.get(5));
      System.out.println(list.get(-1));
   }
}