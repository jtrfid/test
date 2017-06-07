package buzi;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ArrayCheckTest {
	// NOTTODO DIESE ZEILE BITTE NICHT VERAENDERN!!
	// TODO Fuehrt eure Tests auf diesem ArrayCheck-Objekt aus!
	// Ansonsten kann eure Abgabe moeglicherweise nicht
	// gewertet werden.
	ArrayList<Integer> arr1 = null;
	ArrayList<Integer> arr2 = null;
	ArrayList<Integer> arr3 = null;
	ArrayList<Integer> arr4 = null;
	ArrayCheck check = null;
	@Before
	public void setUp() {
		check = new ArrayCheck();
		arr1 = new ArrayList<Integer>(Arrays.asList(0,1,1,2,3,5));
		arr2 = new ArrayList<Integer>(Arrays.asList(2,3,5,8,13,21));
		arr3 = new ArrayList<Integer>(Arrays.asList(2,3,5,8,13,22));
		arr4 = new ArrayList<Integer>(Arrays.asList(2,3));
	}
  
	@Test(timeout = 1000)
	public void testAllDivisibleBy() {
		// TODO Schreibt verschiedene Testfaelle, die unterschiedliche Arrays
		// anlegen und an testAllDivisibleBy uebergeben.
		// Testet auch randfaelle wie z.B. leere arrays.
		assertEquals(check.allDivisibleBy(arr1, 4),true);
		assertEquals(check.allDivisibleBy(arr2, 3),true);
		assertEquals(check.allDivisibleBy(arr2, 22),false);
		assertEquals(check.allDivisibleBy(arr2, 0),false);
		assertEquals(check.allDivisibleBy(null, 6),false);
	}

	@Test(timeout = 1000)
	public void testIsFibonacci() {
		// TODO Schreibt verschiedene Testfaelle, fuer testIsFibonacci.
		assertEquals(check.isFibonacci(arr1),true);
		assertEquals(check.isFibonacci(arr2),true);
		assertEquals(check.isFibonacci(arr3),false);
		assertEquals(check.isFibonacci(arr4),false);
		assertEquals(check.isFibonacci(null),false);
	}


}

