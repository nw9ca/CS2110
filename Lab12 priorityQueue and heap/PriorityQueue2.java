import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cole on 11/6/16.
 */
public class PriorityQueue2 {

    private ArrayList<Integer> pQueue;

    public PriorityQueue2(){
        pQueue = new ArrayList<>();
    }

    public boolean isEmpty(){
        return pQueue.isEmpty();
    }

    //O(n)
    public void insert(int num){
        if(pQueue.isEmpty()){
            pQueue.add(num);
        } else {
            int size = pQueue.size();
            for(int i = 0; i < size; i++){
                if(pQueue.get(size - 1) < num){
                    pQueue.add(num);
                    break;
                } else if(pQueue.get(i) > num && i == 0){
                    pQueue.add(0, num);
                    break;
                } else if (pQueue.get(i) > num){
                    pQueue.add(i , num);
                    break;
                }
            }
        }
    }

    //O(1)
    public int remove(){
        if(pQueue.isEmpty()){
            System.out.println("The priority queue is empty. Return value is 0");
            return 0;
        } else {
            int max = pQueue.get(pQueue.size() - 1);
            pQueue.remove(pQueue.size() - 1);
            return max;
        }
    }

    public ArrayList<Integer> getpQueue() {
        return pQueue;
    }

    public void setpQueue(ArrayList<Integer> pQueue) {
        this.pQueue = pQueue;
    }

    /*
     * This function creates an ArrayList of input data. You may specify the size and
     * max number in the list. Use this to create data to insert into your PriorityQueue
     * when testing run time.
     */
    public static ArrayList<Integer> createInput(int size, int maxNum){
        ArrayList<Integer> retVal = new ArrayList<>();
        for(int i = 0; i < size; i++){
            retVal.add(ThreadLocalRandom.current().nextInt(0, maxNum + 1));
        }
        return  retVal;
    }

    public static void main(String [] args){
    	System.out.println("pQueue 2");
    	ArrayList<Integer> i = PriorityQueue2.createInput(12500, 1000);
    	PriorityQueue2 prior = new PriorityQueue2();
    	int k;
    	//long time = System.nanoTime();
    	for(k =0; k < i.size(); k++ ){
    		prior.insert(i.get(k));
    	}
    	//System.out.println((System.nanoTime()-time)/1000000000.0);
    	
    	long time = System.nanoTime();
    	while(prior.pQueue.size() != 0){
    		prior.remove();
    	}
    	System.out.println((System.nanoTime()-time)/1000000000.0);
  //	insert						remove  	
/*8.582715281 s - 100000 input	-	0.007761109
 *1.958837668 s - 50000			-	0.004948914
 *0.595673076 s - 25000			-	0.004302932
 *0.162336661 s - 12500 		-	0.003501907
 */

    }
}
