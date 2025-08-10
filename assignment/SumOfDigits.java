package assignment;

public class SumOfDigits {
	 public static void main(String[] args) {
	        int num = 6785;
	        int sum = 0;
	        int temp = num;
	        
	        while(temp > 0) {
	            int digit = temp % 10;
	            sum = sum + digit;
	            temp = temp / 10;
	        }
	        
	        System.out.println("Sum of digits of " + num + " is: " + sum);
	    }

}
