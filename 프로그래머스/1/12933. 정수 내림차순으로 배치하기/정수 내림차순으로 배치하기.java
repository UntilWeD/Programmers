import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        Integer[] arr = new Integer[s.length()];
        
        for(int i=0; i<s.length();i++){
            arr[i] = s.charAt(i) - '0';
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        s= "";

        for(int i=0; i<arr.length;i++){
             s += Integer.toString(arr[i]);
        }
        
        answer = Long.parseLong(s);
        
        return answer;
    }
}