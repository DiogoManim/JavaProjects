class Rectangle {
    int x1, x2, y1, y2;

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    Rectangle(Point p1, Point p2) {
        x1 = p1.x;
        y1 = p1.y;
        x2 = p2.x;
        y2 = p2.y;
    }

    // Devolve a área do retângulo
    public int area() {
        return ((x2 - x1) * (y2 - y1));
    }

    // Devolve o perímetro do retângulo
    public int perimeter() {
        return (2 * (x2 - x1) + 2 * (y2 - y1));
    }

    // Devolve true se o ponto p está dentro do retângulo (tocar nas bordas é considerado dentro) ou false caso contrário
    public boolean pointInside(Point p) {
        if (p.x >= x1 && p.y >= y1 && p.x <= x2 && p.y <= y2)
            return true;
        return false;
    }

    // Devolve true se o retângulo r está contido dentro do retângulo ou false caso contrário
    public boolean rectangleInside(Rectangle r) {
        Point p1 = new Point(r.x1, r.y1);
        Point p2 = new Point(r.x2, r.y2);

        if (pointInside(p1) && pointInside(p2))
            return true;
        return false;
    }
}
