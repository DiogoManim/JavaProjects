/*

    Desconstrução da nomenclatura do main():

        public:
        -> classificador

        static:
        -> indica que o método (neste caso main()) pertence à classe

        void:
        -> tipo de retorno (neste caso, não retorna nada)

        main(String[] args):
        -> método que recebe como argumento um array de strings


    class TestPoint {
        public static void main(String[] args) {
            Point p1 = new Point();
            p1.x = 42;
            System.out.println(p1.x);

            Point p2 = p1;
            System.out.println(p2.x);

            System.out.println(p1);     // Imprime o endereço do objeto para o qual p1 aponta
            System.out.println(p2);     // Imprime o mesmo endereço que p1 pois ambos apontam para o mesmo objeto
        }
    }

*/

class TestPoint {
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 42;
        p.y = 13;

        p.show();  
    }
}
