public class TestSet {
    public static void main(String[] args) {
        IntSet s = new ArrayListIntSet(42);

        System.out.println(s.add(1));
        System.out.println(s.add(2));
        System.out.println(s.add(3));

        System.out.println(s.size());
    }
}
