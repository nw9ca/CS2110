
public class GoodEmployee extends Employee {

	// fields
	public int numAwards;

	// constructor
	public GoodEmployee(String n, String ha, String wa, int id, int num){
		super(n,ha, wa, id);
		this.numAwards = num;
	}


	// toString
	@Override
	public String toString(){
		String str = super.toString();
		str += " Awards: " + this.numAwards;
		return str;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
