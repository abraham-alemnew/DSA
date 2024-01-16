package dsa;
import java.util.Collection;
import java.util.ArrayList;

public class second_largest {

	public static void main(String[] args) {
		int[] test1 = { 5, 2, 8, 1, 9, 3 };

		int[] test2 = { 4, 4, 4, 4, 4, 4 };

		int[] test3 = { 10, 5, 10, 20, 20, 15 };
		System.out.println(find_second_largest(test1));
		System.out.println(find_second_largest(test2));
		System.out.println(find_second_largest(test3));
	}

	public static String find_second_largest(int[] n) {
		
		int max=n[0];
		// secondLargest will always be at least -1 if array is not empty and there are no
		// negative values
		// - no negatives -- create repo 
		
		double secondLargest = 0.5;
		
		//This loop will promote the max is there is a new max and then create the second largest variable 
		for (int i = 1; i < n.length; i++) {
			if (max < n[i]) {
				
				max = n[i];
			}
		}
		for (int i = 0; i < n.length; i++) {
			if (n[i] < max && n[i]>secondLargest) {
				
				secondLargest = n[i];
			}
		}
		//The three cases is an empty array, all the same numbers, and a second largest value available 
		if (secondLargest == 0.5)
			return "No second largest number";
		
		else
			return "" + (int)secondLargest;

	}

}
