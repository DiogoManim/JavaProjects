import java.util.Scanner;

public class palindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        int len = s.length();

        

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
