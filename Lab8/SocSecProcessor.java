
import java.util.Scanner;

public class SocSecProcessor {
	
	public static boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e)
	   {
	      return false;
	   }
	}
	public static boolean isValid(String ssn) throws SocSecException{
		if(ssn.length() != 11){
			throw new SocSecException("Invalid the social security number, wrong number of characters");
		}
		
		String[] splited = ssn.split("-");
		
		if(splited[0].length() != 3 | splited[1].length() != 2| splited[2].length() != 4){
			throw new SocSecException("Invalid the social security number, dashes at wrong positions");
		}
		
		int i;
		for(i =0; i < splited.length; i++){
			if(!isInteger(splited[i])){
				throw new SocSecException("Invalid the social security number, contains a character that is not a digit");
			}
			
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String continueInput = "Y";
		while(!continueInput.equals("N")){
			System.out.println("Name?");
			String name = in.nextLine();
			System.out.println("SSN?");
			String ssn = in.nextLine();
			try{
				isValid(ssn);
				
				System.out.println(name + " " + ssn + " is valid.");
			}
			catch (SocSecException exception) {
				System.out.println(exception.getMessage());
			}
			catch (RuntimeException e){
				System.out.println("e");
			}
			System.out.println("Continue?");
			continueInput = in.nextLine();
			
		}
		
	}

}
