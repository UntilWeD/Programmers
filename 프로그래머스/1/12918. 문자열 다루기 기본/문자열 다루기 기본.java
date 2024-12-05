class Solution {
    public boolean solution(String s) {
    
        if(s.length() == 4 || s.length() == 6){
            for(int i=0; i < s.length(); i++){
                if((int)s.charAt(i) < 47 || (int)s.charAt(i)  > 58){
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
}