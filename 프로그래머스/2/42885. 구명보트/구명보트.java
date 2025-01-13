import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boats = 0;
        int left = 0;
        int right = people.length-1;
        Arrays.sort(people);
        
        while(left <= right){
            if(left == right){
                boats++;
                break;
            }
            
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else{
                right--;
            }
            boats++;
                
        }

        return boats;
    }
}