package matrix_lib;
import java.io.*;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

import exception.*;
import exception.MyException.errorCodes;

public class Matrix {
	
	int N;
	double[][] matrix;
	static final int MAX_SIZE = 1000000;
		
	public void readMatrixSize(String fName) throws MyException{
		try (Scanner in = new Scanner(new File(fName), StandardCharsets.UTF_8);) {
			
		if (!(in.hasNextInt()))
			throw new MyException(errorCodes.INCORRECT_VALUE);
			
		N =  in.nextInt();
			
			if (N > MAX_SIZE)
				throw new MyException(errorCodes.MATRIX_SIZE);
				
		} catch (NoSuchElementException e) {
			System.out.println("Exception [No data to read in file " + fName + "]");
		} catch (IOException e) {
			System.out.println("Exception [Error while reading file  " + fName + "]");
		} 
	}

	public void initMatrix() throws OutOfMemoryError {
		matrix = new double[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				matrix[i][j] = -N + Math.random() * 2 * N;
			}
		}
	}	
	
	public void printMatrix() throws IOException{
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.format("%8.2f", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printMatrix(String fName, String description, boolean app) 
			throws IOException {
		try(FileWriter fw = new FileWriter(fName, StandardCharsets.UTF_8, app);
		PrintWriter out = new PrintWriter(fw);) {
			out.println(description);
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					out.format("%8.2f", matrix[i][j]);
				}
				out.println();
			}
			out.println();
		}
	}
	
	public void rotate90() {
		double [][] tmp = new double[N][N];
		for (int i = 0; i < N; ++i) {
			System.arraycopy(matrix[i], 0, tmp[i], 0, N);
		}
		
		for (int i = 0; i < N; ++i) {
			double [] trow = matrix[i];
			for (int j = 0; j < N; ++j) {
				tmp[j][i] = trow[(N - 1) - j]; 
			}
		}
		matrix = tmp;
	}
	
	public void rotate180() {
		int mid = (N % 2 == 0) ? (N / 2) : (N / 2 + 1);
		double tmp;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < mid; ++j) {
				if (N % 2 != 0 && i >= N /2 && j == N / 2)
					continue;
				tmp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - i][N - 1 - j];
				matrix[N - 1 - i][N - 1 - j] = tmp;
			}
		}
	}
	
	public void rotate270() {
		this.rotate180();
		this.rotate90();
	}
	
	public void makeDivSum() throws MyException {
		double [][] tmp = new double[N][N];
		for (int i = 0; i < N; ++i) {
			System.arraycopy(matrix[i], 0, tmp[i], 0, N);
		}
		
		double sum = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sum += ((i - 1) >= 0) ? tmp[i - 1][j] : 0;
				sum += ((i + 1) > (N - 1)) ? 0 : tmp[i + 1][j];
				sum += ((j - 1) >= 0) ? tmp[i][j - 1] : 0;
				sum += ((j + 1) > (N - 1)) ? 0 : tmp[i][j + 1];
				if (sum == 0d) 
					throw new MyException(errorCodes.ZERO_DIVISION);
				matrix[i][j] /= sum;
				sum = 0;
			}
		}
	}
}
