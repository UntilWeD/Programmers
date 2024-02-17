class Solution {
    public int[] solution(int[] numbers, String direction) {
        int temp_a = 0;
        int temp_b = 0;
        
        switch(direction){
            case "left":
                temp_a = numbers[numbers.length-1];
                temp_b = numbers[numbers.length-2];
                for(int i=numbers.length-1; i > 0; i--){
                    numbers[i-1] = temp_a;
                    if(i-1 == 0){
                        numbers[numbers.length-1] = temp_b;
                        break;
                    }
                    temp_a = temp_b;
                    temp_b = numbers[i-2];
                }
                break;
            case "right":
                temp_a = numbers[0];
                temp_b = numbers[1];
                for(int i=0; i < numbers.length; i++){
                    numbers[i+1] = temp_a;
                    if(i+2 == numbers.length){
                        numbers[0] = temp_b;
                        break;
                    }
                    temp_a = temp_b;
                    temp_b = numbers[i+2];
                }
                
        }
        
        int[] answer = numbers;
        
        
        return answer;
    }
}