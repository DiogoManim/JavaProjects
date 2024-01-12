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

        Aritméticos:
        -> +    Adição
        -> -    Subtração
        -> *    Multiplicação
        -> /    Divisão
        -> %    Resto da divisão
        -> ++   Incremento
        -> --   Decremento

        Lógicos
        -> !    NOT
        -> &&   AND
        -> ||   OR

        Bits:
        -> ~    NOT
        -> |    OR
        -> &    AND
        -> ^    XOR
        -> <<   Shift binário esquerda
        -> >>   Shift binário direita
        Nota: Exemplo da aplicação de NOT no final.

        Relacionais ou de comparação:
        -> ==   Igualdade
        -> !=   Diferente
        -> <    Menor
        -> >    Maior
        -> <=   Menor ou igual
        -> >=   Maior ou igual

    Nota: A divisão inteira não tem um operador definido. Esta acontece
    automaticamente quando dividimos entre valores do tipo float.

    Um exemplo da aplicação de um NOT aplicado em bits é o seguinte:

        public class Tipos{
            public static void main(String[] args){
                int i = 0;
                int j = ~i;

                System.out.println(j);
            }
        }

    A output deste programa seria:

        -> -1

    Isto porque na teoria um 0 é representado como 00...0, se negarmos isto
    vamos obter 11...1 o que seria -1 em complemento para 2 bits.

    É importante perceber como podemos manipular os bits, apesar de não
    tão importante para a cadeira de estruturas de dados. Para tal:
    https://youtu.be/VbnamwhxAdo?list=PLPXQt9qcU85_vmyhXACiLfqzH0gnI94Ch&t=2550

    Agora, fiquemos com um pequeno sumário da divisão inteira:

        double  d1 = 3/2;       // dá 1 e não 1.5 (int/int dá um int)
        double  d2 = 3.0/2;     // dá 1.5 (double/int dá um double)
        double  d3 = 3/2.0;     // dá 1.5 (int/double dá um double)

        int     i1 = 3;         
        double  d4 = i1/2;      // dá 1 e não 1.5 (int/int)

        double  d5 = 3;         
        int     i2 = d5/2;      // resultado da divisão é 1.5 mas depois
                                // dá erro "possible loss of precision"
                                // (double/int = double)
                                
        int     i3 = 3/0;       // Erro: "java.lang.Arithmetic Exception: / by zero"

    Um truque que se deve ter em conta em qualquer linguagem é com o resto
    da divisão, relativamente a obter os n últimos algarismos de um número.
    Podemos obter da seguinte forma:

        public class Tipos{
            public static void main(String[] args){
                int i = 12345;
                System.out.println(i%10);
                System.out.println(i%100);
                System.out.println(i%1000);
            }
        }

    Desta forma o output seria:

        -> 5
        -> 45
        -> 345

    Relativamente aos incrementos e decrementos devemos ter atenção se é
    um pré ou pós. Ou seja, se tivermos i++ tratase de usar primeiro a 
    variável i com o seu valor atual e só depois incrementar. No entanto,
    se tivessemos ++i, primeiro dava-se o incremento e só depois se usaria
    a variável i. Fica o seguinte exemplo:

        public class Tipos{
            public static void main(String[] args){
                int i = 2;
                int j = i++;
                System.out.println(j);
                System.out.println(i);
            }
        }

    Podemos verificar que a variável j vai assumir o valor de i antes do
    incremento e portanto irá ficar com o valor dois. No entanto após essa
    linha, i passa a ter valor 3, daí o output ser:

        -> 2
        -> 3

    Para registo, fica o exemplo da instrução condicional if-else:
    
    public class TestIfElse {
        public static void main(String[] args) {
            int testscore = 76;
            char grade;

            if (testscore >= 90) {
                grade = 'A';
            } else if (testscore >= 80) {
                grade = 'B';
            } else if (testscore >= 70) {
                grade = 'C';
            } else if (testscore >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            
            System.out.println("Grade = " + grade);
        }
    }

    Quando temos muitos if's para escrever, o correto é usar uma instrução
    switch-case. Fica o seguinte exemplo:

        public class TestSwitch {
            public static void main(String[] args) {
                int month = 2;
                String monthString;
                switch (month) {
                case 1:  monthString = "January";
                    break;
                case 2:  monthString = "February";
                    break;
                case 3:  monthString = "March";
                    break;
                case 4:  monthString = "April";
                    break;
                case 5:  monthString = "May";
                    break;
                case 6:  monthString = "June";
                    break;
                case 7:  monthString = "July";
                    break;
                case 8:  monthString = "August";
                    break;
                case 9:  monthString = "September";
                    break;
                case 10:  monthString = "October";
                    break;
                case 11:  monthString = "November";
                    break;
                case 12: monthString = "December";
                    break;
                default: monthString = "Invalid month";
                    break;
                }
            System.out.println(monthString);
            }
        }

    Esta instrução tem apenas a particularidade de ter um default value
    associado à mesma para quando é inserido um valor que não consta
    nos casos anteriormente indicados. Neste exemplo, se inserirmos um
    int que não corresponde a nenhum mês do ano vamos obter o output:

        -> Invalid Month

    Exemplo de ciclo While:

        class TestWhile {
            public static void main(String[] args) {
                System.out.println("isPrime(19) = " + isPrime(19));
            } 
    
            public static boolean isPrime(int n) {
                int divisor = 2;
                while (divisor*divisor <= n) {
                if ( (n % divisor) == 0 ) 
                    return false;
                divisor++;
                }
                return true;
            }   
        }

    À semelhança de C ou de Python, o ciclo while verifica a condição que
    está imediatamente à frente da chamada do ciclo, se for verdade,
    executa o que está dentro das chavetas, se não for salta esse mesmo
    bloco de código. Ter atenção a possíveis loops infinitos :) 
    
    Quanto ao ciclo for, temos o seguinte exemplo:

        class TestFor {
            public static void main(String[] args) {
                System.out.println("isPrime(19) = " + isPrime(19));
        } 

        public static boolean isPrime(int n) {
            for(int divisor = 2; divisor < n/2; divisor++) 
            if ( (n % divisor) == 0 ) 
                return false;        
            return true;
            }
        }

    Um ciclo for tem sempre 3 componentes. Cada uma destas é executada 
    antes, durante e após (respetivamente) o ciclo for. Ou seja, antes da
    execução declara-se a variável divisor = 2, depois durante o ciclo
    verificamos se divisor < n/2 e por fim, após a execução do bloco de 
    código, incrementamos a variável divisor++. 

    Nota: Tem a mesma função que um ciclo while.

    À semelhança do que acontece no pré/pós incremento/decremento, para um
    while, existe um do-while. Supunhamos o exemplo:

        class TestDoWhile {
            public static void main(String[] args) {
                System.out.println("isPrime(19) = " + isPrime(19));
            } 

            public static boolean isPrime(int n) {
                int divisor = 2;
                do {
                    if ( (n % divisor) == 0 )
                    return false;
                    divisor++;
                } while (divisor*divisor <= n);
                return true;
            }
        }

    Este pedaço de código primeiro executa primeiro o bloco de código
    e só depois verifica a condição. De resto é em tudo similar ao while.

    O Java tem uma instrução particular que não se encontra nas outras
    linguagens já estudadas, que é um operador ternário. Segue o exemplo:

        class Test{
            public static void main(String[] args){
                int i = 10;
                int j = i>10?99:1;

                System.out.println(j);
            }
        }

    O output seria:

        -> 1

    Isto porque este operador ternário é equivalente a:

            A?B:C   
        <=> IF (A) B; else C;

    Portanto, é apenas um if, com uma sintaxe diferente e mais curta para
    situações pontuais.

    Uma instrução bastante importante a considerar relativamente aos ciclos
    é o break. Vejamos o exemplo:

    class TestBreak {
        public static void main(String[] args) {
            for (int i=1; i<=2; i++) {
                for (int j=1; j<=10; j++) {
                    if (j == 3) break;
                    // Linha seguinte so sera executada quando j < 3
                    System.out.println("ciclo j = " + j + " | i = " + i);
                }
                System.out.println("ciclo i = " + i);
            }
        }
    }

    O break "quebra" o ciclo quando acharmos que seja correto. Geralmente
    é aplicado dentro de uma dada condição que queremos verificar e que 
    posteriormente a um dado ponto do ciclo, saia do mesmo.

    Outra algo similar é o continue. Vejamos o seguinte exemplo:

    class TestContinue {
        public static void main(String[] args) {
            for (int i=1; i<=4; i++) {
                System.out.println("[antes] i = " + i);
                if (i > 2) continue;
                // Linha seguinte so sera executada quando i <= 2
                System.out.println("[depois] i = " + i); 
            }
        }
    }

    O continue permite avançar dada uma certa condição dentro de um ciclo.
    Serve para a mesma coisa que o break, no entanto de uma forma diferente.
    
*/

public class Tipos{
    public static void main(String[] args){
        int i = 4; 
        int j = ~i;

        System.out.println(j);
    }
}