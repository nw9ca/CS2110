//Pat Wongwiset (nw9ca); hw4
import java.util.Comparator;

public class NameComaparator implements Comparator<Playable> {

	@Override
	/**compare (ascending order) **/
	public int compare(Playable pl1, Playable pl2){
		String name1 = pl1.getName();
		String name2 = pl2.getName();
		return name1.compareTo(name2);
	}

}
