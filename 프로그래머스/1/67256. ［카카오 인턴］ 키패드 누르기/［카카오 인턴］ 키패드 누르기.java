import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 인덱스에 따른 값
        int[][] keypad = {{1,3},{0,0}, {1,0}, {2,0}, // 0, 1, 2, 3
                          {0,1}, {1,1}, {2,1},       // 4, 5, 6
                          {0,2}, {1,2}, {2,2}};      // 7, 8, 9
        // ex. left[0] -> 열, left[1] -> 행
        int[] left = {0,3};
        int[] right = {2,3};
        
        for(int i=0; i<numbers.length; i++){
            int[] index = keypad[numbers[i]];
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer+="L";
                left = index;
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer+="R";
                right = index;
            } else{
                // 오른쪽 엄지손가락이 가깝다면
                if(getCoordinates(left, index) > getCoordinates(right, index)){
                    System.out.println(right);
                    answer+="R";
                    right = index;
                // 왼쪽 엄지손가락이 가깝다면
                } else if((getCoordinates(left, index) < getCoordinates(right, index))){
                    answer+="L";
                    left = index;
                // 둘 다 거리가 같을시에
                } else{
                    if(hand.equals("right")){
                        answer+="R";
                        right = index;
                    } else{
                        answer+="L";
                        left = index;
                    }
                }
            }
        }

        
        return answer;
    }
    
    public int getCoordinates(int[] hand, int[] target){
        int sum = 0;
        sum += (hand[0] >= target[0]) ? hand[0] - target[0] : target[0] - hand[0];
        sum += (hand[1] >= target[1]) ? hand[1] - target[1] : target[1] - hand[1];
        return sum;
    }
}