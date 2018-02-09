/**
 * Original Code from: 
 * https://github.com/AllenDowney/ThinkDataStructures
 *
 * This code is copied form the repository mentioned above 
 * for educational-purpose.
 */

package co.kulwadee.csc209.lect04;

import java.awt.Color;
import java.awt.BasicStroke;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Profiler extends ApplicationFrame {

    private static final long serialVersionUID = 1L; // required by ApplicationFrame

    /**
     * Define the methods an object must provide to work with Profiler.
     */
    public interface Timeable {
        /*
         * setup invoked before the clock starts.
         */
        public void setup(int n);

        /*
         * timeMe does whatever operation we are timing.
         */
        public void timeMe(int n);
    }

    private Timeable timeable;

    public Profiler(String title, Timeable timeable) {
        super(title);
        this.timeable = timeable;
    }

    public XYSeries timingLoop(int startN, int endMillis) {
        final XYSeries series = new XYSeries("Time (ms)");

        int n = startN;
        for (int i = 0; i < 20; i++) {
            // run it once to warm up
            timeIt(n);

            // then start timing
            long total = 0;

            // run 10 times and add up total runtime
            for (int j = 0; j < 10; j++) {
                total += timeIt(n);
            }

            // store only after 1ms
            if (total > 1) {
                series.add(n, total);
                System.out.println(n + ", " + total);
            }

            // stope when the runtime exceeds the end threshold
            if (total > endMillis) {
                break;
            }

            // otherwise double the size and continue
            n *= 2;
        }
        return series;
    }

    /**
     * Invokes setup and timeMe on the embedded Timeable.
     *
     * @param n
     * @return
     */
    public long timeIt(int n) {
        timeable.setup(n);
        final long startTime = System.currentTimeMillis();
        timeable.timeMe(n);
        final long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Plots the results.
     *
     * @param series
     */
    public void plotResults(XYSeries series, String chartTitle) {

        // regression line series
        Pair lineParams = estimateSlope(series);
        double slope = lineParams.item1;
        double intercept = lineParams.item2;

        System.out.println("Estimated slope = " + slope);
        System.out.println("Estimated intercept = " + intercept);
        final XYSeries regressionSeries = new XYSeries("Regression Line");

        for (Object item : series.getItems()) {
            XYDataItem xy = (XYDataItem) item;
            double x = xy.getXValue();
            double y = Math.pow(Math.E, intercept) * Math.pow(x, slope); 
            regressionSeries.add(x, y);
        }


        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(regressionSeries);

        final JFreeChart chart = ChartFactory.createXYLineChart(
                chartTitle, // chart title
                "", // domain axis label
                "", // range axis label
                dataset,
                PlotOrientation.VERTICAL, 
                true, // include legend?
                true,  // create tooltip?
                false  // create url?
                );

        final XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesStroke(1, new BasicStroke(0.8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 
                                10.0f, new float[] {10.0f}, 0.0f));
        plot.setRenderer(renderer);

        final NumberAxis domainAxis = new LogarithmicAxis("Problem size (n)");
        final NumberAxis rangeAxis = new LogarithmicAxis("Runtime (ms)");
        plot.setDomainAxis(domainAxis);
        plot.setRangeAxis(rangeAxis);
        chart.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(Color.black);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        setContentPane(chartPanel);
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

    class Pair {
        double item1, item2;
        Pair(double i1, double i2) {
            item1 = i1;
            item2 = i2;
        }
    }
    
    /**
     * Uses simple regression to estimate the slope of the series.
     *
     * @param series
     * @return
     */
    public Pair estimateSlope(XYSeries series) {
        SimpleRegression regression = new SimpleRegression();

        for (Object item : series.getItems()) {
            XYDataItem xy = (XYDataItem) item;
            regression.addData(Math.log(xy.getXValue()),
                               Math.log(xy.getYValue()));
        }
        return new Pair(regression.getSlope(), regression.getIntercept());
    }
}
