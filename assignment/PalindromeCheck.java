package assignment;

public class PalindromeCheck {
	 public static void main(String[] args) {
	        int num = 121;
	        int originalNum = num;
	        int reverseNum = 0;
	        
	        while(num > 0) {
	            int digit = num % 10;
	            reverseNum = reverseNum * 10 + digit;
	            num = num / 10;
	        }
	        
	        if(originalNum == reverseNum) {
	            System.out.println(originalNum + " is palindrome");
	        } else {
	            System.out.println(originalNum + " is not palindrome");
	        }
	    }

}
