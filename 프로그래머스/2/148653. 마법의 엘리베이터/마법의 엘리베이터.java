class Solution {
    public int solution(int storey) {
        int answer = 0;

        String target = storey + "";
        int[] numbers = new int[target.length()];
        for(int i=0; i < target.length(); i++){
            numbers[numbers.length-i-1] = target.charAt(i) - '0';
        }
        
        for(int i=0; i < numbers.length; i++){
            if(numbers[i] < 5){
                answer += numbers[i];
                
            } else if(numbers[i] > 5){
                if(i + 1 == numbers.length){
                    answer++;
                } else{
                    ++numbers[i+1];
                }
                answer += (10 - numbers[i]);
                
            } else if(numbers[i] == 5){
                if(i+1 < numbers.length && numbers[i+1] >= 5){
                    numbers[i+1]++;
                    answer += (10 - numbers[i]);
                } else{
                    answer += numbers[i];
                }
            }
            
            
        }
        
        return answer;
    }
}