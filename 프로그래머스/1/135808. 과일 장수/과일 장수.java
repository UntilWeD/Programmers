import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for(int i=score.length-1; 0 <= i;i-=m){
            if(i-m < -1)
                break;
            int[] box = new int[m];
            for(int j=0; j<m; j++){
                box[j] = score[i-j];
            }
            answer += box[m-1] * m;

        }
        
        
        return answer;
    }
}