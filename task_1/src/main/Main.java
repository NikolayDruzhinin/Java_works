package main;
import strategy.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import point.Point;

public class Main {
	public static void main(String[] args) {
		try {
			Point p1 = new Point(0, 0);
			Point p2 = new Point(0, 700);
			
			Context context = new Context();
			System.out.println("To change the Hero's mod of movement press:");
			System.out.println("1 - walk,");
			System.out.println("2 - fly,");
			System.out.println("3 - horse ride");
			System.out.println("press 0 to exit");
			Scanner s = new Scanner(System.in);
			int oper = s.nextInt();
			while (oper != 0) {
				switch (oper) {
				case 0:
					break;
				case 1: 
					context.setStrategy(new Walk());
					System.out.println("I spend " + context.executeStrategy(p1, p2) + " hours by walking\n");
					break;
				case 2:
					context.setStrategy(new Fly());
					System.out.println("I spend " + context.executeStrategy(p1, p2) + " hours moving by air\n");
					break;
				case 3:
					context.setStrategy(new HorseRide());
					System.out.println("I spend " + context.executeStrategy(p1, p2) + " hours moving on a horse\n");
					break;
				default:
					System.out.println("Incorrect operation num, let's try again");
					break;
				}
				oper = s.nextInt();
			}
			s.close();
		}
		catch (Exception e){
			System.out.println("Incorrect input");
		}
	}
}
