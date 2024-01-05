## Genéricos

No seguimento da implementação do interface Set, feito na pasta 7, há uma linha da qual ainda não falamos.

    Set<Integer> s = new TreeSet<Integer>();

Muitas das estruturas de dados de Java usam esta sintaxe:

    NomeTAD<tipo> variável

Estas linhas usam a noção de tipos *genéricos*. Por vezes precisamos de algo que funcione para qualquer tipo, ficando assim a implementação "genérica". Concretizamos o tipo na declaração da variável (como em cima).

Por exemplo, na mesma linha de código poderíamos ter antes um conjunto de Strings:

    Set<String> s = new TreeSet<String>

