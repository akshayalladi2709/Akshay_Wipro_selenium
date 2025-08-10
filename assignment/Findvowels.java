package assignment;

public class Findvowels {
	public static void main(String []args) {
		String str="Programming";
		int count=0;
		str=str.toLowerCase();
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				count++;
			}
		}
		System.out.println(count);
		
		int j=0;
		int k=str.length()-1;
		while(j<k) {
			
		}
}
}
