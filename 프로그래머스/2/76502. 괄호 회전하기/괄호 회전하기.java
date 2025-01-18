import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<s.length(); j++){
                char ch = s.charAt((i+j) % s.length());
                if(stack.empty()){
                    stack.push(ch);
                } else{
                    if((stack.peek() == '[' && ch == ']') ||
                       (stack.peek() == '(' && ch == ')') ||
                       (stack.peek() == '{' && ch == '}')) {
                        stack.pop();
                    } else{
                        stack.push(ch);
                    }
                }
            }
            
            if(stack.empty()){
                answer++;
            }
            
        }
        
        
        
        return answer;
    }
}