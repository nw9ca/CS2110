import java.util.ArrayList;
import java.util.TreeMap;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class HashFunction {
	
	public static int hashNum(int NumString){
		String[] arrStr = RandomWords.generateRandomWords(NumString);
		int collision = 0;
		int i;
//		TreeMap<Character, Integer> charFrequency = new TreeMap<Character, Integer>();
//		for(i = 0; i< arrStr.length; i++){
//			if(!charFrequency.containsKey(arrStr[i].charAt(0))){
//				charFrequency.put(arrStr[i].charAt(0), 1);
//			}
//			else{
//				int newNum = charFrequency.get(arrStr[i].charAt(0)) + 1;
//				charFrequency.put(arrStr[i].charAt(0), newNum);
//			}
//		}
//		
//		//System.out.println(charFrequency);
//		ArrayList<Integer> numRepeat = new ArrayList<Integer>(charFrequency.values());
//		for(i = 0; i< numRepeat.size(); i++){
//			if(numRepeat.get(i)!= 0 && numRepeat.get(i) != 1){
//				collision += numRepeat.get(i);
//			}
//		}
		String[] hashTable = new String[500];
		int[] arrHash = new int[NumString];
		for(i = 0; i<NumString; i++){
			String str = arrStr[i];
			int encodedStr = 0;
			int j;
			for(j = 0; j < str.length(); j++){
				char character = str.charAt(j);
				encodedStr += (int) character;
			}
			arrHash[i] = encodedStr % 500;
		}
		
		int k;
		for(k = 0; k<NumString; k++){
			if(hashTable[arrHash[k]] == null){
				hashTable[arrHash[k]] = arrStr[k];
			}
			else{
				collision += 1;
				int t;
				for(t = arrHash[k]; t< 500; t++){
					if(hashTable[t] == null){
						hashTable[t] = arrStr[k];
					}
					
				}
			}
		}
		return collision;
		
	}

	public static void main(String[] args) {
		System.out.println(hashNum(1000));
		System.out.println(hashNum(900));
		System.out.println(hashNum(800));
		System.out.println(hashNum(700));
		System.out.println(hashNum(600));
		// TODO Auto-generated method stub

	}

}
