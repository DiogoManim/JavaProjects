public class Test {
    private int x;
    private int y;

    public Test() {
        this.x = 0;
        this.y = 0;
    }

    public Test(int xvalue, int yvalue) {
        this.x = xvalue;
        this.y = yvalue;
    }

    public int views() {
        return 12000000;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public toString(){
        
    }
}