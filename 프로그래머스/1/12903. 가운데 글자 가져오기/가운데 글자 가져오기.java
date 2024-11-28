class Solution {
    public String solution(String s) {
        
        if(s.length() % 2 != 0){
            return s.substring((int)s.length() /2, (int)s.length()/2+1);
        } else{
            return  s.substring((int)s.length()/2-1, (int)s.length()/2+1);
        }
    }
}