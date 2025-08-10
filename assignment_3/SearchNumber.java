package assignment_3;
import java.util.Scanner;
public class SearchNumber {
	 public static void main(String[] args) {
	        int[] numbers = {10, 25, 30, 45, 50, 65, 70};
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Array: ");
	        for (int num : numbers) {
	            System.out.print(num + " ");
	        }
	        
	        System.out.print("\nEnter number to search: ");
	        int searchNum = scanner.nextInt();
	        
	        boolean found = false;
	        int position = -1;
	        
	        for (int i = 0; i < numbers.length; i++) {
	            if (numbers[i] == searchNum) {
	                found = true;
	                position = i;
	                break;
	            }
	        }
	        
	        if (found) {
	            System.out.println("Number " + searchNum + " found at position " + position);
	        } else {
	            System.out.println("Number " + searchNum + " not found in the array");
	        }
	        
	     
	    }

}
