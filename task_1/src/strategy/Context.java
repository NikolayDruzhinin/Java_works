package strategy;
import point.Point;

public class Context {
	Strategy strategy;
	
	public Context() {
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public double executeStrategy(Point p1, Point p2) {
		return strategy.move(p1, p2);
	}
}
