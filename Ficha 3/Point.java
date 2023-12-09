// Uma classe simples para representar um ponto 2D
class Point {
   int x, y;

   Point() {
      x = y = 0;
   }
   
   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   public String toString() {
      return "(" + x + "," + y + ")";
   }
}