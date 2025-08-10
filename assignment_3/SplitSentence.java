package assignment_3;

public class SplitSentence {
	 public static void main(String[] args) {
	        String sentence = "Learning Java programming is fun";
	        String[] words = sentence.split(" ");
	        
	        System.out.println("Original sentence: " + sentence);
	        System.out.println("Words in the sentence:");
	        
	        for (int i = 0; i < words.length; i++) {
	            System.out.println((i + 1) + ". " + words[i]);
	        }
	    }

}
