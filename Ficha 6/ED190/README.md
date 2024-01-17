## [ED190] Cópia de uma lista

### Código Base

Use como base a classe **SinglyLinkedList&lt;T&gt;** (descrita no exercício 1 da aula prática 06 - não esquecer da classe **Node**) que implementa uma lista ligada simples e tem disponíveis métodos para adicionar ou remover um elemento no início ou no final, devolver o tamanho, saber se a lista está vazia ou retornar representação em string para escrita (tal como dado nas aulas).

### O problema

Acrescente à classe dada um novo método public **SinglyLinkedList&lt;T&gt; copy()** que **cria e devolve uma nova lista que é uma cópia exacta da lista para a qual foi chamado o método**. Note que o retorno tem de ser uma **nova lista**, contendo um novo conjunto de objectos do tipo Node&lt;T&gt; que guardam valores iguais aos da lista inicial (não precisa de criar cópias dos valores, cada nó da nova lista deve apontar para a referência respectiva da lista inicial).

### Exemplos de Input/Output

| Lista inicial	                     | Chamada  	          | Nova Lista                            |
|:----------------------------------:|:----------------------:|:-------------------------------------:|
| list = {2,4,6,8}	                 | newList = list.copy()  | newList = {2,4,6,8}                   |
| list = {}	                         | newList = list.copy()  | newList = {}                          |
| list = {"estruturas","de","dados"} | newList = list.copy()  | newList = {"estruturas","de","dados"} |