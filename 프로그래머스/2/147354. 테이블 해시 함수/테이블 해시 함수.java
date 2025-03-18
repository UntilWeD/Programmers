import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[] tupleSum = new int[data.length];
        Tuple[] tuples = new Tuple[data.length];
        
        for(int i=0; i < data.length; i++){
            Tuple tp = new Tuple(data[i][0], data[i][col-1], i);
            tuples[i] = tp;
        }
        
        Arrays.sort(tuples);
        
        for(int i=row_begin-1; i <=row_end-1; i++){

            int sum = 0;
            int[] tuple = data[tuples[i].getIndex()];
            
            for(int num : tuple){
                sum += num % (i+1);
            }
            
            tupleSum[i] = sum;
        }
        
        int answer = tupleSum[0];
        for(int i = 1; i < tupleSum.length; i++){
            answer= answer ^ tupleSum[i];
        }
        
        return answer;
    }
    
    
}

class Tuple implements Comparable<Tuple> {
    private int pk;
    private int tk;
    private int index;
    
    public Tuple(int pk, int tk, int index){
        this.pk = pk;
        this.tk = tk;
        this.index = index;
    }
    
    public int getPK(){
        return this.pk;
    }
    
    public int getTK(){
        return this.tk;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    @Override
    public int compareTo(Tuple tp){
        if(this.tk == tp.getTK())
            return tp.getPK() - this.pk; // 내림차순 정렬
        
        return this.tk - tp.getTK(); // 오름차순 정렬
        
    }
}