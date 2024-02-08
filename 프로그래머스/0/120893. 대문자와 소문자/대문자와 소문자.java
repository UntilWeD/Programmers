class Solution {
    public String solution(String my_string) {
        String answer = "";
        char chr = ' ';
        
        for(int i=0;i<my_string.length(); i++){
            chr = my_string.charAt(i);
            if(chr > 96 && chr <123){
                answer += Character.toUpperCase(chr);  
            } else {
                answer += Character.toLowerCase(chr);
            }
        }
        
        return answer;
    }
}