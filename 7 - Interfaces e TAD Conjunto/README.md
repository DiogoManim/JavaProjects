## TAD Conjunto

Vamos agora definir um novo TAD: um conjunto

    Representa um conjunto de elementos sem repetições
    Ex:
    S = {1, 4, 7, 42}
    T = {"ola", "mundo"}

    Suporta operações como adicionar um elemento, remover um elemento, verificar se um elemento está no conjunto, etc.

Este TAD é muito útil como peça base em vários algoritmos. 

    Ex:
    Quantos elementos diferentes existem no input?
    É só colocar todos num conjunto e ver o seu tamanho

    Quero fazer uma pesquisa por um conjunto de sítios, mas não quero voltar a um sítio onde já estive?
    Guardo os sítios visitados num conjunto e uso a operação de verificar

Vamos agora implementar este TAD.

Queremos implementar as seguintes operações básicas:
(Existiriam mais operações possíveis como a união, interseção, etc.)

    Supunhamos: S = {1, 4, 7, 42}

    boolean contains(x) - Verifica se o elemento x está no conjunto. 
    Retorna true se o elemento está no conjunto e false caso contrário.
    Ex: S.contains(1) -> true
        S.contains(2) -> false

    boolean add(x) - adiciona o elemento x ao conjunto.
    Retorna true se foi adicinado ou false caso x já esteja no conjunto.

    boolean remove(x) - remove o elemento x do conjunto.
    Retorna true se foi removido ou false caso x não esteja no conjunto.
    Ex: S.remove(7) -> true (atualiza S para -> S = {1, 4, 42})

    int size() - retorna o número de elementos do conjunto.

    void clear() - limpa o conjunto (torna-o vazio);

Desta forma, obtemos a API que queremos implementar, com os métodos supra citados.

Um exemplo de utilização e do significado das operações:

    Seja S um conjunto.

    Inicialmente S = {}

    S.add(1) iria devolver true e tornar S = {1}

    S.add(5) iria devolver true e tornar S = {1,5}

    S.add(7) iria devolver true e tornar S = {1,5,7}

    S.contains(1) iria devolver true

    S.contains(2) iria devolver false

    S.add(1) iria devolver false e continuaríamos com S = {1,5,7}

    Nesta fase S.size() iria devolver 3, o número de elementos de S

    S.remove(5) iria devolver true e tornar S = {1,7}

    S.remove(5) iria devolver false e continuaríamos com S = {1,7}

    S.clear() iria tornar S = {}

Por uma questão de simplificação, iremos implementar um conjunto de números inteiros.

## Interface

O Java permite usar a noção de *interface* para especificar uma API (a assinatura dos métodos) sem explicar como implementar:

    - Isto permite uma verdadeira abstração do TAD

    - Permite que uma classe tenha um objeto do tipo desse interface e saiba que tem acesso a toda a API

    - Obriga uma classe que implemente essa interface a declarar todos os métodos definidos na API

Uma interface em Java essencialmente é uma declaração dos métodos sem especificar o seu corpo (o código que implementa o método).

    interface IntSet {
        public boolean  contains(int x);    // Retorna true se x está no conjunto
        public boolean  add(int x);         // Adiciona x ao conjunto
        public boolean  remove(int x);      // Remove x do conjunto
        public int      size();             // Retorna o nr de elementos do conjunto
        public void     clear();            // Limpa o conjunto (torna-o vazio)
    }

Dentro de um outro programa, podemos ter variáveis do tipo da interface.

    IntSet s;

Ou num outro exemplo possível de utilização:

    void doSomething(IntSet s)

Uma interface não tem construtores. Não permite criar (instanciar) um novo objeto desse tipo. Para isso precisamos de ter a implementação em si.

Logo, não podemos fazer (quando temos só a interface):

    IntSet s = new IntSet();

Uma classe pode dizer que implementa uma interface. Vejamos o exemplo:

    class Xpto implements IntSet {
        // (...)
    }

Se a classe não implementar todos os métodos da Interface, o Java gera um erro de compilação: *Xpto is not abstract and does not override abstract method clear() in IntSet*

Tendo a classe definida podemos instanciar objetos desse tipo:

    IntSet s = new Xpto();

Como s é do tipo IntSet apenas poderá chamar métodos do interface (mesmo que Xpto implemente outros métodos).

Vamos agora implementar então o interface IntSet como atrás definido.

A primeira coisa a pensar é como implementar.

Existem muitas hipóteses de implementação com diferentes vantagens e desvantagens (Ex: tempo de execução; gastos de memória).

Não existe implementação "perfeita": dependendo do uso, uma pode ser melhor que outra.

Vamos precisamente querer perceber as implementações para perceber os vários tradeoffs e saber escolher a melhor para o nosso caso em particular.

Vamos começar por usar um array. Como implementariamos um IntSet?

    - Vamos manter num array elem uma lista de elementos;
    - O tamanho do array determina o número máximo de elementos;
    - Mantemos numa outra variável size o número de elementos.

Por exemplo, o conjunto {1,5,7} seria representado por:

    elem = [1, 5, 7]
    size = 3

Operacionalizando isto, os atributos seriam:

    // Implementa um conjunto usando um array com lista de elementos
    class ArrayListIntSet implements IntSet {
        private int size;
        private int elem[];

        // (...)
    }

Os métodos que se seguem são para serem colocados dentro da classe ArrayListIntSet.

Como poderia ser o construtor?

    // Construtor que recebe como argumento o número máximo de elementos
    ArrayListIntSet(int maxSize) {
        elem = new int[maxSize];
        size = 0;
    }

Para devolver o número de elementos, só precisamos de ir buscar o valor da variável size:

    public int size(){
        return size;
    }

Para limpar o conjunto é só colocar a variável size em zero (não é preciso limpar elem[] porque size determina as posições que "interessam"):

    public void clear() {
        size = 0;
    }

Como verificar se um elemento está no conjunto?

    public boolean contains(int x) {
        for (int i = 0; i < size; i++)
            if (elem[i] == x)
                return true;
        return false;
    }

Como adicionar um elemento? (podemos aproveitar outros métodos, como o contains())

    public boolean add(int x) {
        if (!contains(x)) {
            elem[size] = x;
            size++;
            return true;
        }
        return false;
    }