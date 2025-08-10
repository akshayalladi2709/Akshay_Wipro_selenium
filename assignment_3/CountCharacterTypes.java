package assignment_3;

public class CountCharacterTypes {
	 public static void main(String[] args) {
	        String str = "Hello123 World! @#$";
	        int letters = 0, digits = 0, spaces = 0, special = 0;
	        
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            
	            if (Character.isLetter(ch)) {
	                letters++;
	            } else if (Character.isDigit(ch)) {
	                digits++;
	            } else if (ch == ' ') {
	                spaces++;
	            } else {
	                special++;
	            }
	        }
	        
	        System.out.println("String: " + str);
	        System.out.println("Letters: " + letters);
	        System.out.println("Digits: " + digits);
	        System.out.println("Spaces: " + spaces);
	        System.out.println("Special characters: " + special);
	    }

}
