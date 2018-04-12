import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		
		// Problem 1
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("How many digits of pi would you like: ");
		String N = keyboard.nextLine();
		int n = Integer.parseInt(N);
		System.out.println("pi to " + n + " digits is " + pi(n));
		/* First input  n =2, output pi = 3.14
		 * Second input n =5, output pi = 3.14159
		 */
		
		//Problem 2
		Scanner keyboard2 = new Scanner(System.in); 
		System.out.println("Enter the year please: ");
		String Yr = keyboard2.nextLine();
		int yr = Integer.parseInt(Yr);
		System.out.println(easter(yr));
		/* First input  yr = 2001, output  "In 2001, Easter Sunday fell on April 15"
		 * Second input yr = 2005, output  "In 2005, Easter Sunday fell on March 27"
		 * Third input  yr = 2017, output  "In 2017, Easter Sunday fell on April 16"
		 */
		
		//Problem 3 
		Scanner keyboard3 = new Scanner(System.in); 
		System.out.println("Enter the velocity in mph please: ");
		String Velocity = keyboard2.nextLine();
		int velocity = Integer.parseInt(Velocity);
		System.out.println(escape(velocity));
		/* First input velocity = 7 mph, output "The astronaut will return to Halley’s Comet"
		 * Second input velocity = 2000 mph, output "The astronaut will not return to Halley’s Comet. In order for the astronaut to return, the comet would need to have a mass larger than 4.318234822428785E22 kg." 
		 */
		
		//Problem 4
		Scanner keyboard4 = new Scanner(System.in); 
		System.out.println("Enter r:");
		String R = keyboard4.nextLine();
		int r = Integer.parseInt(R);
		
		Scanner keyboard5 = new Scanner(System.in); 
		System.out.println("Enter a: ");
		String A = keyboard2.nextLine();
		int a = Integer.parseInt(A);
		
		Scanner keyboard6 = new Scanner(System.in); 
		System.out.println("Enter b: ");
		String B = keyboard6.nextLine();
		int b = Integer.parseInt(B);
		
		Scanner keyboard7 = new Scanner(System.in); 
		System.out.println("Enter m: ");
		String M = keyboard6.nextLine();
		int m = Integer.parseInt(M);
		
		int[] arrL = random(r,a,b,m);
		System.out.println("The array from random method is " +Arrays.toString(arrL));
		/*First input r = 483920342, a = 394, b = 4952, m = 382
		 * Output: "The array from random method is [483920342, 64, 372, 248, 288, 4, 34, 12, 130, 18, 202, 118, 256, 2, 10, 106, 112, 184, 284, 338, 222, 358, 80, 182, 260]"
		 * Second input r = 3224453, a = 90, b = 322, m = 569
		 * Output: "The array from random method is [3224453, 281, 7, 383, 83, 395, 25, 296, 219, 117, 41, 29, 87, 186, 561, 171, 349, 437, 391, 234, 329, 344, 556, 290, 248]"
		 */
		
		//END Main

	}
	
	public static double pi(int n){ // code for pi method 
		int i; //using for loop to calculate pi from given formula
		double pi = 0.0; 
		for(i = 0; i < 1000000; i ++){ //not sure on this section
			if( i % 2 == 0){
				double fraction = (double) 1/(2*i+1);
				pi += 4*fraction;
			}
			else{
				double fraction = (double) -1/(2*i+1);
				pi += 4*fraction;
			}
		}
		
		String convert_pi = Double.toString(pi);	// Convert to string to cut the substring 
		String result = convert_pi.substring(0, n+2); // Define the range of substring ; n+2 because there are total n+1 letter (3 + . + numbers after the decimal point)
		Double result2 = Double.parseDouble(result); // Convert back to double 
		return result2;
	}
	
	public static String easter(int y){
		int a = y % 19; // follow the instructions
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8*b + 13) / 25;
		int h = (19*a + b - d -g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11*h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;
		
		// Create a string array to change the number of month to be its name
		String[] month = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		// Create a return statement ( n-1 because "January" index is 0.)
		String result = "In " + y + ", Easter Sunday fell on " + month[n-1] + " " + p; 
		
		return result;
		
		
	}
	
	
	public static String escape(double v){
		//1 mph = 0.44704 m/s;
		double convertV = v*0.44704; //convert mph to m/s
		double vEscape = Math.sqrt((2*6.67e-11*1.3e22)/(1.153e6)); //calculate v escape on Halley's comet 
		if( vEscape < convertV){ // in case that the astronaut won't return back
			double newMass = Math.pow(convertV, 2)*(1.153e6)/(2*6.67e-11); //Find the lower bound of mass of Halley's comet that could support v
			String result = "The astronaut will not return to Halley’s Comet. In order for the astronaut to return, the comet would need to have a mass larger than " + newMass + " kg.";
			return result;
		}
		else{
			String result = "The astronaut will return to Halley’s Comet";
			return result;
		}
	}
	
	public static int[] random(int r, int a, int b, int m){
		int i; 
		int[] arr = new int[25]; // create array having size = 25
		arr[0] = r; // define the first element as r
		for(i = 1; i < 25; i++){ // create new random number (new r) from previous number in the array
			arr[i] = (arr[i-1]*a + b) % m;
		}
		return arr;
	}

}
