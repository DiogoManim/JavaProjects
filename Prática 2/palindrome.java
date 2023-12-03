import java.util.Scanner;

public class palindrome {

    public static boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        
        int n = s.length();

        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        java.util.Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(n);

        for (int i = 0; i < n; i++) {
            if (isPalindrome(in.nextLine()))
                System.out.println("sim");
            else
                System.out.println("nao");
        }

        in.close();
    }

}