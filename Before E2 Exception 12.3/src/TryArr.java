import java.util.InputMismatchException;
import java.util.Scanner;

public class TryArr {
	public static boolean isValid(int k,int[] arr) throws ArrayE{

		int i = arr.length;
		if(k > i || k < 0){
			throw new ArrayE("Out Bound");
		}

		return true;
	}
	public static void main(String[] args) {
		try {
			int[] arr = new int[3];
			arr[0] = 1;
			arr[1] = 2;
			arr[2] = 3;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter the integer");
			int i = keyboard.nextInt();

			isValid(i, arr);
			System.out.println("The integer is " + arr[i]);
		}
		catch(ArrayE e){
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException k){
			System.out.println("Mismatch type");
		}
		catch(Exception e){};
	}


	// TODO Auto-generated method stub

}


