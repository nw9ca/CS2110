
public class Fibonacci {
	public static double F(double n){
		if(n == 1 || n ==2){
			return 1;
		}
		else if(n%2 == 1){
			//return F(Math.pow((n+1)/2,2)) + F(Math.pow((n-1)/2,2)) ;
			return F((n+1)/2)*F((n+1)/2) + F((n-1)/2)*F((n-1)/2);
		}
		else{
			//return F(Math.pow(n/2 + 1, 2)) - F(Math.pow(n/2 - 1, 2)) ;
			return F(n/2 +1)*F(n/2 + 1) - F(n/2 -1)*F(n/2 -1); 
		}
	}
	public static void main(String[] args) {
		System.out.println(F(6));
		// TODO Auto-generated method stub

	}

}
