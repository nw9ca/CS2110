
public class InsertionSort {
	public static void InsertS(int[] d){
		int i;
		for(i = 1; i< d.length; i++){
			int insert = d[i];
			int index = i;
			
			while(index > 0 && d[index -1] > insert){
				d[index] = d[index - 1];
				index = index -1;
				
			}
			d[index] = insert;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 7, 9};
		InsertS(arr);
		for(int i: arr){
			System.out.println(i);
		}
	}

}
