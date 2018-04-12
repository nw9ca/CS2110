//Pat Wongwiset (nw9ca); hw4
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//play() in PlayList?

public class PlayList implements Playable {
	/**fields
	 * 
	 */
	private String name; /** contains the name of the playlist */
	private ArrayList<Playable> playableList; /** ArrayList of Playable elements that make up the play list */


	/** Add Getters / Setters 
	 * 
	 */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}


	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}


	/** toString()
	 * Express PlayList as String
	 */
	public String toString(){
		String str = "PlayList " + this.name;
		for(Playable ele: playableList){
			str += "\n" + ele.toString();
		}
		return str;
	}

	/**constructors
	 * 
	 */
	public PlayList(){ /**empty play list named "Untitled" */
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}

	public PlayList(String newName){ /**empty play list */
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
	}

	/**loadSongs
	 * loads songs from file: assume n is the number on the line
	 * n%4 == 0 : song name
	 * n%4 == 1: artist
	 * n%4 == 2: length
	 * n%4 == 3: add song
	 * str.replaceAll("^\\s+|\\s+$", "") or str.trim() -> remove all excess white spaces
	 */
	public boolean loadSongs(String fileName){ 
		int oldLength = this.getPlayableList().size();
		File myFile = new File(fileName);
		try {
			Scanner inputFile = new Scanner(myFile); /**read file */
			int i = 0;
			String songName = "";
			String songArtist = "";
			String songLength = "";
			int songMin = 0;
			int songSeconds = 0;
			while(inputFile.hasNextLine()){ /**loading song in PlayList */
				if(i % 4 == 0){
					songName = inputFile.nextLine(); /** song name */
					songName = songName.replaceAll("^\\s+|\\s+$", ""); 
					i += 1;
				}
				else if(i % 4 == 1){
					songArtist = inputFile.nextLine(); /** artist */
					songArtist = songArtist.trim();
					i += 1;
				}
				else if(i % 4 == 2){ /** length (min + sec): split by ":" to get min and sec*/
					songLength = inputFile.nextLine();
					String[] splited = songLength.split(":");
					int j = 0;
					for(String ele: splited){
						String strNum = ele.trim();
						int n = Integer.parseInt(strNum);
						if(j == 0){
							songMin = n;
							j += 1;
						}
						else{ /**in case that seconds > 60, we have to add it in min*/
							if(n/60 > 0){
								songMin += n/60;
								songSeconds = n%60;
							}
							songSeconds = n%60;
						}
					}
					i += 1;

				}
				else if(i % 4 == 3){  /**add song (blank line) */
					inputFile.nextLine();

					Song s = new Song( songArtist, songName, songMin, songSeconds);
					this.addSong(s);
					i += 1;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		if(oldLength <= this.getPlayableList().size()){
			return true;
		}
		else{
			return false;
		}

	}

	/**clear
	 * removes all playable elements in the play list
	 */
	public boolean clear(){ 
		if(playableList.size() == 0){
			return false;
		}
		this.playableList.clear();
		return true;
	}

	/**addSong
	 * adds Song s to the end of the play list
	 */
	public boolean addSong(Song s){ 
		this.playableList.add(s);
		return true;
	}


	/**removePlayable()
	 * removes Playable element at index from the list and returns it
	 * OR removes every occurrence of Playable p from the list and returns p
	 */
	public Playable removePlayable(int index){
		if(index >= 0 && index < this.playableList.size()){
			Playable p = this.getPlayableList().get(index);
			this.playableList.remove(index);
			return p;
		}
		return null;
	}

	public Playable removePlayable(Playable p){ 
		if(!this.playableList.contains(p)){
			return null;
		}
		while(this.playableList.contains(p)){
			this.playableList.remove(p);
		}
		return p;
	}

	/**getPlayable
	 * returns the Playable element at the appropriate index
	 */
	public Playable getPlayable(int index){ 
		if(index >= 0 && index < this.playableList.size()){
			Playable p = this.playableList.get(index);
			return p;
		}
		return null;
	}

	/**addPlayList 
	 * add PlayList in PlayList
	 */
	public boolean addPlayList(PlayList pl){
		if(this.playableList.contains(pl)){
			return false;
		}
		this.playableList.add(pl);
		return true;
	}

	/**play
	 * Play the playList
	 */
	public void play(){
		for(Playable ele: this.playableList){
			ele.play();
		}
	}

	/**sortByName
	 * Ascending order: title -> artist
	 */
	public ArrayList<Playable> sortByName(){
		Collections.sort(playableList, new NameComaparator() );
		return this.playableList;
	}

	/**sortByTime
	 * Ascending order: min -> max
	 */
	public ArrayList<Playable> sortByTime(){
		Collections.sort(playableList, new TimeComaparator() );
		return this.playableList;
	}

	/**getNumberOfSongs
	 * Get number of Songs in this PlayList
	 */
	public int numberOfSongs(){
		int i = 0;
		for(Playable ele : this.playableList){
			if(ele instanceof Song){
				i += 1;
			}
			if(ele instanceof PlayList){ 
				PlayList pl = (PlayList) ele;
				i += pl.getPlayableList().size();
			}
		}
		return i;
	}

	/**getPlayTimeSeconds()
	 * Get total seconds in this PlayList
	 * 
	 */
	public int getPlayTimeSeconds(){
		int i = 0;
		for(Playable ele: this.playableList){
			if(ele instanceof Song){
				Song s = (Song) ele;
				i += s.getPlayTimeSeconds();
			}
			else{
				PlayList pl = (PlayList) ele;
				for(Playable s: pl.getPlayableList()){
					Song a = (Song) s;
					i += a.getPlayTimeSeconds();
				}
			}
		}
		return i;
	}



			public static void main(String[] args) {
				Song s1 = new Song("Ed","Shape of You", 3, 24);
				Song s2 = new Song("Ed","Shape of You", 3, 24);
				Song s3 = new Song("Ed","Perfect", 3, 24);
				PlayList pl1 = new PlayList("Fav");
				pl1.addSong(s1);
				pl1.addSong(s2);
				pl1.sortByName();
		//		System.out.println(pl1.toString());
		//		System.out.println(pl1.getPlayTimeSeconds());
				
		//		PlayList pl2 = new PlayList("Fav2");
		//		pl2.addSong(s2);
		//		pl2.addSong(s3);
		//		pl1.addPlayList(pl2);
		//		System.out.println(pl1.getPlayTimeSeconds());
				
		//		PlayList pl2 = new PlayList();
		//		pl2.addSong(s2);
		//		pl1.addPlayList(pl2);
		//		System.out.println(pl1.toString());
				
		//		String a = "3:15";
		//		String[] splited = a.split(":");
		//		int j;
		//		for(j = 0; j < splited.length; j ++){
		//			int ele2 = Integer.parseInt(splited[j]);
		//			System.out.println(ele2 + 1);
		//		}
		//		
				
				System.out.println(pl1.loadSongs("load2.txt"));
				System.out.println("***********Hello");
				System.out.println(s1.equals(pl1.getPlayableList().get(1)));
				System.out.println("***********Bye");
				pl1.removePlayable(s1);
				System.out.println(pl1.toString());
				
				Playable p = new Song("E", "a", 2, 24);
				
		
			}




}
