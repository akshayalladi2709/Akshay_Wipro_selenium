package assignment_3;

public class CharacterFrequency {
	 public static void main(String[] args) {
	        String str = "programming";
	        
	        System.out.println("String: " + str);
	        System.out.println("Character frequencies:");
	        
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            int count = 0;
	            
	            for (int j = 0; j < str.length(); j++) {
	                if (str.charAt(j) == ch) {
	                    count++;
	                }
	            }
	            
	            boolean alreadyPrinted = false;
	            for (int k = 0; k < i; k++) {
	                if (str.charAt(k) == ch) {
	                    alreadyPrinted = true;
	                    break;
	                }
	            }
	            
	            if (!alreadyPrinted) {
	                System.out.println(ch + ": " + count);
	            }
	        }
	    }

}
