//Pat Wongwiset (nw9ca); hw4
public class Song implements Playable {
	/**fields
	 * 
	 */
	private String artist; /** the artist performing the song */
	private String title; /** the title of the song */
	private int minutes; /** number of min in length */
	private int seconds; /**number of seconds of length of the song (always less than 60) */

	/**constructor
	 */
	public Song(String artist, String title){
		this.artist = artist;
		this.title = title;
	}
	public Song(String artist, String title, int minutes, int seconds){
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public Song(Song s){
		this.artist = s.artist;
		this.title = s.title;
		this.minutes = s.minutes;
		this.seconds  = s.seconds;
	}

	/**getters & setters
	 */
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**equals() 
	 * Override the equals() method by comparing whether two objects is same artist, title, length.
	 */
	public boolean equals(Object o){ /** a song is equal if all four fields are equal */
		if( o instanceof Song){
			Song s = (Song) o;
			return this.artist.equals(s.artist) && this.title.equals(s.title) && this.minutes == s.minutes && this.seconds == s.seconds;
		}

		return false;
	}

	/**toString()
	 * Print the Song into String
	 */
	public String toString() { 
		return "{Song: title = " + title + " artist = " + artist + "}";
	}

	/**play()
	 * Show and play the song
	 */
	public void play() { // Use this code for play EXACTLY
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);
	}

	/**
	 * compareTo()
	 * Compare two song 
	 *  -1:Song1 < Song2 
	 *  0:Song1 == Song2
	 *  1: Song1 > Song2
	 */
	public int compareTo(Song o) {
		if(this.getArtist().compareTo(o.getArtist()) == 0){
			if(this.getTitle().compareTo(o.getTitle()) == 0){
				return 0;
			}
			else if(this.getTitle().compareTo(o.getTitle()) < 0){
				return -1;
			}
			return 1;
		}
		if(this.getArtist().compareTo(o.getArtist()) < 0){
			return -1;
		}
		else if(this.getArtist().compareTo(o.getArtist()) > 0){
			return 1;
		}
		return 0;
	}

	/**getName
	 * 
	 */
	public String getName(){
		return this.title;
	}

	/**getPlayTimeSeconds
	 * 
	 */
	public int getPlayTimeSeconds(){
		return this.minutes*60 + this.seconds;
	}

	/**numberOfSongs
	 * 
	 */
	public int numberOfSongs(){
		return 1;
	}


	//	public static void main(String[] args) {
	//		Song s1 = new Song("Ed", "Shape of You", 3, 24);
	//		System.out.println(s1.toString());
	//		s1.play();
	//	}

}
