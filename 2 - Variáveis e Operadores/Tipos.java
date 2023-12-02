/*

    Tipos básicos:

        -Inteiros (byte, short, int, long)
        -Vírgula flutuante (float, double)
        -Verdadeiro/Falso (boolean)
        -Caracteres (char)

    Exemplos:

        int     i = 2;
        float   f = 3.192;
        boolean b = true;
        char    c = 'a';

    Por defeito, os valores em vírgula flutuante em Java são double. Por
    esse mesmo motivo, quando tentarmos executar o código acima, vamos 
    obter um erro do Java devido a uma possível perda de informação na
    conversão de double para float. Para declarar double:

        double d = 3.192;

    O int pode receber um char, por exemplo 'a', sem dar um erro. Isto
    porque o compilador assume o código ASCII do caracter. Então:

        int i = 'a';

    Teríamos o output (referente ao código ASCII do char 'a'):

        -> 97

    Para forçar uma variável a assumir o tipo que pretendemos, como no 
    caso do float ser interpretado como um double, basta fazer:

        float f = 3.192f;

    Desta forma, temos de estar conscientes que o valor pode estar a 
    perder conteúdo na eventualidade de nós estarmos a fazer a conversão 
    de forma incorreta.

    Agora, vamos supor que temos um int com o maior valor possível:

        int i = 2147483647;
    
    Se adicionarmos 1 unidade a i, e imprimirmos, vamos obter:

        i = i + 1;
        System.out.println(i);

        -> -2147483648

    Ou seja, overflow.

    Deve-se tentar ao máximo evitar os cálculos em vírgula flutuante.
    Devido a estes números serem todos aproximações, se começarmos
    a realizar operações entre os mesmos iremos obter problemas
    de arrendondamentos ao longo do programa, que podem ser indesejados.
    Utilizar só no caso de ser explicitamente pedido, como por exemplo
    um resultado.

    Ficam aqui exemplos dos principais tipos:

    public class TestBasicTypes {
        public static void main(String[] args) {
            boolean flag = true;
            char      ch = 'A';
            byte       b = 12;
            short      s = 24;
            int        i = 257;
            long       l = 2147483648L;  // sem a letra é interpretado como int
            float      f = 3.1415f;      // sem a letra é interpretado como double  
            double     d = 2.1828;
            System.out.println("flag = " + flag); 
            System.out.println("ch = "   + ch); 
            System.out.println("b = "    + b); 
            System.out.println("s = "    + s); 
            System.out.println("i = "    + i); 
            System.out.println("l = "    + l); 
            System.out.println("f = "    + f); 
            System.out.println("d = "    + d); 
        }
    }

    As variáveis são case sensitive, assim como toda a sintaxe em java.

    Conversões de Tipos

        - Para converter de menor precisão para maior é sempre possível
        e não há problema nenhum.
        - No sentido inverso é preciso fazer "casting" explícito.

    Vamos ver um exemplo do segundo caso:

    public class Tipos {
        public static void main(String[] args) {
            double d1 = 3.9;

            int i = d1;

            System.out.println(i)
        }
    }

    Desta forma, tal como dito no início, vamos obter um erro do Java
    devido à perda de precisão no número do tipo double. No entanto,
    esta conversão pode ser útil por vários motivos. Por esse motivo,
    podemos alterar a declaração da variável i da seguinte forma:

    int i = (int)d1;

    Desta forma estamos a obrigar o Java a fazer a conversão do double
    para o int, mesmo havendo perda de precisão. A isto chama-se casting.

    O output seria:

    -> 3

    Temos de ter em conta que esta mudança de tipos não é um arredondamento
    logo, vamos apenas perder a informação após a vírgula.

    É possível imprimir um char, através do seu código ASCII:

        char c2 = 98;
        System.out.println(c2);

        -> b

    Fica o seguinte resumo sobre conversões (casting):

    class TestConversion {
        public static void main(String[] args) {
            double d1 = 3.2;
            double d2 = 3.999999;
            
            // Casting explicito      
            int    i1 = (int)d1;    // i1 fica com o valor de 3
            int    i2 = (int)d2;    // i2 fica com o valor de 3
            double d3 = (double)i2; // d3 fica com o valor de 3.0
            
            // Casting implicito
            int    i3 = 42;
            double d4 = i3;         // d4 fica com o valor de 42.0
            //     int    i4 = d4;         // erro de compilacao: "possible loss of precision

            char  ch1 = 'A';
            int    i5 = ch1;        // i5 fica com o valor de 65 (codigo ascii de 'A')
            char  ch2 = 66;         // ch2 fica com o valor de 'B' (codigo ASCII 66)

            //     boolean b1 = i1;        // erro de compilacao: "incompatible types"           
        }
    }

    É possível saber o valor máximo e mínimo dos vários tipos de variáveis.
    Para isso basta usar MAX e MIN da seguinte forma:

    public class TestLimits {
        public static void main(String args[]) {
            // inteiros
            byte largestByte = Byte.MAX_VALUE;
            short largestShort = Short.MAX_VALUE;
            int smallestInteger = Integer.MIN_VALUE;
            long largestLong = Long.MAX_VALUE;

            // virgula flutuante
            float largestFloat = Float.MAX_VALUE;
            double largestDouble = Double.MAX_VALUE;

            // mostrar limites
            System.out.println("Largest byte value: " + largestByte);
            System.out.println("Largest short value: " + largestShort);
            System.out.println("Smallest integer value: " + smallestInteger);
            System.out.println("Largest long value: " + largestLong);

            System.out.println("Largest float value: " + largestFloat);
            System.out.println("Largest double value: " + largestDouble);
        }
    }

    Estes métodos são "Wrappers". Uma classe wrapper faz com que os tipos
    de dados primitivos (int, boolean, ...) possam ser usados como objetos.

    Operadores

        -> + adição
        -> - subtração
        -> * multiplicação
        -> / divisão

    Nota: A divisão inteira não tem um operador definido. Esta acontece
    automaticamente quando dividimos entre valores do tipo float.
*/

public class Tipos{
    public static void main(String[] args){
        double i = 10;
        double j = 6;

        System.out.println(i/j);
    }
}