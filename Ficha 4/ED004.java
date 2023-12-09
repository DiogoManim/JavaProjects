import java.util.Scanner;

class Game {
    private int n;
    private char m [][];

    // Construtor para criar o tabuleiro NxN
    public Game (int n) {
        this.n = n;
        m = new char[n][n];
    }

    // Método para ler o conteúdo do tabuleiro
    public void read (Scanner in) { 
        for (int i = 0; i < n; i++) {
            String buf = in.next();         // buf = buffer (varíavel)
            for (int j = 0; j < n; j++) {
                m[i][j] = buf.charAt(j);
            }
        }
    }

    // Mostra a matriz dada
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    // Verifica se a linha/diagonal que começa em (x,y) e se está toda 
    // preenchida
    public void verify(int y, int x, int incy, int incx) {     // inc = incremento
        if (m[y][x] == '.') return;

        // Sendo yy e xx os valores que vão variando para verificar se na 
        // linha/diagonal há um vencedor
        for (int i = 0, yy = y, xx = x; i < n; i++, yy += incy, xx += incx)
            if (m[y][x] != m[yy][xx]) return;

        
        win(m[y][x]);
    }

    public void win(char player) {
        System.out.println("Ganhou o " + player);
        System.exit(0);     // Saí do programa (equivale a return 0 no C)
    }

    // Verifica o estado do tabuleiro (resolve o prob.)
    public void check() {
        for (int i = 0; i < n; i++)
            verify(i, 0, 0, 1); // Linhas

        for (int j = 0; j < n; j++)
            verify(0, j, 1, 0); // Colunas

        verify (0, 0, 1, 1);  // Diagonal 1

        verify (n-1, 0, -1, 1);      // Diagonal 2

        if (finished())
            System.out.println("Empate");
        else
            System.out.println("Jogo incompleto");
    }

    // Verifica se o tabuleiro está todo preenchido
    public boolean finished() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (m[i][j] == '.') 
                    return false;
        return true;
    }
}

public class ED004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Game g = new Game(n);
        g.read(in);
        g.check();
    }
}
