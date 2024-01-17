//Abraham Alemnew 

package dsa;
import java.util.Collection;

public class second_largest {

	public static void main(String[] args) {
		int[] test1 = { 5, 2, 8, 1, 9, 3 };

		int[] test2 = { 4, 4, 4, 4, 4, 4 };

		int[] test3 = { 10, 5, 10, 20, 20, 15 };

		int[] test4 = { -10, -5, -10, -20, -20, -15 };

		System.out.println(find_second_largest(test1));
		System.out.println(find_second_largest(test2));
		System.out.println(find_second_largest(test3));
		System.out.println(find_second_largest(test4));
	}

	public static String find_second_largest(int[] n) {

		int max = Integer.MIN_VALUE;

		int secondLargest = Integer.MIN_VALUE;

		// This loop will promote the max until it reaches the end of array
		for (int i = 0; i < n.length; i++) {
			if (max < n[i]) {

				max = n[i];
			}
			if (n[i] < max && n[i] > secondLargest) {

				secondLargest = n[i];
			}
		}
		// Checking for a second largest number if available

		if (secondLargest == Integer.MIN_VALUE)
			return "No second largest number";

		else
			return "" + (int) secondLargest;

	}

}

