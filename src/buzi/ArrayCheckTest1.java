package buzi;
    import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ArrayCheckTest1 {
  // NOTTODO DIESE ZEILE BITTE NICHT VERAENDERN!!
	// TODO Fuehrt eure Tests auf diesem ArrayCheck-Objekt aus!
	// Ansonsten kann eure Abgabe moeglicherweise nicht
	// gewertet werden.
	public ArrayCheck ArrayCheck = new ArrayCheck();
	ArrayList<Integer> arr1 = null;
	ArrayList<Integer> arr2 = null;
	ArrayList<Integer> arr3 = null;
	ArrayList<Integer> arr4 = null;
	ArrayList<Integer> arr5 = null;
	ArrayList<Integer> arr6 = null;
	ArrayList<Integer> arr7 = null;
	ArrayList<Integer> arr8 = null;
	ArrayList<Integer> arr9 = null;
	ArrayList<Integer> arr10 = null;
	ArrayList<Integer> arr11 = null;
	ArrayList<Integer> arr12 = null;
	ArrayList<Integer> arr13 = null;
	ArrayList<Integer> arr14 = null;
	ArrayList<Integer> arr15 = null;
	ArrayList<Integer> arr16 = null;
	ArrayList<Integer> arr17 = null;
	ArrayList<Integer> arr18 = null;
	

	ArrayCheck check = null;
	
	@Before
	public void setUp() {
		check = new ArrayCheck();
		
		arr1 = new ArrayList<Integer>(Arrays.asList(2,5,6,8,10));
		arr2 = new ArrayList<Integer>(Arrays.asList(12,26,60,120));
		arr3 = new ArrayList<Integer>(Arrays.asList(5,25,30,35));
		arr4 = new ArrayList<Integer>(Arrays.asList(20,40,60,80,100));
		arr5 = new ArrayList<Integer>(Arrays.asList(0,13,26,39,52,130));
		
		arr6 = new ArrayList<Integer>(Arrays.asList(0,1,1,2,3,5));
		arr7 = new ArrayList<Integer>(Arrays.asList(2,3,5,8,13,21));
		arr8 = new ArrayList<Integer>(Arrays.asList(2,3,5,8,13,22));
		arr9 = new ArrayList<Integer>(Arrays.asList(2,3));
		arr10 = new ArrayList<Integer>(Arrays.asList(0));
		arr11 = new ArrayList<Integer>(Arrays.asList(2,4,6,10,16,26)); // ACHTUG! Keine Fibonacci
		arr12 = new ArrayList<Integer>(Arrays.asList(1,2));
		arr13 = new ArrayList<Integer>(Arrays.asList(2));
		arr14 = new ArrayList<Integer>(Arrays.asList(-2));
		arr15 = new ArrayList<Integer>(Arrays.asList(2,4,6,9));
		arr16 = new ArrayList<Integer>(Arrays.asList(3,4,12,9));
		arr17 = new ArrayList<Integer>(Arrays.asList(233,23,12,0,-2,3));
		
	}


	@Test(timeout = 1000)
	public void testAllDivisibleBy() {
		// TODO Schreibt verschiedene Testfaelle, die unterschiedliche Arrays
		// anlegen und an testAllDivisibleBy uebergeben.
		// Testet auch randfaelle wie z.B. leere arrays.		
		assertFalse(check.allDivisibleBy(arr1, 3));
		assertFalse(check.allDivisibleBy(arr1, 2));
//		assertTrue(check.allDivisibleBy(arr2, 2));
		assertTrue(check.allDivisibleBy(arr3, 5));
		assertFalse(check.allDivisibleBy(arr3, 6));
		assertTrue(check.allDivisibleBy(arr4, 5));
		assertTrue(check.allDivisibleBy(arr5, 13));
		assertTrue(check.allDivisibleBy(arr10, 13));
		assertFalse(check.allDivisibleBy(arr10, 0)); 
		assertFalse(check.allDivisibleBy(arr13, 3)); 
		assertTrue(check.allDivisibleBy(arr13, 2)); 
		assertFalse(check.allDivisibleBy(arr13, 0)); 
		assertTrue(check.allDivisibleBy(arr13, -2));
		assertFalse(check.allDivisibleBy(arr15, 2));
	}

	@Test(timeout = 1000)
	public void testIsFibonacci() {
		// TODO Schreibt verschiedene Testfaelle, fuer testIsFibonacci.

		assertTrue(check.isFibonacci(arr6));
		assertTrue(check.isFibonacci(arr7));
		assertFalse(check.isFibonacci(arr8));
		assertFalse(check.isFibonacci(arr9));
		assertFalse(check.isFibonacci(arr10)); 
		assertFalse(check.isFibonacci(arr11));
		assertFalse(check.isFibonacci(arr12));
		assertFalse(check.isFibonacci(arr14));
		assertFalse(check.isFibonacci(arr16));
		assertFalse(check.isFibonacci(arr17));
		
	}
}
