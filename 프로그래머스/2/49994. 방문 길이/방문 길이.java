import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i < dirs.length(); i++){
            char ch = dirs.charAt(i);
            int nx = x;
            int ny = y;
            
            switch (ch) {
                case 'U': ny += 1; break;
                case 'D': ny -= 1; break;
                case 'R': nx += 1; break;
                case 'L': nx -= 1; break;
                default: break;
            }
            
            if(canGo(nx, ny)){
                String temp = ""+x+y+nx+ny;
                String reverse = "" + nx+ ny+x+y;
                set.add(temp);
                set.add(reverse);
                
                x = nx; 
                y = ny;
            }

        }
        
        return set.size()/2;
    }
    
    public boolean canGo(int x, int y){
        if(x >= -5 && x <= 5 && y <= 5 && y >= -5)
            return true;
        return false;
    }
}