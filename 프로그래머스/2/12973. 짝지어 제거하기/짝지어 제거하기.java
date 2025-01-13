import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(!stack.empty()){
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                } else{
                    stack.push(s.charAt(i));
                }
            } else{
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.empty()){
            return 1;
        } else{
            return 0;
        }

    }
}