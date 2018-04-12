import java.awt.Color;

public class TryTurtle {
	public static void drawSnowflake(Turtle t,int level, double size){
		if( level == 0){
			t.forward(size);
		}
		else{ //rotate 3 times in order to create triangle (the koch) 
			//p.s. the shape of the koch is differentiated by this recursive process below
			drawSnowflake(t, level - 1, size);
			t.right(60);
			drawSnowflake(t, level-1, size);
			t.right(-120);
			drawSnowflake(t, level-1, size);
			t.right(60);
			drawSnowflake(t, level-1, size);
		}
	}
	public static void snowflake(int level, double size){
		World myWorld = new World(900,900,Color.WHITE);
		Turtle snow = new Turtle(myWorld);
		snow.setDelay(0);
		snow.pickPenUp();
		snow.goTo(0, 900*Math.sqrt(3)/2); //set location
		snow.putPenDown();
		drawSnowflake(snow, level, size);
		snow.right(-120);
		drawSnowflake(snow, level, size);
		snow.right(-120);
		drawSnowflake(snow, level, size);
		return;

		}
		
	
	public static void main(String[] args) {
//		World myWorld = new World(900,900,Color.WHITE);
//		Turtle snow = new Turtle(myWorld);
//		snow.setDelay(0);
		Turtle snow;
		snowflake(3,100);
		
		//bob.pickPenUp();
//		bob.goTo(300, 400);
//		bob.putPenDown();
//		bob.goTo(400,500);
//		bob.pickPenUp();
//		bob.goTo(0,0);
//		bob.putPenDown();
//		bob.goTo(200,300);
		
//		Turtle bee = new Turtle(myWorld);
//		bee.setDelay(0);
//		bee.pickPenUp();
//		bee.goTo(0,100);
//		bee.putPenDown();
//		bee.goTo(0,200);
		
		//koch snowflake
	}
	

}
