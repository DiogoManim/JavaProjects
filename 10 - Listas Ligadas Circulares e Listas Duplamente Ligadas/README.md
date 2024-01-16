## Dados Circulares

Tipicamente listas guardam sequências de um início até ao fim. No entanto em algumas aplicações, os dados podem mais naturalmente ser vistos como tendo ordem cíclica: cada elemento tem um anterior e um seguinte, mas não existe um princípio ou fim bem definido.

Exemplos:

    - Jogos por turnos: joga jogador A, depois jogador B, depois jogador C e por aí adiante até voltar ao jogador A e continuar (ex: jogos de cartas);

    - Rotas de transportes: algumas rotas de transportes são circulares (ex: um metro numa sequência definida, mas em loop contínuo).

### Escalonamento Round-Robin

Multitasking: um sistema operativo moderno (SO) tem a capacidade de ter vários processos a serem executados "em simultâneo". Como é possível suportar tantos processos quanto necessário?

Os SO's permitem partilha de tempo (time-sharing) do CPU tipicamente usando um algoritmo de escalonamento do tipo round-robin.

Cada processo recebe um pequeno intervalo de tempo (time slot). No final desse intervalo desse time slot o processo é parado (mesmo que não tenha terminado).

Outro processo vai ficando ativo e recebendo à vez um time slot seguido de uma ordem cíclica. Novos processos podem ir sendo adicionados e os processos que terminam vão sendo removidos.

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/94fd9a80-8f61-4233-ac2d-5069b790d29e)

Como poderíamos implementar um algoritmo de round-robin?

Uma hipótese seria usar uma lista ligada simples (SinglyLinkedList &lt;Process&gt; list) e repetidamente fazer o seguinte:

    -> Process p = list.getFirst(); list.removeFirst()

    -> Dar um time slot ao processo p

    -> list.addLast(p)

Não é o mais "natural": obriga a ir retirando e depois novamente adicionar um nó (e mexer em atributos como size).

Vamos mostrar como uma pequena alteração à nossa lista ligada tornaria tudo mais simples (mostrando também a vantagem de conhecer as estruturas de dados e poder adaptá-las às nossas necessidades).

## Listas Ligadas Circulares

Uma Lista Ligada Circular é essencialmente uma lista ligada onde o último nó "aponta" para o primeiro.

Vamos implementá-la como CircularLinkedList&lt;T&gt;

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/ec341d0f-4d46-4692-99b6-297849a9b131)

Os nós são iguais aos da lista ligada simples: Node&lt;T&gt;

Também para mostrar uma variante, ao invés de uma referência para o primeiro, vamos manter apenas uma referência para o último (o primeiro é sempre a seguir ao último (last)).

#### Implementação

Construtor, size() e isEmpty() são essencialmente os mesmos:

    public class CircularLinkedList<T> {
        private Node<T> last;   // Último nó da lista
        private int size;       // Tamanho da lista

        // Construtor (cria lista vazia)
        CircularLinkedList() {
            last = null;
            size = 0;
        }

        // Retorna o tamanho da lista
        public int size() {
            return size;
        }

        // Devolve true se a lista estiver vazia ou falso caso contrário
        public boolean isEmpty() {
            return (size == 0);
        }
    }

getFirst() e getLast() ficam triviais:

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty()) return null;
        return last.getNext().getValue();
    }

    // Retorna o último valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty()) return null;
        return last.getValue();
    }

Para poder aplicar round-robin vamos implementar um método rotate() que essencialmente avança um elemento na lista. Chamando repetidas vezes rotate() temos o desejado round-robin!

    // Roda a lista (o primeiro passa a ser o novo último da lista)
    public void rotate() {
        if (!isEmpty())    // Se estiver vazia não faz nada
            last = last.getNext();
    }

Adicionar um elemento no início (exceção: lista vazia):

    // Adiciona v ao início da lista
    public void addFirst(T v) {
        if (isEmpty()) {
            last = new Node<T>(v, null);
            last.setNext(last);       // Apontar para si próprio em "loop"
        } else {
            Node<T> newNode = new Node<T>(v, last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

Adicionar no final pode ser feito usando o addFirst:

    // Adiciona v ao final da lista
    public void addLast(T v) {
        addFirst(v);
        last = last.getNext();
    }

Para remover o primeiro, basta atualizar para quem o último nó aponta:

    // Remove o primeiro elemento da lista (se for vazia não faz nada)
    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) last = null;
        else last.setNext(last.getNext().getNext());
        size--;
    }

Remover o último é mais complicado porque temos de conseguir chegar à penúltima posição (para a atualizar). Ex:

    // Remove o último elemento da lista (se for vazia não faz nada)
    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            last = null;
        } else {
            Node<T> cur = last.getNext();
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            last = cur;
            last.setNext(last.getNext().getNext());
        }
        size--;
    }

Para converter para String é só percorrer a lista (e ter cuidado com as vírgulas):

    // Converte a linha para uma String
    @Override
    public String toString() {
        String str = "{";
        Node<T> cur = last.getNext();
        for (int i = 0; i < size; i++) {
            str += cur.getValue();
            if (cur != last) str += ",";
            cur = cur.getNext();
        }
        str += "}";
        return str;
    }

## Listas Duplamente Ligadas

Um dos problemas com as listas ligadas anteriores (simples e circular) é que não conseguem remover o último de forma eficiente. Para remover o último precisamos de mudar o next do penúltimo e para chegar ao penúltimo precisamos de percorrer a lista.

Uma maneira de resolve risto é ter em cada nó uma referência para o anterior (para além da referência para o próximo).

É este o conceito de listas duplamente ligadas.

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/ac66046f-6da1-4dc6-9182-35ef473a398e)

#### Implementação

Os nós têm portanto de ter também referência para o anterior.

    public class DNode<T> {
        private T value;            // Valor guardado no nó
        private DNode<T> prev;      // Referência para o nó anterior da lista
        private DNode<T> next;      // Referência para o próximo nó da lista

        // Construtor
        DNode(T v, DNode<T> p, DNode<T> n) {
            value = v;
            prev = p;
            next = n;
        }

        // Getters e Setters
        public T getValue() { return value; }
        public DNode<T> getPrev() { return prev; }
        public DNode<T> getNext() { return next; }
        public void setValue(T v) { value = v; }
        public void setPrev(DNode<T> p) { prev = p; }
        public void setNext(DNode<T> n) { next = n; }
    }

Para testar todo o código da DoublyLinkedList basta executar TestDoublyLinkedList que está nesta pasta.

Vamos agora abordar uma técnica muito útil usada na implementação. Por vezes quando existem muitos casos excecionais, é mais fácil criar sentinelas. São dados fictícios ("dummy") que nos permitem deixar de ter esses casos limite.

Vamos adicionar dois nós sentinelas: um no início e outro no fim.

Com isto, casos excecionais da lista "vazia" ou tamanho 1 nunca acontecem. Nunca temos de adicionar ao verdadeiro início ou fim, qualquer inserção é sempre no meio de dois nós.

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/cfe6f41c-6571-41a0-910b-f9c85e441f6d)

No início basta criar a lista já com os dois nós sentinelas:

    // Construtor (cria lista vazia com dois nós sentinelas)
    DoublyLinkedList() {
        first = new DNode<T>(null, null, null);
        last = new DNode<T>(null, first, null); // Antes do último vem o 1º
        first.setNext(last); // A seguir ao primeiro vem o último
        size = 0;
    }

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/4619d76e-0a22-4d1b-97ae-63f4da6ac74b)

Qualquer inserção passa a ser agora inserida entre dois nós. Nunca inserimos antes do primeiro nó sentinela nem nunca inserimos depois do segundo nó sentinela.

Código para inserir entre dois nós:

    // Adiciona elemento entre dois nós n1 e n2
    private void addBetween(T v, DNode<T> n1, DNode<T> n2) {
        DNode<T> newNode = new DNode<T>(v, n1, n2);
        n1.setNext(newNode);
        n2.setPrev(newNode);
        size++;
    } 

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/5837d885-3b2c-4fa8-843b-d126617772db)

Para inserir no início ou no fim é só chamar o addBetween:

    - addFirst é inserir entre first e first.next
    - addLast é inserir entre last.prev e last

    // Adiciona v ao início da lista
    public void addFirst(T v) {
        addBetween(v, first, first.getNext());
    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        addBetween(v, last.getPrev(), last);
    }