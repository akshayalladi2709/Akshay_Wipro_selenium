package assignment_3;

public class CountVowels {
	 public static void main(String[] args) {
	        String input = "Programming";
	        int vowelCount = 0;
	        String vowels = "aeiouAEIOU";
	        
	        for (int i = 0; i < input.length(); i++) {
	            char ch = input.charAt(i);
	            if (vowels.indexOf(ch) != -1) {
	                vowelCount++;
	            }
	        }
	        
	        System.out.println("Input: " + input);
	        System.out.println("Number of vowels: " + vowelCount);
	    }

}
