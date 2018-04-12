import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads a file containing numbers and analyzes its contents. If
 * the file doesn&apos;t exist or contains strings that are not numbers, an
 * error message is displayed.
 */
public class DataAnalyzer {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DataSetReader reader = new DataSetReader();
		boolean done = false;
		while (!done) {
			try {
				System.out.println("Please enter the file name: ");
				String filename = in.next();

				double[] data = reader.readFile(filename);
				double sum = 0;
				for (double d : data) {
					sum = sum + d;
				}
				System.out.println("The sum is " + sum);
				done = true;
			} catch (FileNotFoundException exception) {
				System.out.println("File not found.");
			} catch (BadDataException exception) {
				System.out.println("Bad data: " + exception.getMessage());
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
/*Test1: pass
 * Test2: pass
 * Test3: "Length Expected": the first number is not int
 * Test4: "Data Value Expected": The indicated size is 5, but having only 4
 * Test5: "End of file expected": there exists a number when finishing data (adding number in array) 
 */

