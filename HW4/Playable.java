//Pat Wongwiset (nw9ca); hw4
public interface Playable {

	public void play();
	/**
	 * Return the string expessing the current playing song (from both PlayList and Song)
	 */
	public String getName(); 
	/**
	 * Return the name (title in Song and name of the playlist in PlayList)
	 */
	public int getPlayTimeSeconds();
	/**
	 * Return the total length of Song and PlayList
	 */
	public int numberOfSongs(); 
	/**
	 * Return the number of songs in playlists (1 in Song Class)
	 */

}
