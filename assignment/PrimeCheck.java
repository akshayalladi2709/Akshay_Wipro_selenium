package assignment;
import java.util.*;
public class PrimeCheck {
	 public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        System.out.print("enter number to check");
	        int num=sc.nextInt();
	        boolean isPrime = true;
	        
	        if(num <= 1) {
	            isPrime = false;
	        } else {
	            for(int i = 2; i < num; i++) {
	                if(num % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }
	        
	        if(isPrime) {
	            System.out.println(num + " is prime");
	        } else {
	            System.out.println(num + " is not prime");
	        }
	    }

}
