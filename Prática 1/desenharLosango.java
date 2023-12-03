import java.util.Scanner;

public class desenharLosango {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Draw the lines of the diamond
        for (int i = 0; i < n; i++){
            // Draw the first part of the diamond
            for (int a = n-1; a >= 0; a-=2){
                for (int j = a/2; j > 0; j--){
                    System.out.print(".");
                }

                while 

                for (int j = a/2; j > 0; j--){
                    System.out.print(".");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
