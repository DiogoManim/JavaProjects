class Vector {
    // Atributos (coordenadas x e y)
    private double x, y;

    // Construtor
    Vector (double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override   // Sobrepõe um método já existente
    public String toString(){
        return "<" + x + "," + y + ">";
    }

    // Getters
    public double getX() {return x;}
    public double getY() {return y;}

    // Setters  
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    // Métodos úteis
    public Vector add(Vector v) {   // O primeiro Vector é o tipo de return
        // O this seguinte refere-se ao objeto de tipo Vector que for
        // usado na chamada do método. Ex: v1.add(v2);
        return new Vector(this.x + v.x, this.y + v.y);  
    }

    public Vector sub(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y);
    }

    public double mag() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector mult(double c) {
        return new Vector(this.x * c, this.y * c);
    }
}