## Programação Orientada a Objetos

Programação Orientada a Objetos é um paradigma onde os principais
actores são os objetos.

Os três principais princípios são:

    - Abstração - Especificação do que um objeto deve fazer, mas não como
    o fazer (tipos abstratos de dados) (o quê vs como);

    - Encapsulamento - Esconder os detalhes internos de cada componente de
    um programa (código independente de outros objetos);

    - Modularidade - Divisão de um sistema em diferentes componentes
    funcionais (mais robustez e facilidade de debug).

Estes três princípios ajudam a melhorar a robustez, adaptabilidade e 
aumentam o potencial de reutilização do código.

## Tipos Abstratos de Dados (TAD)

Um Tipo Abstrato de Dados (TAD) é um "modelo" de um tipo de dados definido
pelo seu comportamento esperado:

    - Quais os valores que pode conter;
    - Quais as operações permitidas sobre esses valores.

Um TAD apenas define a API (Application Programming Interface)

    - Quais os métodos para interagir com o objeto (API).

Diz-se abstrato porque a sua definição não carece de uma implementação
concreta.

    Para um mesmo TAD podem existir várias implementações possíveis. Por exemplo:

    Uma pilha pode ser implementada com arrays ou com listas, um conjunto pode ser implementado com arrays ou com árvores (vamos ver vários exemplos durante o semestre).

O Java suporta TADs através do conceito de interfaces e classes.

No que concerne ao encapsulamento dos dados, não é desejável que outras classes possam aceder/modificar o estado interno da classe. Se quisermos mudar a implementação, podemos estragar outro código. Queremos promover a interação com a classe apenas com os métodos.

Para isso mesmo, existe a palavra chave *private*.

## Override

Fazer Override é o conceito de modificar o comportamento de um método que já existe, dando-lhe o comportamento mais adequado ao que queremos na nossa classe.
    