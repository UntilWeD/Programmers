class Solution {
    public String solution(int n) {
        String suBak = "수박";
        
        if(n % 2 == 1){
            return suBak.repeat(n/2) + "수"; 
        } else {
            return suBak.repeat(n/2);
        }
    
    }
}