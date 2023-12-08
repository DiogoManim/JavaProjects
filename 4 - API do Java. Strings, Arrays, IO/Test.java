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

    
*/

public class Test {
    public static void main(String[] args) {
        String s = new String("Olá");
        System.out.println(s.charAt(0));
        System.out.println("String s = |" + s + "|");
    }
}