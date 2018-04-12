import java.util.TreeMap;

public class Polynomial {
	private TreeMap<Integer, Double> terms;
	public Polynomial(){
		terms = new TreeMap<Integer,Double>();
	}
	
	public void addTerm(int n, double d){
		terms.put(n, d);
	}
	
	public Polynomial multiply(Polynomial p){
		Polynomial newP = new Polynomial();
		for(Integer deg : this.getTerms().keySet()){
			for(Integer deg2 : p.getTerms().keySet()){
				int power = deg + deg2;
				double coeff = this.getTerms().get(deg) * p.getTerms().get(deg2);
				if(newP.getTerms().containsKey(power)){
					double oldCoeff = newP.getTerms().get(power);
					newP.addTerm(power, coeff + oldCoeff);
					System.out.println(newP.getTerms().get(power));
					
				}
				else{
					newP.addTerm(power, coeff);
				}
			}
		}
		return newP;
	}

	public TreeMap<Integer, Double> getTerms() {
		return terms;
	}

	public void setTerms(TreeMap<Integer, Double> terms) {
		this.terms = terms;
	}
	
	public static void main(String[] args) {
		Polynomial p = new Polynomial();
		p.addTerm(2,(double) 3);
		p.addTerm(1, (double) 2);
		
		Polynomial r = new Polynomial();
		r.addTerm(1, (double) 1);
		
		Polynomial a = p.multiply(r);
		
		System.out.println(a.getTerms().get(3));
		
		Polynomial result = new Polynomial();
		result.addTerm(3, (double) 3);
		result.addTerm(2, (double) 2);
		
		System.out.println(p.getTerms().get(2));
	}
}
