//Pat Wongwiset (nw9ca); hw4
import java.util.Comparator;

public class TimeComaparator implements Comparator<Playable> {

	@Override
	public int compare(Playable p1, Playable p2) { //in ascending order
			if(p1.getPlayTimeSeconds() < p2.getPlayTimeSeconds()){
				return -1;
			}
			else if(p1.getPlayTimeSeconds() > p2.getPlayTimeSeconds()){
				return 1;
			}
			return 0;
	}

}
