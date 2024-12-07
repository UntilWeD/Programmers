class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        
        
        for(int i=0; i<t.length()-p.length()+1; i++){
            String tempA = t.substring(i, i + p.length());
            
            for(int j=0; j< tempA.length(); j++){
                if(tempA.length() == 1){
                   break;
                }
                if(tempA.charAt(0) == '0'){
                    tempA = tempA.substring(1);
                }
            }
            
            if(Long.parseLong(tempA) <= Long.parseLong(p)){
                answer++;
            }
        }
        
        return answer;
    }
}