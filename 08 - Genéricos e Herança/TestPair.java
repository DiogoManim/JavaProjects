public class TestPair {
    public static void main(String[] args) {
        Pair<String,String> p1 = new Pair<>("UC", "EDados");
        Pair<Integer,Integer> p2 = new Pair<>(42, 21);
        Pair<Integer,String> p3 = new Pair<>(42, "Sentido da vida");

        System.out.println(p3.getFirst());
        System.out.println(p3.getSecond());
    }
    
}
