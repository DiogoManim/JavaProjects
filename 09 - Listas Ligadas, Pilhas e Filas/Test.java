public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.println(list.toString());
    }
}
