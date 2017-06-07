package buzi;
import java.util.ArrayList;
import java.util.Arrays;


public class exe {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		arr.add(1);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(2);
		arr1.add(3);
		arr1.add(5);
		arr1.add(8);
		arr1.add(13);
		arr1.add(21);
		ArrayCheck ac = new ArrayCheck();
		boolean b1 = ac.allDivisibleBy(arr1, 0);
		boolean b2;
		//System.out.println("b1="+ b1 +",b2="+b2);
		
		b1 = ac.isFibonacci(arr);
	    b2 = ac.isFibonacci(arr1);
		System.out.println("b1="+ b1 +",b2="+b2);
		
		ArrayList<Integer> arr7 = new ArrayList<Integer>(Arrays.asList(1,1,2,3));
		b1 = ac.isFibonacci(arr7);
		ArrayList<Integer> arr8 = new ArrayList<Integer>(Arrays.asList(2,3,5,8,13,21));
		b2 = ac.isFibonacci(arr8);
		System.out.println("b1="+ b1 +",b2="+b2);
		
		arr7 = new ArrayList<Integer>(Arrays.asList(2,4,6,10));
		b1 = ac.isFibonacci(arr7);
		arr8 = new ArrayList<Integer>(Arrays.asList(2,3,5,8,13,21));
		b2 = ac.isFibonacci(arr8);
		System.out.println("b1="+ b1 +",b2="+b2);
	}

}
