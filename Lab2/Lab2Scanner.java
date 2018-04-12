//nw9ca Lab2 (1/30/2017)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2Scanner {

	public static void main(String[] args) {
		
		/* Activity 2.1: System.in */
		double[] arr = new double[5]; 
		int a ;
		double sum = 0.0;
		for(a = 0; a < arr.length; a++ ){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter a number: ");
			arr[a] = keyboard.nextDouble();
			sum += arr[a];
		}
		double ave = sum/arr.length; //average
		System.out.println("The average of "+ arr[0] + " , " + arr[1] + " , " + arr[2] + " , " + arr[3] + " and " + arr[4] + " is " + ave + "." );
	
	//When typing 'Hello' (string type), the program showed "InputMismatchException" due to the type of the input.	
	
		/* Activity 2.2: Files */
		File myFile = new File("data1.txt");
		try {
			Scanner scanFile  = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}
		System.out.println("The number of bytes in this file is " + myFile.length() + " byte."); /*The number of bytes in this file*/
		System.out.println("Full name of this file is " + myFile.getAbsolutePath()); /*The Full name = Absolute Path */
	
	
	}
	
	
	
		
}

