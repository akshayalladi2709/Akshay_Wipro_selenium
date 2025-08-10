package assignment_3;

public class CheckStartEnd {
	  public static void main(String[] args) {
	        String word = "java";
	        
	        boolean startsWithJ = word.toLowerCase().startsWith("j");
	        boolean endsWithA = word.toLowerCase().endsWith("a");
	        
	        System.out.println("Word: " + word);
	        System.out.println("Starts with 'j': " + startsWithJ);
	        System.out.println("Ends with 'a': " + endsWithA);
	        
	        if (startsWithJ && endsWithA) {
	            System.out.println("The word starts with 'j' and ends with 'a'");
	        } else {
	            System.out.println("The word does not meet the criteria");
	        }
	    }

}
