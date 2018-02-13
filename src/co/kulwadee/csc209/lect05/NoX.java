package co.kulwadee.csc209.lect05;

public class NoX {
    public static String noX(String s) {
        if (s.length() == 0) return "";
        if (Character.toLowerCase(s.charAt(0)) == 'x') {
            return noX(s.substring(1));
        } else {
            return s.charAt(0) + noX(s.substring(1));
        }
    }
    public static void main(String[] args) {
        System.out.println("'" + args[0] + "' => '" + noX(args[0]) + "'");
    }
}

