import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if( a.isPlayoffTeam() == true && b.isPlayoffTeam() == false){
			return -1;
		}
		else if( a.isPlayoffTeam() == false && b.isPlayoffTeam() == true){
			return 1;
		}
		else if(a.getSalaryInMillions() < b.getSalaryInMillions()){
			return -1;
		}
		return 1;
		
	}
}


