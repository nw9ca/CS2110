//nw9ca in-Class 11
public class MaxMin {

	public static void main(String[] args) {
		int[] values = {11, 12, 13, 14, 16, 18, 17, 14, 19};
		int[] lowestHightest = maxMin(values, 0, values.length-1);
		System.out.println(lowestHightest[0]); //should print out 11
		System.out.println(lowestHightest[1]);//should print out 19

	}

	//maxMin returns an array of min and max of an array in that order.
	public static int[] maxMin(int[] list, int first, int last){
		int n = list.length;
		int[] result = new int[2];
		if(n == 1){
			result = new int[2];
			result[0] = list[0];
			result[1] = list[0];
			return result;
		}
		else if( n ==2){
			if(list[0] < list[1]){
				result = new int[2];
				result[0] = list[0];
				result[1] = list[1];
			}
			else{
				result = new int[2];
				result[0] = list[1];
				result[1] = list[0];
			}	
		}
		else{
			int[]left = new int[n/2];
			int[] right;
			if(n%2 == 0){		//Tricky here:Odd and Even numbers of elements in arrays
				right = new int[n/2];
			}
			else{
				right = new int[n/2+1];
			}
			
			int i
			;
			for(i = 0; i< n; i++){
				if(i < n/2){
					left[i] = list[i];
				}
				else{
					right[i-n/2] = list[i];
				}
			}


			int[] maxMinLeft = maxMin(left, left[0], left[n/2-1]);
			int[] maxMinRight = maxMin(right, right[0], right[n/2-1]);
			if(maxMinLeft[1] < maxMinRight[1]){
				result[1] = maxMinRight[1];
			}
			else{
				result[1] = maxMinLeft[1];
			}
			if(maxMinLeft[0] < maxMinRight[0]){
				result[0] = maxMinLeft[0];
			}
			else{
				result[0] = maxMinRight[0];
			}

		}
		return result;


		//Reveiw the binary search algoithm to see how to use the first and last parameter	
	}

}
