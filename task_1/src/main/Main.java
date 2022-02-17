package main;
import strategy.*;
import point.Point;

public class Main {
	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 700);
		
		Context context = new Context();
		
		context.setStrategy(new Walk());
		System.out.println("I spend " + context.executeStrategy(p1, p2) + " hours by walking\n");
		
		context.setStrategy(new Fly());
		System.out.println("I spend " + context.executeStrategy(p1, p2) + " hours moving by air\n");
		
		context.setStrategy(new HorseRide());
		System.out.println("I spend " + context.executeStrategy(p1, p2) + " hours moving on a horse\n");
	}
}
