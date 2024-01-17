## [ED191] Duplicando elementos

### Código Base

Use como base a classe **SinglyLinkedList&lt;T&gt;** (descrita no exercício 1 da aula prática 06 - não esquecer da classe **Node**) que implementa uma lista ligada simples e tem disponíveis métodos para adicionar ou remover um elemento no início ou no final, devolver o tamanho, saber se a lista está vazia ou retornar representação em string para escrita (tal como dado nas aulas).

### O problema

Acrescente à classe dada um novo método **public void duplicate()** que **duplica cada elemento da lista** (transformando a própria lista para a qual foi chamado o método).

### Exemplos de Input/Output

| Lista inicial	           | Chamada  	      | Estado da lista depois da chamada        |
|:------------------------:|:----------------:|:----------------------------------------:|
| list = {1,2,3}	       | list.duplicate() | list = {1,1,2,2,3,3}                     |
| list = {'a','b','c','d'} | list.duplicate() | list = {'a','a','b','b','c','c','d','d'} |
| list = {}                | list.duplicate() | list = {}                                |