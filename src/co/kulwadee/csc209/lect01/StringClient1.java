package co.kulwadee.csc209.lect01;

public class StringClient1 {
    /**
     * Returns true if s is a Palindrome.
     * A string is a palindrome if it reads the same forward/backward.
     * E.g. madam, taco cat, racecar.
     * https://en.wikipedia.org/wiki/Palindrome
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int N = s.length();
        for (int i = 0; i < N/2; i++)
            if (s.charAt(i) != s.charAt(N-1-i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("'madam' is a Palindrome: " + isPalindrome("madam"));
        System.out.println("'Palindrome' is a Palindrome: " + isPalindrome("Palindrome") );
        System.out.println("'taco cat' is a Palindrome: " + isPalindrome("taco cat"));
    }

}
