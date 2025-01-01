import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int index = 0;
        Arrays.sort(mats);
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length; j++){
                if(park[i][j].equals("-1")){
                    while(index < mats.length && checkPlace(i, j, mats[index], park)){
                        index++;
                    }
                }
            }
        }
    
         
        return index > 0 ? mats[index-1] : -1;
    }
    
    public boolean checkPlace(int row, int col, int size , String[][] park){
        // size에 대해서 넘어가는지 체크
        if(row + size > park.length || col + size > park[0].length)
            return false;
        
        // 해당 돗자리 원소가 자리에서 필 수 있는지 확인
        for(int i=row; i < row + size; i++){
            for(int j=col; j< col+ size; j++){
                if(!park[i][j].equals("-1"))
                    return false;
            }
        }
        
        return true;   
    }
    
}