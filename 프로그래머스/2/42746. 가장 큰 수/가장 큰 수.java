import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Number[] arr = new Number[numbers.length];
        
        for(int i=0; i < numbers.length; i++){
            arr[i] = new Number(numbers[i] + "");
        }
        
        Arrays.sort(arr);
        
        for(Number number : arr){
            answer += number.getNum();
        }
        
        if(answer.charAt(0) == '0')
            return "0";
        
        return answer;
    }
    
    class Number implements Comparable<Number>{
        String num;

        public Number(String num){
            this.num = num;
        }
        
        public String getNum(){
            return num;
        }
        
        @Override
        public int compareTo(Number other){
            String sum1 = this.num + other.num;
            String sum2 = other.num + this.num;
            return sum2.compareTo(sum1);
        }
    }
}