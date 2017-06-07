package javatest;

import Jama.*;

public class MatrixTest {

	public static void main(String[] args) {
		// Solve A*X = B
		double a[][] = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		double a2[][] = {{1,1,1,1},
			     {3,2,1,1},
			     {0,1,2,2}};
		
		double a1[][] = {{1,1,-1,2,-1},
			     {1,1,1,0,3},
			     {0,0,1,3,6}};
		
		double b1[][]  = {{0},{0},{0},{0}};
		
		double b[][]  = {{0},{0},{0}};
		
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		
		A.print(4, 1);
		B.print(4, 1);
		
		Matrix X = A.solve(B);  // Matrix is rank deficient
		
		X.print(4, 1);

	}

}
