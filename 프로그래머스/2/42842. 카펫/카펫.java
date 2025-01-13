class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=yellow; i++){
            if(yellow % i ==0){
                int temp = yellow/i;
                if(brown == (temp+2)*2 + i*2){
                    answer[0] = temp+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}