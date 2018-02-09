/**
 * Original Code from: 
 * https://github.com/AllenDowney/ThinkDataStructures
 *
 * This code is copied form the repository mentioned above 
 * for educational-purpose.
 */

package co.kulwadee.csc209.lect04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jfree.data.xy.XYSeries;

import co.kulwadee.csc209.lect04.Profiler.Timeable;

public class ProfileListAdd {
    private static int p_startN = 4000;
    private static int p_endMillis = 1000;

    public static void main(String[] args) {
        profileArrayListAddEnd();
        profileArrayListAddBeg();
        profileLinkedListAddEnd();
        profileLinkedListAddBeg();
    }

    public static void profileArrayListAddEnd() {
        String profMesg = "# ArrayList add end";
        System.out.println(profMesg);
        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n) {
                list = new ArrayList<String>();
            }

            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add("a string");
                }
            }
        };
        int startN = p_startN;
        int endMillis = p_endMillis;
        runProfiler("ArrayList add end", timeable, startN, endMillis);
    }

    public static void profileArrayListAddBeg() {
        String profMesg = "# ArrayList add beginning";
        System.out.println(profMesg);
        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n) {
                list = new ArrayList<String>();
            }

            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add(0, "a string");
                }
            }
        };
        int startN = p_startN;
        int endMillis = p_endMillis;
        runProfiler("ArrayList add beginning", timeable, startN, endMillis);
    }

    public static void profileLinkedListAddEnd() {
        String profMesg = "# LinkedList add end";
        System.out.println(profMesg);
        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n) {
                list = new LinkedList<String>();
            }

            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add("a string");
                }
            }
        };
        int startN = p_startN;
        int endMillis = p_endMillis;
        runProfiler("LinkedList add end", timeable, startN, endMillis);
    }

    public static void profileLinkedListAddBeg() {
        String profMesg = "# LinkedList add beginning";
        System.out.println(profMesg);
        Timeable timeable = new Timeable() {
            List<String> list;

            public void setup(int n) {
                list = new LinkedList<String>();
            }

            public void timeMe(int n) {
                for (int i = 0; i < n; i++) {
                    list.add(0, "a string");
                }
            }
        };
        int startN = p_startN;
        int endMillis = p_endMillis;
        runProfiler("LinkedList add beginning", timeable, startN, endMillis);
    }

    /**
     * Runs the profiles and displays results.
     *
     * @param timeable
     * @param startN
     * @param endMillis
     */
    private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
        Profiler profiler = new Profiler(title, timeable);
        XYSeries series = profiler.timingLoop(startN, endMillis);
        profiler.plotResults(series, title);
    }

}
