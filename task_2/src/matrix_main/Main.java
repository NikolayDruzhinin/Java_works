package matrix_main;
import matrix_lib.Matrix;
import java.io.*;


import exception.MyException;

public class Main {
	static public void main(String[] args) {
		try {
			
			Matrix m1 = new Matrix();
			m1.readMatrixSize("test.txt");
			
			m1.initMatrix();
			
			m1.printMatrix("out.txt", "Initial matrix:", false);
			
			m1.makeDivSum();
			m1.printMatrix("out.txt", "Summed matrix:", true);
			
			m1.rotate90();
			m1.printMatrix("out.txt", "Rotaded (90 degrees) matrix:", true);
			
			m1.makeDivSum();
			m1.printMatrix("out.txt", "Summed matrix:", true);
			
			m1.rotate180();
			m1.printMatrix("out.txt", "Rotaded (180 degrees) matrix:", true);
			
			m1.makeDivSum();
			m1.printMatrix("out.txt", "Summed matrix:", true);
			
			m1.rotate270();
			m1.printMatrix("out.txt", "Rotaded (270 degrees) matrix:", true);
			
			m1.makeDivSum();
			m1.printMatrix("out.txt", "Summed matrix:", true);
			
		} catch (IOException e) {
			System.out.println("Exception [IO error " + e.getMessage() + "]");
		} catch (OutOfMemoryError e) {
			System.out.println("Exception [java heap space]");
		} catch (MyException e) {
			System.out.println(e.toString());
		}
	}
}