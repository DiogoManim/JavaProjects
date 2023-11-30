/*
    -Um programa é composto por um conjunto de classes.
    -Cada classe X deve estar num ficheiro X.java
    -Apenas uma das classes deve ter o método main()

    Para compilar e executar este programa na linha de comandos:
    $ javac HelloWorld.java
    $ java HelloWorld

    Nota: O primeiro comando cria o ficheiro HelloWorld.class, que não é feito para ser entendido,
    apenas pelo computador dado que é bytecode.

    Na execução, se chamarmos uma classe que não existe o compilador vai dar throw a uma exceção,
    indicando o erro em questão (ClassNotFound).

    O nome da classe executável (a que contém o main()) tem de ser o mesmo do ficheiro, caso
    contrário não é possível compilar/executar.

    Se não tivermos o main() no código, é possível compilar na mesma, no entanto quando vamos
    executar o código obtemos um erro dado não ter sido encontrado o main().

    Na eventualidade de nos esquecermos de como se escreve o main(), nomeadamente:

    "public static void main(String[] args)..."

    Basta tentarmos executar um programa sem o main(), que o próprio compilador indica-nos no erro
    como o fazer.

    Nota: Java é uma linguagem case sensitive!

    Um truque para não estar sempre a compilar e executar em dois comandos diferentes, ou até mesmo
    na eventualidade de nos esquecermos de compilar de novo e executamos um programa não atualizado,
    é usar o comando:

    $ javac HelloWorld.java && java HelloWorld

    Desta forma, o que executamos é sempre o programa na sua forma mais atualizada.

    No main(), podemos verificar que temos como argumento um array chamado "args". Este serve para
    receber da linha de comandos qualquer tipo de String como input. Assim sendo, se executarmos
    por exemplo:

    $ javac HelloWorld.java && java HelloWorld a b c

    E o nosso programa for:

    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println(args[0]);
        }
    }

    Obteremos como output:

    'a'

    Nota: args[0] imprime o primeiro elemento da lista, ou seja, 'a' poderia ser uma palavra na
    input, não necessita de ter exatamente 1 char de length. Se substituirmos na input "... a b c"
    por "... edados b c" vamos obter na output "edados".

   Uma nuance algo importante em Estruturas de Dados e particularmente na linguagem Java é que
   o que escrevemos num bloco de código (ou seja dentro de um par de chavetas {}) é apenas válido
   dentro do mesmo. Ou seja, vamos supor o seguinte pedaço de código:

   public class HelloWorld {
        public static void main(String[] args) {
        {}{}{}
            System.out.println("Hello World!");
        }
    }

    Este código ainda seria válido, e executável da mesma forma.
    No entanto, observemos outro código similar:

    public class HelloWorld {
        public static void main(String[] args) {
        {
            int i = 0;
        }
            System.out.println(i);
        }
    }

    Será este código válido? A resposta é não, isto porque a varíavel i só esta definida naquele
    bloco de código especificamente pelo que não é reconhecida no restante programa, e obtemos um
    erro quando no System.out.println(i) tentamos imprimir o valor de i (não encontra a variável).
    Para corrigir este pedaço de código basta a simples alteração de remover as chavetas adicionais:

    public class HelloWorld {
        public static void main(String[] args) {
            int i = 0;

            System.out.println(i);
        }
    }

    Apesar de no Java ser possível ignorar completamente a identação, é obviamente boa prática
    fazer um código legível. De relembrar que o código não é só feito para os computadores mas
    também para ser entendido pelos humanos. :)

 */

public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
}