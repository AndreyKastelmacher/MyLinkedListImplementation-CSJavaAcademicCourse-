/* Assignment number:  8.5
 * File Name:          Tour.java 
 * Name (First Last):  Andrey Kastelmacher
 * Student ID :        303258537 
 * Email :             Andrey Kastelmacher@post.idc.ac.il
 */  
package linkedList;

public class Tour {
	private LinkedList<Point> pointList; 
   
	/**
    * create a new empty tour
    */
	
	public Tour() {
		this.pointList = new LinkedList<Point>();
	}

	/**
	 * creates a tour duplicate
	 * 
	 * @param other another tour to copy
	 */
	
	public Tour(Tour other) {
		this();
		ListIterator<Point> itr = other.pointList.listIterator();
		int i = 0;
		while (itr.hasNext() && i < other.pointList.size()) {
			Point currNode = itr.next();
			this.pointList.addLast(currNode);
			i++;
		}
	}

	/**
	 *draws the tour on the canvas.
	 */
	
	public void draw() {
		ListIterator<Point> itr = pointList.listIterator();
		Point first = itr.current.t;
		first.draw();
		int i = 0;
		while (itr.hasNext() && i < pointList.size()) {
			Node<Point> prevNode = itr.current;
			itr.next();
			if (prevNode.next != null) {
				Node<Point> currNode = itr.current;
				currNode.t.draw();
				prevNode.t.drawTo(currNode.t);
			}
			else {
				prevNode.t.drawTo(first);
			}
		}
	}

	/**
	 *prints the points in the tour
	 */
	public void print() {
		StdOut.println(pointList);
	}

	/**
	 * calculates all the distances 
	 * @return                                                                                     returns the total distance                                                                                                      of this tour                                                                                                                         
	 */
	public double distance() {
		double sum = 0;
		if (pointList.size() == 0 || pointList.size() == 1) {
			return sum;
		}
		ListIterator<Point> itr = pointList.listIterator();
		Point originPoint = itr.current.t;
		while (itr.hasNext()){
			Node<Point> prevNode = itr.current;
			itr.next();
			if (prevNode.next != null) {
				Node<Point> currNode = itr.current;
				sum += prevNode.t.distanceTo(currNode.t);
			} 
			else {
				sum += prevNode.t.distanceTo(originPoint);
			}
		}
		return sum;
	}

	/**
	 * returns the number of points in this tour
	 * @return - size of the list
	 */
	public int size() {
		return pointList.size();
	}

    /**
     * inserts a new point based on the smallest increase heuristic.
     * @param p - point to insert.
     */
	public void insertSmallest(Point p) {
		if (pointList.size() < 1) {
			pointList.addLast(p);
		}
		else {
			ListIterator<Point> itr = this.pointList.listIterator();
			Tour smallestTour = new Tour();
			double smallestDist = -1;
			int destination = 1;
			while (itr.hasNext()) {
				Tour tempTour = new Tour(this);
				tempTour.pointList.add(destination, p);
				destination++;
				itr.next();
				double tempDist = tempTour.distance();
				if (tempDist < smallestDist || smallestDist == -1) {
					smallestTour = new Tour(tempTour);
					smallestDist = smallestTour.distance();
				}
			}
			pointList = smallestTour.pointList;
		}
	}

    /**
     * finds the point that maximizes the effect on minimizing the tour distance/
     */
	public void optimalRemove() {
		if (pointList.size() > 1) {
			double smallestDist = this.distance();
			ListIterator<Point> itr = this.pointList.listIterator();
			itr.next();
			Point pointToRemove = itr.current.t;
			while (itr.hasNext()) {
				Tour dummyTour = new Tour(this);
				dummyTour.pointList.remove(itr.current.t);
				double thisDistance = dummyTour.distance();
				if (thisDistance < smallestDist) {
					smallestDist = thisDistance;
					pointToRemove = itr.current.t;
				}
				itr.next();
			}
			pointList.remove(pointToRemove);
		}
	}

}
