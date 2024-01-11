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
    public String toString() {
        
    }