import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.empty() && stack.peek() == '(' && ch == ')'){
                stack.pop();
            } else{
                stack.push(s.charAt(i));
            }
        }
        
        if(!stack.empty())
            return false;
       

        return true;
    }
}