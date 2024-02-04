class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        char c = ' ';
        
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            System.out.println(c);
            if( c == 'p' || c == 'P'){
                p++;
            } else if( c == 'y' || c == 'Y'){
                y++;
            }
            
            c= ' ';
        }
        
        System.out.println(p);
        System.out.println(y);
        if(p != y)
            return answer=false;
        
        return answer;
    }
}