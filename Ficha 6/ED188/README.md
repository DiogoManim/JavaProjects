## [ED188] Devolver elemento numa dada posição

### Código Base

Use como base a classe **SinglyLinkedList&lt;T&gt;** (descrita no exercício 1 da aula prática 06 - não esquecer da classe **Node**) que implementa uma lista ligada simples e tem disponíveis métodos para adicionar ou remover um elemento no início ou no final, devolver o tamanho, saber se a lista está vazia ou retornar representação em string para escrita (tal como dado nas aulas).

### O problema

Acrescente à classe dada um novo método **public T get(int pos)** que **devolve o valor do nó na posição pos** (assuma que as posições começam em zero). Se a posição não existir, o método deverá devolver null.

### Exemplos de Input/Output

| Lista inicial	                     | Chamada  	| Valor de retorno |
|:----------------------------------:|:------------:|:----------------:|
| list = {2,4,6}	                 | list.get(0)	| 2                |
| list = {'a','b','c','d'}	         | list.get(3)	| 'd'              |
| list = {"estruturas","de","dados"} | list.get(3)  | null             |
| list = {"estruturas","de","dados"} | list.get(-1) | null             |