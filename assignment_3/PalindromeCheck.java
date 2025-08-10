package assignment_3;

public class PalindromeCheck {
	 public static void main(String[] args) {
	        String str = "madam";
	        String reversed = "";
	        
	        for (int i = str.length() - 1; i >= 0; i--) {
	            reversed += str.charAt(i);
	        }
	        
	        System.out.println("Original string: " + str);
	        System.out.println("Reversed string: " + reversed);
	        
	        if (str.equals(reversed)) {
	            System.out.println("The string is a palindrome.");
	        } else {
	            System.out.println("The string is not a palindrome.");
	        }
	    }

}
