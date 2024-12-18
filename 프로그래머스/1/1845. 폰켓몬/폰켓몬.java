import java.util.*;

class Solution {
    public int solution(int[] nums) {
         List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(list.size() == nums.length/2)
                break;
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }

        }
        
        return list.size();
    }
}