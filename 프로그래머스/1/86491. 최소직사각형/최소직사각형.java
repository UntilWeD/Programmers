class Solution {
    public int solution(int[][] sizes) {
        int[] answer = new int[2];
        
        for(int i=0; i < sizes.length; i++){
            for(int j=0; j < sizes[i].length; j++){
                if(answer[0] <= sizes[i][j])
                    answer[0] = sizes[i][j];
            }
        }
        
        for(int i=0; i < sizes.length; i++){
            
            if(sizes[i][0] > sizes[i][1]){
                if(answer[1] <= sizes[i][1])
                    answer[1] = sizes[i][1];
            } else{
                if(answer[1] <= sizes[i][0])
                    answer[1] = sizes[i][0];
            }
            
        }

        
        
        
        
        return answer[0]*answer[1];
    }
}