package assignment_3;

public class FindMaxMin {
	 public static void main(String[] args) {
	        int[] numbers = {45, 23, 89, 12, 67, 34, 78};
	        int max = numbers[0];
	        int min = numbers[0];
	        
	        for (int i = 1; i < numbers.length; i++) {
	            if (numbers[i] > max) {
	                max = numbers[i];
	            }
	            if (numbers[i] < min) {
	                min = numbers[i];
	            }
	        }
	        
	        System.out.print("Array: ");
	        for (int num : numbers) {
	            System.out.print(num + " ");
	        }
	        System.out.println("\nMaximum element: " + max);
	        System.out.println("Minimum element: " + min);
	    }

}
