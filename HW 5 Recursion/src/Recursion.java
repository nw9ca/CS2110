import java.awt.Color;

// Pat Wongwiset (nw9ca); HW 5
public class Recursion {
	
	/** Problem 1
	 * reverseString() - return string in reverse order
	 * base case: At str.length = 0
	 * Returning the character from the end (converting to String autonomatically by "")
	 * @param str
	 * @return String
	 */
	public static String reverseString(String str){
		if(str.length() == 0){
			return str;
		}
		String newString = str.substring(0, str.length() - 1);
		
		return "" +str.charAt(str.length() - 1) + reverseString(newString);
	}
	
	/**Problem 2
	 * countWays() - return the number of climbing stairs' ways
	 * base case: numStairs = 1, 2, and 3 (return 1, 2, and 3 respectively)
	 * Returning the total number 
	 * I found the relation that CountWays(numStairs) = countWays(numStairs -1) + countWays(numStairs - 2)
	 * @param int: numStairs
	 * @return Integer
	 */
	
	public static int countWays(int numStairs){
		if(numStairs == 1){
			return 1;
		}
		if(numStairs == 2){
			return 2;
		}
		if(numStairs == 3){
			return 3;
		}
		return countWays(numStairs -1) + countWays(numStairs - 2);
	}
	
	/** Problem 3: STACK OVERFLOW PROBLEM
	 * Test recursion in program
	 * @param int m, int n
	 * @return int
	 */
	
	public static int Ackermann(int m, int n){
		if(m == 0){
			return n+1;
		}
		else if(m > 0 && n == 0){
			return Ackermann(m-1, 1);
		}
		return Ackermann(m-1, Ackermann(m, n-1));
		
	}
	/**Problem 4: Koch Snowflake 
	 * 
	 * @param t
	 * @param level
	 * @param size
	 */
	
	public static void drawSnowflake(Turtle t,int level, double size){
		if( level == 0){
			t.putPenDown();
			t.forward(size);
			t.pickPenUp();
		}
		else{ //rotate 3 times in order to create triangle (the koch) 
			//p.s. the shape of the koch is differentiated by this recursive process below
			drawSnowflake(t, level - 1, size/3);
			t.right(60);
			drawSnowflake(t, level-1, size/3);
			t.right(-120);
			drawSnowflake(t, level-1, size/3);
			t.right(60);
			drawSnowflake(t, level-1, size/3);
		}
	}
	public static void snowflake(int level, double size){
		World myWorld = new World(900,900,Color.WHITE);
		Turtle snow = new Turtle(myWorld);
		snow.setDelay(0);
		snow.pickPenUp();
		snow.goTo(-200, 50); //set location
		snow.putPenDown();
		drawSnowflake(snow, level, size);
		snow.right(-120);
		drawSnowflake(snow, level, size);
		snow.right(-120);
		drawSnowflake(snow, level, size);
		return;

		}
		
	
	public static void main(String[] args) {
		//Test1
		System.out.println(reverseString("abc")); // print: cba
		System.out.println(reverseString("Maprang123")); // print: 321gnarpaM
		
		//Test2
		System.out.println(countWays(10)); // print: 89
		System.out.println(countWays(1)); // print: 1
		System.out.println(countWays(2)); // print: 2
		System.out.println(countWays(3)); // print: 3
		System.out.println(countWays(15));// print: 987
		System.out.println(countWays(23));// print: 46368
		
		//Test 3
		System.out.println(Ackermann(0,0)); // print: 1
		System.out.println(Ackermann(0,1)); // print: 2
		System.out.println(Ackermann(2,0)); // print: 3
		System.out.println(Ackermann(3,3)); // print: 61
		System.out.println(Ackermann(3,4)); // print: 125
		
		
		//Test 4
		snowflake(5, 200);
	}

}
