
public class Mystery {

	public static void mystery(int a, int b){
		if(a==b){System.out.println(a);}
		else{
			int m1 = (a+b)/2;
			int m2 = (a+b+1)/2;
			mystery(a,m1);
			mystery(m2,b);
		}
	}
	
	public static void main(String[] args) {
		mystery(0,8);
		// TODO Auto-generated method stub

	}

}
