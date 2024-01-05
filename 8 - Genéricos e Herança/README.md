## Genéricos

No seguimento da implementação do interface Set, feito na pasta 7, há uma linha da qual ainda não falamos.

    Set<Integer> s = new TreeSet<Integer>();

Muitas das estruturas de dados de Java usam esta sintaxe:

    NomeTAD<tipo> variável

Estas linhas usam a noção de tipos *genéricos*. Por vezes precisamos de algo que funcione para qualquer tipo, ficando assim a implementação "genérica". Concretizamos o tipo na declaração da variável (como em cima).

Por exemplo, na mesma linha de código poderíamos ter antes um conjunto de Strings:

    Set<String> s = new TreeSet<String>

Vamos ver agora um exemplo de implementação com Genéricos.

Supunhamos que queremos ter um par de objetos, que funcione com qualquer tipo. Exemplos:

    - Um estudante com nome e número: (String, Integer)
    - Um ponto 2D: (Integer, Integer)
    - Um filme com nome e lista de actores: (String, TreeSet<String>)
    - Um vector com nome: (Vector, String)

Como podemos implementar uma classe Pair que funcione genericamente sem ser preciso reimplementar para cada combinação de tipos?

    public class Pair<A,B> {  // Uma implementação genérica de um par
        private A first;   // Objeto do tipo A
        private B second;  // Objeto do tipo B

        Pair (A a, B b) {
            first = a;
            second = b;
        }
        
        public A getFirst() { return first; }
        public B getSecond() { return second; }
    }

E:

    public class TestPair {  // Exemplo de uso da classe Pair
        public static void main(String[] args) {
            Pair<String,String> p1 = new Pair<String,String>("UC","ED");
            Pair<Integer,Integer> p2 = new Pair<Integer,Integer>(42,1);
            Pair<String,Integer> p3 = new Pair<String,Integer>("Dois", 2);

            String s1 = p1.getFirst();  // "UC"
            String s2 = p1.getSecond(); // "ED"
        }
    }