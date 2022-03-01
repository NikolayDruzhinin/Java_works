package strategy;
import point.Point;

public class Hero {
	Strategy strategy;

	public Hero() {
		this.strategy = new Walk();
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	} //
	
	public double executeStrategy(Point p1, Point p2) {
		return strategy.move(p1, p2);
	}
}
