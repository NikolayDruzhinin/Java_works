package strategy;
import point.Point;

public class Fly implements Strategy{
	final double speed = 800;
	public double move(Point p1, Point p2) {
		System.out.println("Flying " + p1.getDist(p2) + 
				" km...Average speed is about " + speed + " km/h");
		return (p1.getDist(p2) / speed);
	}
}
