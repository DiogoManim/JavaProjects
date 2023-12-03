/*

    A função drawline tem 3 principais ideias:

        1 - Imprime a pontos, antes do primeiro cardinal;
        2 - Imprime b cardinais, tal que n+m é o mesmo valor da input;
        3 - Imprime a pontos, depois do último cardinal.

    Devemos ter no entanto atenção que esta requer mais dois ciclos para
    obtermos o resultado desejado. 

    A dificuldade deste exercício está nesses mesmos ciclos. É habitual
    criar uma variável i e iterar de 1 em 1 elemento. No entanto neste
    caso além de estarmos a iterar queremos que o valor de i aumente
    de 2 em 2 para o podermos reaproveitar para os aumentos/decrementos
    nas variáveis a e b.

    De notar que são dois ciclos pois um aumenta de 2 em 2 o número de 
    cardinais, enquanto que o segundo diminui, também de 2 em 2.

*/

import java.util.Scanner;

public class diamond {
    static void drawLine(int a, int b){
        for (int j=0; j<a; j++){
            System.out.print(".");
        }
        for (int j=0; j<b; j++){
            System.out.print("#");
        }
        for (int j=0; j<a; j++) {
            System.out.print(".");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for(int i=1; i<n; i+=2){
            drawLine( (n-i)/2, i);
        }

        for(int i=n; i>0; i-=2){
            drawLine( (n-i)/2, i);
        }

        in.close();
    }
}