class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i =0; i<answer.length; i++)
            answer[i] = -1;
        
        
        for(int i=0; i< s.length(); i++){
            for(int j=i-1; 0 <= j; j--){
                if(s.charAt(i) == s.charAt(j)){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}