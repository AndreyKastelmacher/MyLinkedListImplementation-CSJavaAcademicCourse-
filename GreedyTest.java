package linkedList;


/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac GreedyTest.java
 *  Execution:    java GreedyTest filename
 *  Dependencies: Tour.java Point.java StdIn.java StdDraw.java StdOut.java
 *
 *  Run smallest insertion heuristic for traveling salesperson problem
 *  and plot results.
 *
 *  % java GreedyTest tsp1000.txt
 *
 *************************************************************************/

public class GreedyTest {

    public static void main(String[] args){
	
    	String filename = args[0];
    	StdIn.setInput(filename);
    	
        // get dimensions
        int w = StdIn.readInt();
        int h = StdIn.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        // turn on animation mode
        StdDraw.show(0);

        // run smallest insertion heuristic
        Tour tour = new Tour();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            String name = StdIn.readLine();
            Point p = new Point(x, y, name);
            tour.insertSmallest(p);

             // uncomment the 4 lines below to animate
             StdDraw.clear();
             tour.draw();
             StdDraw.text(100, 0, "" + tour.distance());
             StdDraw.show(50);
        }
        
        //optimize the tour by removing one point
        tour.optimalRemove();
        
        // draw to standard draw
        StdDraw.clear();
        tour.draw();
        StdDraw.text(100, 0, "" + tour.distance());
        StdDraw.show(0);
        
        // print tour to standard output
        StdOut.printf("Tour distance =  %.4f\n", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
        tour.print();
    }

}
