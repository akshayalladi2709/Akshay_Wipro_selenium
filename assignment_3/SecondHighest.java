package assignment_3;

public class SecondHighest {
	public static void main(String[] args) {
        int[] numbers = {45, 23, 89, 12, 67, 34, 78};
        int highest = numbers[0];
        int secondHighest = numbers[0];
        
        for (int num : numbers) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num < highest) {
                secondHighest = num;
            }
        }
        
        System.out.print("Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nHighest element: " + highest);
        System.out.println("Second highest element: " + secondHighest);
    }

}
