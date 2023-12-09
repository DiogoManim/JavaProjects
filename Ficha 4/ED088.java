/* -----------------------------------
  Estruturas de Dados 2020/2021
  Jogo da Vida [ED088]  
----------------------------------- */

import java.util.Scanner;

// Classe para representar um jogo
class Game{
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo
    
    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c){
	rows = r;
	cols = c;
	m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in){
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]
    public void write(){
        for(int i=0; i<rows; i++){
	    for(int j=0; j<cols; j++){
		if(m[i][j] == ALIVE)
		    System.out.print(ALIVE);

		else
		    System.out.print(DEAD);
	    }

	    System.out.println();
	}
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x){
	int count = 0;
	
	for(int i=-1; i<=1; i++){
	    for(int j=-1; j<=1; j++){
		if((y+i) >= 0 && (y+i) < rows && (x+j) >= 0 && (x+j) < cols){
		    if(m[y+i][x+j] == ALIVE && (i != 0 || j != 0))
			count++;
		}
	    }
	}
	
	return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate(){
	int viz;
	char m2[][] = new char[rows][cols];

	for(int i=0; i<rows; i++){
	    for(int j=0; j<cols; j++){
		viz = countAlive(i, j);

		if(m[i][j] == ALIVE && (viz <= 1 && viz >= 4))
		    m2[i][j] = DEAD;

		else if(m[i][j] == ALIVE && (viz == 2 || viz == 3))
		    m2[i][j] = ALIVE;

		else if(m[i][j] == DEAD && viz == 3)
		    m2[i][j] = ALIVE;

		else
		    m2[i][j] = DEAD;
	    }
	}

	for(int i=0; i<rows; i++)
	    for(int j=0; j<cols; j++)
		m[i][j] = m2[i][j];
    }

}

// Classe principal com o main()
public class ED088{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = in.nextInt();
	int cols = in.nextInt();
	int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game g = new Game(rows, cols);
	
	g.read(in);

	for(int i=0; i<n; i++)
	    g.iterate();
	
	g.write();
    }
}