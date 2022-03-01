package main;
import strategy.*;

import java.util.Scanner;

import point.Point;

public class Main {
	public static void main(String[] args) {
		try {
			Point p1 = new Point(0, 0);
			Point p2 = new Point(0, 700);
			
			Hero hero1 = new Hero();
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
					hero1.setStrategy(new Walk());
					System.out.println("I spend " + hero1.executeStrategy(p1, p2) + " hours by walking\n");
					break;
				case 2:
					hero1.setStrategy(new Fly());
					System.out.println("I spend " + hero1.executeStrategy(p1, p2) + " hours moving by air\n");
					break;
				case 3:
					hero1.setStrategy(new HorseRide());
					System.out.println("I spend " + hero1.executeStrategy(p1, p2) + " hours moving on a horse\n");
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
