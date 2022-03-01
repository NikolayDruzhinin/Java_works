package point;

public class Point {
	double x, y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDist(Point p) {
		return (Math.sqrt(Math.pow((p.x - this.x), 2) + 
				Math.pow((p.y - this.y), 2)));
	}
}
