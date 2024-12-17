import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] sum = new int[n];
        
        for(int i=0; i<n;i++){
            answer[i] = String.format("%"+n+"s",Integer.toBinaryString(arr1[i] | arr2[i]));
            answer[i] = answer[i].replaceAll("0", " ").replaceAll("1", "#");
        }
        
        
        return answer;
    }
}