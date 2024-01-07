## Listas Ligadas, Pilhas e Filas

Consideremos primeiro, uma estrutura de dados sequenciais. Estas armazenam sequências finitas de valores do mesmo tipo (numa sequência existe ordem: 1º valor, 2º valor, 3º valor, ...). Ex:

    Números: 1, 2, 3, 4, 5, 6, 7, ...
    Strings: "Portugal", "Espanha", "França", ...
    Pessoas: ("Ana", 20), ("Carlos", 23), ("Diana", 19), ...

Já conhecemos uma estrutura de dados sequencial, o array. Este guarda elementos em posições contíguas de memória.

Algumas vantagens:

    - Fácil de usar;
    - Acesso rápido a uma dada posição.

Algumas desvantagens:

    - Tamanho é fixo na criação do array (aumentar implica copiar elementos)
    - Inserções e remoções podem ser custosas (muitos shifts de elementos)

Assim sendo, precisamos de uma estrutura de dados que possa "crescer" o quanto quisermos e que seja boa para inserir e remover elementos.

Uma solução: *Listas Ligadas*. Devemos saber as seguintes propriedades da mesma:

    - Cada "nó" da sequência contém não só o valor nessa posição, mas também uma referência para o próximo elemento da sequência;

    - Precisamos de saber onde fica o primeiro elemento da lista;

    - O último elemento aponta para o "final" da lista (vamos usar null - o objeto nulo - para denotar o final da lista).

    <img width="612" alt="image" src="https://github.com/DiogoManim/JavaProjects/assets/120724277/68141a98-3d34-43ba-a329-90aa87d1fb9e">