import java.util.*;


class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> divisors = new ArrayList<>();

        for(int num : arrayA)
            min = Math.min(num, min);
        
        for(int i=1; i*i <= min; i++){
            if(min % i == 0){
                divisors.add(i);
                if(i != min / i)
                    divisors.add(min/i);
            }
        }
        
        for(int divisor : divisors){
            if(canDivide(arrayA, divisor) && cantDivide(arrayB, divisor)){
                answer = Math.max(divisor, answer);
            }
        }
        
        divisors.clear();
        min = Integer.MAX_VALUE;
        
        for(int num : arrayB)
            min = Math.min(num, min);
        
        for(int i=1; i*i <= min; i++){
            if(min % i == 0){
                divisors.add(i);
                if(i != min / i)
                    divisors.add(min/i);
            }
        }
        
        for(int divisor : divisors){
            if(canDivide(arrayB, divisor) && cantDivide(arrayA, divisor)){
                answer = Math.max(divisor, answer);
            }
        }
        
        
        return answer;
    }
    
    public boolean canDivide(int arr[], int num){
        for(int temp : arr){
            if(temp % num != 0) return false;
        }
        
        return true;
    }
    
    public boolean cantDivide(int arr[], int num){
        for(int temp : arr){
            if(temp % num == 0) return false;
        }
        
        return true;
    }
}