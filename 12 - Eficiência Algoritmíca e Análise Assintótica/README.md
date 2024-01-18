## Noções de Complexidade Algorítmica

<p align="center">
  <img src="https://github.com/DiogoManim/JavaProjects/assets/120724277/4b4dafc4-26e2-4abd-a8e7-636607b0a058"/>
</p>

#### O que é um algoritmo?

Um algoritmo é um conjunto de instruções executáveis para resolver um problema. O problema é a motivação para o algoritmo e as instruções têm de ser executáveis.

Geralmente existem vários algoritmos para um mesmo problema. O objetivo é escolher o que mais se adequa a cada caso.

A representação deve ser feita através de uma descrição das instruções, de forma a que esta seja suficiente para que a público geral o entenda.

Exemplo de um algoritmo:

![image](https://github.com/DiogoManim/JavaProjects/assets/120724277/ddd03437-6fb6-4954-a8e4-08bb8bbb0550)

#### O que é um algoritmo? (Versão Computer Science)

Os algoritmos são as ideias por detrás dos programas, independentemente da linguagem de programação ou da máquina. Um algoritmo serve para resolver um problema, e este é caracterizado pela descrição do input e output.

Um exemplo clássico:

    Problema de Ordenação

    Input: uma sequência <a1,a2,...,an> de n números
    Output: uma permutação dos números <a'1,a'2,...a'n> tal que a'1 <= a'2 <= ... <= a'n

    Exemplo para Problema de Ordenação

    Input: 6 3 7 9 2 4
    Output: 2 3 4 6 7 9

Os métodos das estruturas de dados que temos implementado também são pequenos algoritmos. Exemplos:

- addFirst, addLast, removeFirst e removeLast nas listas ligadas
- contains, add e remove no TAD Conjunto
- push e pop no TAD Pilha
- enqueue e dequeue no TAD Fila

Outros algoritmos podem usar as estruturas de dados como "legos básicos". Exemplos:

- O algoritmo de escalonamento round-robin de processos usa uma lista
circular.
- O algoritmo para verificar se uma express˜ao tem os parˆenteses bem
balanceados usa uma pilha
- Um algoritmo para simular o atendimento em balc˜oes de um banco, de
um aeroporto ou de uma loja do cidad˜ao usa uma fila

#### Propriedades desejadas num algoritmo

**Correção**
Tem de resolver correctamente todas as instâncias do problema.

**Eficiência**
Performance (tempo e memória) tem de ser adequada

#### Correção de um algoritmo

Um algoritmo correto deve resolver todas as instâncias possíveis (Ex: Para ordenação, números já ordenados, repetidos, ...). Nem sempre é fácil provar a correção de um algoritmo e muito menos é óbvio se um algoritmo está correto.

