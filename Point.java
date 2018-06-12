/* Assignment number:  8.1
 * File Name:          Point.java 
 * Name (First Last):  Andrey Kastelmacher
 * Student ID :        303258537 
 * Email :             Andrey Kastelmacher@post.idc.ac.il
 */  
package linkedList;

public class Point {
	private double x;
	private double y; 
	private String name;
	/**
	 * Creates a point with the given coordinates and name
	 * @param x - point x in plane
	 * @param y - point y in plane
	 * @param locName - name of the point
	 */
	public Point(double x, double y, String locName){
		this.x = x;
		this.y  = y;
		this.name = locName;
	}
	/**
	 * Returns the Euclidean distance between this point and other 
	 * @param other
	 * @return distance
	 */
	public double distanceTo(Point other){
		double x1 = this.x;
		double y1 = this.y;
		double x2 = other.x;
		double y2 = other.y;
		return Math.sqrt(Math.pow(x2 - x1,  2) +
				Math.pow(y2 - y1,  2));
	}
	
	/**
	 * draws the point and its name on the canvas at the given location.
	 */
	public void draw(){
		StdDraw.point(this.x, this.y);
		StdDraw.text(this.x,  this.y, this.name);
	}
	
    /**
     * draws a line between two points on the canvas
     * @param other
     */
	public void drawTo(Point other){
		double x1 = this.x;
		double y1 = this.y;
		double x2 = other.x;
		double y2 = other.y;
		StdDraw.line(x1, y1, x2, y2);
	}
	
	/**
	 * returns a string of the point 
	 */
	public String toString(){
		return "(" + this.x + "," + this.y + ") - " + this.name;
	}
}
