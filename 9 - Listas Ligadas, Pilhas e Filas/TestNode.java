public class TestNode {
    public static void main(String[] args) {
        Node<Integer> n = new Node<>(42, null);

        System.out.println(n.getValue());
        System.out.println(n.getNext());

        n.setValue(20);
        System.out.println(n.getValue());
    }
}
