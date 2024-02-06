class Solution {
    public String solution(String my_string) {
        StringBuffer sb = new StringBuffer(my_string);
        char[] vowel = {'a','e','i','o','u'};
        
        for(int i=0; i<vowel.length; i++){
            if(my_string.contains(vowel[i]+"")){
                sb.deleteCharAt(sb.indexOf(vowel[i]+""));
                my_string = sb.toString();
                i--;
            }
        }
        
        
        
        return sb.toString();
    }
}