import java.util.Scanner;

public class estatisticas {
    static void media(int v[], int n) {
        float soma = 0;

        for (int i = 0; i < n; i++){
            soma += v[i];
        }

        System.out.printf("%.2f\n", soma / n);
    }

    static void amplitude(int v[]) {
        int min = v[0];
        int max = v[0];

        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
            else if (v[i] < min) {
                min = v[i];
            }
        }

        System.out.println(max-min);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int v[] = new int[n];

        for(int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }

        media(v, n);
        amplitude(v);

        in.close();
    }
}