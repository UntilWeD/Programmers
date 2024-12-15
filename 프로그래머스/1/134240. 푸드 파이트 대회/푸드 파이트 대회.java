class Solution {
    public String solution(int[] food) {
        StringBuffer answer = new StringBuffer();
        answer.append(0);
        
        for(int i=food.length-1; 0 <= i; i--){
            while(food[i] > 1){
                food[i] -= 2;
                answer.append(i);
                answer.insert(0, i);
            }
        }
        
        
        return answer.toString();
    }
}