/*

    Vamos mostrar algumas das classes mais habituais disponibilizadas
    pela API do Java.

    Sempre que quisermos saber o que faz um dado método relativamente
    a estas classes pré-definidas no Java, basta ler a documentação do
    Java.

    Uma das classes mais comum é a String que tem como objetivo representar
    sequências de caracteres. Estas são imutáveis. Se quisermos substituir
    algo, não estamos a modificar mas sim a criar uma nova. No entanto 
    existe uma classe chamada StringBuffer, que permite alterar de facto
    a String sem criar uma nova (não vamos precisar desta por agora).

    Para criar um objeto da classe String, basta fazer:

        String s = new String();

    Tal como podemos ver na introdução às classes e à programação orientada
    a objetos. Podemos criar desta forma um objeto sem conteúdo, no entanto
    se quisermos podemos fazer:

        String s = new String ("Hello World!");

    Ficando assim s com "Hello World!". Isto é possível porque na classe 
    String temos ambas as formas, onde não passamos argumento, ou passamos
    exatamente 1 argumento do tipo String.

    Por um motivo de simplicidade dado que é uma classe muito utilizada,
    existe uma criação ainda mais simplificada:

        String s = "Hello World!";

    O operador mais básico seria o de concatenação, que pode ser usado
    da seguinte forma:

        String s1 = "Hello";
        String s2 = " World!";
        String s3 = s1 + s2
        System.out.println(s3);

        > Hello World!

    Um método também muito utilizado é o charAt(i), onde dado um i inteiro
    retorna o caracter da devida posição indicada (range 0 até n-1).

        String s = "Hello World!";
        System.out.println(s.charAt(0));

        > H

    Outro método é o length(), que retorna um inteiro com o comprimento
    da String em questão. Devemos ter em atenção que o método conta todo o
    tipo de caracteres, tais como espaços e pontuação. Vejamos o exemplo:

        String s = "Hello World!";
        System.out.println(s.length());

        > 12
    
    Relativamente à comparação entre strings, devemos estar particularmente
    atentos à diferença entre usar o == ou o método equals(). Este segundo
    permite-nos realmente fazer uma comparação entre o conteúdo de duas
    Strings. Já o == compara as referências. Não nos podemos esquecer que
    o objeto que estamos a criar apenas está a servir de "apontador" como
    em C. Segue-se o exemplo:

        String s1 = "Hello World!";
        String s2 = new String ("Hello World!");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        > false
        > true

    Notemos ainda que na criação do objeto s2, tivemos de dizer de forma
    explicita que queremos uma nova string com o conteúdo "Hello World!",
    pois a classe String tem uma propriedade onde consegue reaproveitar
    Strings iguais, e indicarmos apenas como fizemos na criação de s1
    provavelmente iriamos obter o mesmo endereço porque estariam a apontar
    para o mesmo objeto e não porque o conteúdo é o mesmo.

    Outro método de comparação (lexicograficamente), é o compareTo().
    Este pode ser utilizado da seguinte forma:

        String s1 = "abc";
        String s2 = "xyz";
        System.out.println(s1.compareTo(s2));

        > -23

    Este método compara e devolve um valor menor que 0 se a primeira String
    for mais pequena que a segunda (não em comprimento, mas sim pela ordem
    alfabética neste caso), um valor igual a 0 se forem iguais, e um valor
    maior que 0 se a primeira String for maior que a segunda. Vejamos outros
    casos:

        String s1 = "xyz"
        String s2 = "abc"
        System.out.println(s1.compareTo(s2));

        > 23

        String s1 = "abc"
        String s2 = "abc"
        System.out.println(s1.compareTo(s2));

        > 0

    Outro método bastante comum é o substring(a, b) que opera num intervalo
    de a até b-1. Vejamos o exemplo:

        String s1 = "abcdefghij";
        System.out.println(s1.substring(0,4));

        > abcd

    Também é possível converter strings em arrays de caracteres e vice-versa.
    Basta utilizar o método toCharArray(). Por exemplo:

        String s1 = "Hello World!"
        char[] a = s1.toCharArray();
        String s2 = new String(a);

        System.out.println(a);
        System.out.println(s2);

        > Hello World!
        > Hello World!

    Com este método podemos aproveitar para fazer alterações nas Strings,
    apesar de estarmos sempre a criar uma nova String, dado que são
    imutáveis. Exemplo:

        String s1 = "Hello World!"
        char[] a = s1.toCharArray();
        a[0] = "A"
        s1 = new String(a);

        System.out.println(s1);

        > Aello World!

    Um array pode ser criado da seguinte forma:

        int[] values;
        Point[] coordinates;

    Onde primeiro indicamos o tipo dos elementos do array, e de seguida
    indicamos o nome do array. No entanto este processo não inicializa
    o array, nem aloca espaço na memória. Como os arrays não deixam de ser
    apenas uma classe, devemos inicializar com o new. Exemplo:

        int[] values = new int[10];

    Neste caso estamos a especificar o tamanho máximo do mesmo, igual a 10,
    o que equivale ao range 0 até 9. Tal como indicado anteriormente, os
    inteiros são automáticamente inicializados a 0. Logo, se fizermos o
    seguinte:

        int[] values = new int[10];

        System.out.println(values[0]);
        
        values[0] = 1

        System.out.println(values[1]);

        > 0
        > 1

    Obtemos 0 como caso base.

    É boa prática inicializar logo o array na declaração do mesmo.

    Nos arrays em vez de termos o método length() como na classe String,
    temos um atributo length, pelo que para obtermos o comprimento de um
    array basta fazer:

        int[] values = new int[20];

        System.out.println(values.length);

        > 20

    Sendo 20 um atributo e não um método.

    O java faz auto import nos packages do java.lang, por serem tão 
    fundamentais. No entanto existem outras muito úteis que vamos precisar.
    Entre estas tempos as pertencentes ao java.util, onde podemos encontrar
    a classe Scanner. Também podemos por outro lado importar todas as 
    classes utilitárias (java.util.*). Para isso basta fazer:

        import java.util.Scanner;
        
    Ou para importar tudo da classe java.util:

        import java.util.*;

    Quando estamos a lidar com arrays, à exceção de arrays de caracteres
    (pois estes imprimem diretamente a String contida no mesmo), ao tentar
    imprimir o próprio array sem mais nenhuma instrução, iremos obter apenas
    a sua referência. Vejamos o exemplo:

        int[] primes = {2, 3, 5, 7, 11, 13};
        System.out.println(primes);

        > [I@2f92e0f4

    Nota: Ao indicar os elementos de um array têm de estar entre chavetas.

    Para de facto imprimirmos o conteúdo do array, temos de fazer vários
    passos. Entre eles:

        1 -> Importar a classe Arrays
        2 -> Usar o método Arrays.toString()

    Tomemos o seguinte exemplo:

        import java.util.Arrays;

        class Test{
            public static void main(String[] args) {
                int[] primes = {2, 3, 5, 7, 11, 13};
                System.out.printn(primes);
                System.out.println(Arrays.toString(primes));
            }
        }

        > [I@2f92e0f4
        > [2, 3, 5, 7, 11, 13]

    Um método útil para comparar o conteúdo de um array, não devemos utilizar
    o ==, tal como nas Strings, este compara a referência e não o conteúdo. 
    Para de facto comparar o contéudo devemos fazer:

        int[] p1 = {2, 3, 5, 7, 11, 13};
        int[] p2 = {2, 3, 5, 7, 11, 13};
        System.out.println(p1 == p2);
        System.out.println(Arrays.equals(p1,p2));

        > false
        > true
    
    Outro método muito útil seria o sort(), que faz a ordenação do array
    indicado. Por exemplo:

        int[] p = {7, 12, 9, 2, 1, 4};
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));

        > [1, 2, 4, 7, 9, 12]

    Um array pode perfeitamente ser um argumento. Vejamos o seguinte método
    de exemplo:

        public static int sum(int[] a) {
            int ans = 0;
            for (int i = 0; i < a.length; i++)
                ans += a[i];
            return ans;
        }

    Este método faz a soma dos elementos do array.

    Também podemos fazer matrizes, também denominadas de Arrays 
    multidimensionais. Para tal basta fazer:

        int[][] m = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9} };
        System.out.println(Arrays.toString(m));

        > [[I@28a418fc, [I@5305068a, [I@1f32e575]

    Atenção à forma de imprimir o conteúdo. É frequente cair no erro de usar
    o método toString(). Mas no entanto para as matrizes devemos utilizar
    o método deepToString(). Exemplo:

        int[][] m = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9} };
        System.out.println(Arrays.deepToString(m));

        > [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

    Nota: Relembrar que tudo isto é disponibilizado pelo package Arrays
    (import java.util.Arrays;).

    O atributo length funciona da mesma forma, dando como output o número
    de arrays dentro da matriz. Exemplo:

        int[][] m = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9} };
        System.out.println(m.length);
    
        > 3

    Relativamente ao I/O, a classe principal que vamos utilizar é a classe
    Scanner. Para criar um novo Scanner para receber input devemos fazer
    duas coisas:

        1 -> Dar import à classe Scanner
        2 -> Criar e inicializar um objeto da classe Scanner

    Por exemplo:

        import java.util.Scanner;

        public class Test {
            public static void main(String[] args) {
                Scanner in = new Scanner(System.in);

                in.close();
            }
        }

    Além disso, é boa prática fechar o objeto da classe Scanner no final,
    conforme exemplificado.

    Para ler por exemplo o próximo valor inteiro, podemos utilizar o método
    nextInt(). Vejamos o exemplo:

        int a = in.nextInt();

    Por definição o comportamento do programa é ficar parado até encontrar
    um valor inteiro. O programa vai ignorar tudo o que escrevermos, até 
    encontrar um valor inteiro.

    Digamos agora que queremos fazer testes com o seguinte programa:

    import java.util.Scanner;

    public class Test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            int a = in.nextInt();
            int b = in.nextInt();

            System.out.println(a);
            System.out.println(b);

            in.close();
        }
    }

    Na shell, podemos fazer o comando:

    javac Test.java && java Test < input.txt

    Sendo que no ficheiro input.txt (que tem de estar na mesma pasta) deve
    conter, por exemplo:

    12
    32

    O Scanner também é capaz de ler por exemplo uma String (já definida),
    ou até mesmo um ficheiro. Exemplos:

    import java.util.Scanner;

    public class Test {
        public static void main(String[] args) {

            String s = "123 456 789";

            Scanner in = new Scanner(s);

            int a = in.nextInt();
            System.out.println(a);

            in.close();
        }
    }

    OU

    public class Test {
        public static void main(String[] args) {

            Scanner in = new Scanner(input.txt);

            int a = in.nextInt();
            System.out.println(a);

            in.close();
        }
    }

    Agora relativamente aos métodos mais relevantes da classe Scanner, 
    devemos considerar:

    hasNext()
    next()
    hasNextLine()
    nextLine()
    hasNextType()
    nextType()

    Alguns exemplos das aplicações dos métodos:
    
    while (int.hasNextInt()) {
        int a = in.nextInt();
        System.out.println(a);
    }

    Este programa continua a imprimir inteiros sempre que existir um próximo
    valor desse mesmo tipo. Daí o hasNextInt().

    while (int.hasNext()) {
        String s = in.next();
        System.out.println(s);
    }

    Este programa imprime Strings sempre que existirem (separadamente).
    Não existe o método hasNextString(), mas sim o método next() quando
    queremos manipular as Strings.

    while (int.hasNextLine()) {
        String s = in.nextLine();
        System.out.println(s);
    }

    Este método imprime linha a linha, seja o que tenha no input.

    Agora vamos ver o seguinte programa:

        Consideremos a input:
        > 2
        > primeira
        > segunda

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            System.out.println(s);
        }

        O output deste programa seria:

        >
        > primeira

    Obtemos assim um resultado inesperado, porque ao usar o método nextInt()
    não estamos a fazer uma mudança de linha. Logo não recebemos o correto.
    Para corrigir basta fazer:

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();          // Escapar o resto da primeira linha
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            System.out.println(s);
        }

        > primeira
        > segunda

    Relativamente a formatar o output, temos várias formatos úteis.
*/

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(a);
        System.out.println(b);

        in.close();
    }
}