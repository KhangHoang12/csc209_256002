package co.kulwadee.csc209.lect01;

import java.util.Scanner;

public class StringClient2 {
    public static void main(String[] args) {
        String query = "taco cat";

        // find lines containing a specified query in
        // Standard input (System.in)
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.contains(query))
                System.out.println(">> Found query: " + s);
        }
    }
}
