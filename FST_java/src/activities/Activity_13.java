
package activities;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Activity_13 {
	public static void main(String[] args) {
		// Step 1: Create objects
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		Random indexGen = new Random();
		// Step 2: Take input (example: 5 numbers)
		System.out.println("Enter 5 numbers:");
		for (int i = 0; i < 5; i++) {
			int num = scan.nextInt();
			list.add(num);
		}
		// Step 3: Generate random index
		int randomIndex = indexGen.nextInt(list.size());
		// Step 4: Print value at random index
		System.out.println("Random index: " + randomIndex);
		System.out.println("Value at that index: " + list.get(randomIndex));
		scan.close();
	}
}