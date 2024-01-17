## [ED192] Contando elementos

### Código Base

Use como base a classe **SinglyLinkedList&lt;T&gt;** (descrita no exercício 1 da aula prática 06 - não esquecer da classe **Node**) que implementa uma lista ligada simples e tem disponíveis métodos para adicionar ou remover um elemento no início ou no final, devolver o tamanho, saber se a lista está vazia ou retornar representação em string para escrita (tal como dado nas aulas).

### O problema

Acrescente à classe dada um novo método **public int count(T value)** que **conta e devolve o número de ocorrências do valor value** na lista. Note que para comparar os elementos deverá usar o método **equals** e não um simples **==** (pode assumir que os objectos da lista têm implementada uma versão correcta do **equals**).

### Exemplos de Input/Output

| Lista inicial	                    | Chamada  	       | Valor de retorno |
|:---------------------------------:|:----------------:|:----------------:|
| list = {42,200,42,9999,42,200,42} | list.count(42)   | 4                |
| list = {42,200,42,9999,42,200,42} | list.count(200)  | 2                |
| list = {42,200,42,9999,42,200,42} | list.count(9999) | 1                |
| list = {42,200,42,9999,42,200,42} | list.count(1)    | 0                |
| list = {"cc","cc","cc","cc","cc"} | list.count("cc") | 5                |