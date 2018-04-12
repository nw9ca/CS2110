import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class frequency_analyzer {

	public static void main(String[] args) {
		/* Activity 3: if,loops, array*/
		// Activity 1: Frequency Analyzer Java Program
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String filename = keyboard.nextLine();
		File file = new File(filename);
		
		try {
			Scanner inputFile = new Scanner(file); // input the file
			String str ="";
			while (inputFile.hasNext()){ //read and collect all character in str
				str += inputFile.nextLine();
			}
			str = str.toLowerCase(); //convert to lower case
			String arrCharacter[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r" , "s", "t", "u", "v", "w", "x", "y","z"}; //create 2 arrays to analyze data
			int arrCount[] = new int[26]; // to count the frequency in each letter (all starts at 0)
			int i;
			for( i=0; i <26; i++){
				arrCount[i] = 0; 
			}
			
			int b;
			int a;
			for( b = 0; b < arrCharacter.length; b++ ){ //Check in each letter and count the frequency
				for (a = 0; a < str.length(); a++ ){
					if( arrCharacter[b].charAt(0) == str.charAt(a) ){
						arrCount[b] += 1;
					}

				}
				
			}
			
			
			int e;
			for( e = 0; e < arrCount.length; e ++){ //find relative frequency
				if(arrCount[e] != 0){
					System.out.println(arrCharacter[e] + " has frequency " + (double)(arrCount[e])/(double)(str.length()));
				}
			}
			
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("File could not be found");
			System.exit(1);
		}
		
		
		
	}

}
