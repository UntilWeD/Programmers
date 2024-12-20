class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                for(int k=j+1; k < nums.length; k++){
                    int divisor = 0;
                    int sum = (int)(Math.sqrt(nums[i]+nums[j]+nums[k]));
                    
                    for(int l=1; l <= sum ; l++){
                        if((nums[i]+nums[j]+nums[k]) % l == 0){
                            divisor++;
                            if(nums[i]+nums[j]+nums[k] / l != l)
                                divisor++;
                        }
                        if(divisor > 2)
                            break;
                    }

                    if(divisor == 2)
                        answer++;
                }
            }
        }

        

        return answer;
    }
}