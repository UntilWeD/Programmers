class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer(s);
        int index = 0;
        
        for(int i=0; i< sb.length(); i++){
            if(sb.charAt(i) != ' '){
                if(index % 2 == 0){
                    sb.setCharAt(i ,Character.toUpperCase(sb.charAt(i)));
                } else{
                    sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
                }
                index++;
            } else{
                index = 0;
            }
        }
    
        return sb.toString();
    }

}