
public class TestVector {
    public static void main(String[] args) {
        Vector v1 = new Vector(3,2);
        Vector v2 = new Vector(1,4);
        Vector v3 = v1.add(v2);
        Vector v4 = v1.sub(v2);

        System.out.println(v1.getX());
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.printf("%.2f%n", v1.mag());
        System.out.println(v1.mult(2));
    }
}
