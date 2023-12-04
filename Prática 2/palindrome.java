import java.util.Scanner;

public class palindrome {

    public static boolean isPalindrome(String s) {
        
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        int n = s.length();

        for (int i = 0, j = 0; i < n; i++, j--) {
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

            String s = in.nextLine();

            if (isPalindrome(s))
                System.out.println("sim");
            else
                System.out.println("nao");
        }

        in.close();
    }

}