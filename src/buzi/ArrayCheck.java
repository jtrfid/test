package buzi;
import java.util.ArrayList;


/**
 * This class implements three methods. These test an array on a few
 * characteristics.
 *
 * @author AlgoDat-Tutoren
 *
 */
public class ArrayCheck {
	/**
	 * Tests all elements of the given array,
     * if they are divisible by the given divisor.
     *
     * @param arr
     *            array to be tested
     * @param divisor
     * 				number by which all elements of the given array should be divisible
     * @return true if all elements are divisible by divisor
     */
    public boolean allDivisibleBy(ArrayList<Integer> arr, int divisor) {
    	if(arr == null || divisor == 0) return false;
    	int i;
    	for(i = 0; i < arr.size(); i++)
    	{
    		if(arr.get(i)%divisor == 0) break;
    	}
    	if (i == arr.size()) return false;
        return true;
    }

    /**
     * Tests if the given array is a part of
     * the fibonacci sequence.
     *
     * @param arr
     *            array to be tested
     * @return true if the elements are part of
     *         the fibonacci sequence
     */
    public boolean isFibonacci(ArrayList<Integer> arr) {
       	// TODO
        // 0 1 1 2 3 5 8
     	// 2 4 6 10 16 26
        if(arr == null) return false;
        if(arr.size() < 3) return false;
        
        int f1,f2,fold1,fold2,i;
        f1 = 0; f2 = 1;   
        switch(arr.get(0)) {
          case 0:
        	    if(arr.get(1) != 1) return false;
        	    f1 = 0; f2 = 1; i = 2;
        	    break;
          case 1:
     	       f1 = 1; f2 = arr.get(1); i = 2;
     	       break;
     	  default:
     		 while(true) {
             	fold1 = f1; fold2 = f2;
             	f1 = f1 + f2;
             	if (f1 == arr.get(0)) break;
             	if (f1 > arr.get(0)) return false;
             	f2 = f2 + f1;
             	if (f2 == arr.get(0)) {
             		fold1 = fold2; fold2 = f1;
             		break;
             	}
             	if (f2 > arr.get(0)) return false;
             }
             f1 = fold1; f2 = fold2; i = 0;	   
        }
         
        for(; i < arr.size(); i++)
        {
        	if (arr.get(i) != f1+f2) return false;
        	f1 = f2;
        	f2 = arr.get(i);
        }
        return true;
    }
}

