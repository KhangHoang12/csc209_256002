package co.kulwadee.csc209.lect05;

import java.awt.Color;

public class AnimatedTowersOfHanoi {
    public static void draw(int[] pole) {
        int n = pole.length - 1;

        // draw 3 poles
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.002);

        for (int i = 0; i < 3; i++)
            StdDraw.line(i, 0, i, n);

        // draw N discs
        int[] discs = new int[3];
        for (int i = n; i >= 1; i--) {
            Color color = Color.getHSBColor(1.0f * i / n, 0.7f, 0.7f);
            StdDraw.setPenColor(color);
            StdDraw.setPenRadius(0.035);
            double size = 0.5 * i / n;
            int p = pole[i];
            StdDraw.line(p-size/2, discs[p], p+size/2, discs[p]);
            ++discs[p];
        }
        StdDraw.show();
        StdDraw.pause(1600);
    }

    public static void hanoi(int n) {
        int[] pole = new int[n+1];
        draw(pole);
        hanoi(n, 0, 1, 2, pole);
    }

    public static void hanoi(int n, int from, int temp, int to, int[] pole) {
        if (n == 0) return;
        hanoi(n-1, from, to, temp, pole);
        System.out.println("Move disc " + n + " from pole " + from 
                + " to pole " + to);
        pole[n] = to;
        draw(pole);
        hanoi(n-1, temp, from, to, pole);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int WIDTH = 200;
        int HEIGHT = 40;

        StdDraw.setCanvasSize(4*WIDTH, (n+3)*HEIGHT);
        StdDraw.setXscale(-1, 3);
        StdDraw.setYscale(-1, n+3);
        StdDraw.enableDoubleBuffering();

        hanoi(n);
    }
}
