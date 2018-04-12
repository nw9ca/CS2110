import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class TestHW4 {
	Song s1;
	Song s2;
	Song s3;
	PlayList pl1;

	@Before
	public void setUp(){
		s1 = new Song("Ed","Shape of You", 3, 24);
		s2 = new Song("Ed","Shape of You", 3, 24);
		s3 = new Song("Ed","Perfect", 2, 15);
		pl1 = new PlayList("Fav");
		pl1.addSong(s1);
	}

	/** Song Class
	 * equals() test: 1. Check true case 2. Check false case
	 */
	@Test
	public void equalsTest1() {
		assertTrue(s1.equals(s2));
	}

	@Test
	public void equalsTest2() {
		assertFalse(s1.equals(s3));
	}

	/**
	 * toString(): 1. Check not null 2. Check that it print correctly
	 */

	@Test
	public void toStringTest1(){
		assertNotNull(s2.toString());
	}

	@Test
	public void toStringTest2(){
		assertEquals(s1.toString(), "{Song: title = " + "Shape of You" + " artist = " + "Ed" + "}");
	}

	/**
	 * CompareTo(): 1. Check when two song equals 2. Two songs have the same title, but different artists
	 */

	@Test
	public void compareToTest1(){
		assertEquals(s1.compareTo(s2), 0);
	}

	@Test
	public void compareToTest2(){
		Song s4 = new Song("One D","Perfect", 2, 15);
		assertEquals(s3.compareTo(s4), -1);
	}

	/** PlayList Class
	 * toString()
	 * 1. Check not null
	 * 2. no song in the playlist
	 */

	@Test
	public void toStringPLTest1(){
		assertNotNull(pl1.toString());
	}

	@Test
	public void toStringPLTest2(){
		PlayList pl2 = new PlayList();
		assertEquals(pl2.toString(), "PlayList Untitled");
	}

	/**
	 * addSong()
	 * 1. Add repeated song
	 * 2. Add new song
	 */

	@Test
	public void addSongTest1(){
		pl1.addSong(s2);
		assertEquals(pl1.getPlayableList().size(), 2);
	}


	@Test
	public void addSongTest2(){
		assertTrue(pl1.addSong(s3));
	}

	/**
	 * clear()
	 * 1. Empty PlayList
	 * 2. Clear PlayList
	 */

	@Test
	public void clearTest1(){
		PlayList pl2 = new PlayList();
		assertFalse(pl2.clear());
	}

	@Test
	public void clearTest2(){
		assertTrue(pl1.clear());
	}


	/**
	 * removePlayable(int index)
	 * 1. check null
	 * 2. check equals
	 */

	@Test
	public void removePlayableTest1(){
		pl1.removePlayable(-3);
		assertNull(pl1.removePlayable(-3));
	}

	@Test
	public void removePlayableTest2(){
		assertEquals(pl1.removePlayable(0), s1);
	}

	/**
	 * removePlayable(Playable p)
	 * 1. check length
	 * 2. check equals
	 */

	@Test
	public void removePlayableTest3(){
		pl1.addSong(s2);
		pl1.addSong(s2);
		pl1.removePlayable(s2);
		assertEquals(pl1.numberOfSongs(), 0);
	}

	@Test
	public void removePlayableTest4(){
		assertEquals(pl1.removePlayable(s2), s2);
	}

	/**
	 * addPlayList()
	 * 1. Add repeated new playlist
	 * 2. Add new playlist
	 */

	@Test
	public void addPlayListTest1(){
		PlayList pl2 = new PlayList();
		pl1.addPlayList(pl2);
		assertFalse(pl1.addPlayList(pl2));
	}

	@Test
	public void addPlayListTest2(){
		PlayList pl2 = new PlayList();
		assertTrue(pl1.addPlayList(pl2));
	}

	/**
	 * sortByName()
	 * 1. Same type
	 * 2. Different types
	 */

	@Test
	public void sortByNameTest1(){
		Song s4 = new Song("OneD", "A Day", 2, 20);
		pl1.addSong(s4);
		pl1.sortByName();
		assertEquals(pl1.getPlayable(0), s4);
	}

	@Test
	public void sortByNameTest2(){
		PlayList a = new PlayList("1 Day");
		pl1.addPlayList(a);
		pl1.sortByName();
		assertEquals(pl1.getPlayable(0), a);
	}

	/**
	 * sortByTime()
	 * 1. same type
	 * 2. different types
	 */

	@Test
	public void sortByTimeTest1(){
		Song s4 = new Song("OneD", "A Day", 2, 20);
		pl1.addSong(s4);
		pl1.addSong(s3);
		pl1.sortByTime();
		assertEquals(pl1.getPlayable(2), s1);
	}

	@Test
	public void sortByTimeTest2(){
		PlayList a = new PlayList("1 Day");
		a.addSong(s3);
		a.addSong(s1);
		pl1.addPlayList(a);
		pl1.addSong(s3);
		pl1.sortByTime();
		assertEquals(pl1.getPlayable(2), a);
	}

	/**
	 * getPlayTimeSeconds
	 * 1. In Song Class
	 * 2. In PlayList with PlayList inside
	 */

	@Test
	public void getPlayTimeSecondsTest1(){
		assertEquals(s1.getPlayTimeSeconds(), 204);
	}

	@Test
	public void getPlayTimeSecondsTest2(){
		PlayList pl2 = new PlayList("Fav2");
		pl2.addSong(s2);
		pl1.addPlayList(pl2);
		assertEquals(pl1.getPlayTimeSeconds(), 408);

	}



	/**
	 * loadSongs()
	 * 1. Check return true
	 * 2. Check the size of the playlist after loading
	 * 3. Multi white space
	 */

	@Test
	public void loadSongsTest1(){
		assertTrue(pl1.loadSongs("load.txt"));
	}

	@Test
	public void loadSongsTest2(){
		pl1.loadSongs("load2.txt");
		assertEquals(pl1.getPlayableList().size(), 4);
	}

	@Test
	public void loadSongTest3(){
		pl1.loadSongs("load3.txt");
		Song s4 = (Song) pl1.getPlayable(1);
		assertEquals(s4.getPlayTimeSeconds(), 121);
	}

	/**
	 * getPlayable(int index)
	 * 1. inbound index
	 * 2. outbound index
	 */

	@Test
	public void getPlayableTest1(){
		pl1.addSong(s3);
		assertEquals(pl1.getPlayable(1), s3);
	}

	@Test
	public void getPlayableTest2(){
		assertNull(pl1.getPlayable(-1));
	}


}
