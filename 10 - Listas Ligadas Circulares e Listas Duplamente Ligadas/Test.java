public class Test {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        System.out.println(list);

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.println(list);
        list.rotate();
        System.out.println(list);
        list.rotate();
        System.out.println(list);
        list.addLast(4);
        System.out.println(list);
    }
}
