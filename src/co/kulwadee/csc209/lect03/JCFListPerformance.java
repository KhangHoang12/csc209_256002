package co.kulwadee.csc209.lect03;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.DecimalFormat;

/**
 * the idea of this example was taken from
 * https://www.programcreek.com/2013/03/arraylist-vs-linkedlist-vs-vector/
 */
public class JCFListPerformance {
    public static long testListRemove(List<Integer> list) {
        int numIters = 10000;
        long startTime, endTime, duration;
        startTime = System.nanoTime();
        for (int i = numIters; i >= 0; i--) {
            list.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        return duration;
    }
    public static long testListGet(List<Integer> list) {
        int numIters = 10000;
        long startTime, endTime, duration;
        startTime = System.nanoTime();
        for (int i = 0; i < numIters; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        return duration;
    }
    public static long testListAdd(List<Integer> list) {
        int numIters = 100000;
        long startTime, endTime, duration;
        startTime = System.nanoTime();
        for (int i = 0; i < numIters; i++) {
            list.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        return duration;
    }
    public static double nanoToSeconds(long ns) {
        return ns * 10E-9;
    }
    public static String formatDecimal(double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(d);
    }
    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        long duration;
        String strDuration;

        // ArrayList add
        duration = testListAdd(arrayList);
        strDuration = formatDecimal(nanoToSeconds(duration));
        System.out.println(" ArrayList add: " + strDuration + " s");

        // LinkedList add
        duration = testListAdd(linkedList);
        strDuration = formatDecimal(nanoToSeconds(duration));
        System.out.println("LinkedList add: " + strDuration + " s");

        // ArrayList get
        duration = testListGet(arrayList);
        strDuration = formatDecimal(nanoToSeconds(duration));
        System.out.println(" ArrayList get: " + strDuration + " s");

        // LinkedList get
        duration = testListGet(linkedList);
        strDuration = formatDecimal(nanoToSeconds(duration));
        System.out.println("LinkedList get: " + strDuration + " s");

        // ArrayList remove
        duration = testListRemove(arrayList);
        strDuration = formatDecimal(nanoToSeconds(duration));
        System.out.println(" ArrayList rem: " + strDuration + " s");

        // LinkedList remove
        duration = testListRemove(linkedList);
        strDuration = formatDecimal(nanoToSeconds(duration));
        System.out.println("LinkedList rem: " + strDuration + " s");

    }
} 
