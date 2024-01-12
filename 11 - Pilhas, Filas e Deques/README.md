### Tipos Abstratos de Dados (TADs) sequenciais

Listas ligadas e arrays são exemplos de estruturas de dados primárias (cada uma com as suas vantagens e desvantagens).

Subindo um pouco o nível de abstração, vamos agora abordar TADs sequenciais, para que servem e como usá-las.

Vamos falar de 3 TADs diferentes:

    - Pilhas (Stacks);
    - Filas (Queues);
    - Filas com 2 extremos (Deques - Double Ended Queues).

Estes TADs podem ser implementados de diferentes maneiras (ex: usando arrays ou listas ligadas).

Estes TADs vão ser mais tarde "legos básicos" para outros algoritmos que vamos aprender nesta e noutras unidades curriculares. Por exemplo:

    - O algoritmo de pesquisa em largura num grafo usa a noção de fila;
    - O algortimo de Tarjan para descobrir componentes fortemente conexos usa a noção de pilha.

## Pilhas

Uma Pilha (Stack) é um TAD para guardar uma coleção de elementos suportando duas operações principais:

    - push(x) que adiciona um elemento x à coleção;
    - pop() que retira o último elemento que foi adicionado.

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/e5c3eafd-05ed-4eff-9960-e90e7cf45870)

Por ter estas propriedadades diz-se que é LIFO (Last In, First Out).

Uma pilha simula precisamente uma "pilha de coisas", de objetos empilhados uns em cima dos outros.

Para além do push(x) e pop() é usual ter-se operações top() para ver o elemento no topo da pilha, size() (para saber o tamanho) e isEmpty() (para saber se está vazia).

Vamos criar uma interface MyStack para representar este TAD. Recordemos que o interface só define a API (os métodos), mas não como implementá-los. (Usamos o nome MyStack para distinguir do Stack que existe na própria linguagem Java)

    public interface MyStack<T> {

        // Métodos que modificam a pilha
        public void push(T v);  // Coloca um valor no topo da pilha
        public T pop();         // Retira e retorna o valor no topo da pilha

        // Métodos que acedem à informação (sem modificar)
        public T top();             // Retorna valor no topo da pilha
        public int size();          // Retorna quantidade de elementos na pilha
        public boolean isEmpty();   // Indica se a pilha está vazia
    }

Para implementar podemos usar listas ligadas. A implementação 