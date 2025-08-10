package assignment_3;

public class SimpleInterest {
	public static void main(String[] args) {
        double principal = 5000;
        double rate = 7.5;
        double time = 3;
        
        double simpleInterest = (principal * rate * time) / 100;
        
        System.out.println("Principal amount: $" + principal);
        System.out.println("Rate of interest: " + rate + "%");
        System.out.println("Time period: " + time + " years");
        System.out.println("Simple Interest: $" + simpleInterest);
    }

}
