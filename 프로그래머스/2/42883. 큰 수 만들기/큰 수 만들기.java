import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));
        
        int i = 1;
        while(k != 0 && i < number.length()){
            if(stack.peek() >= number.charAt(i)){
                stack.push(number.charAt(i));
            } else {
                while(!stack.isEmpty() && stack.peek() < number.charAt(i)){
                    stack.pop();
                    k--;
                    if(k == 0)
                        break;
                }
                stack.push(number.charAt(i));
            }
            i++;
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        for(int j = i; j < number.length(); j++){
            sb.append(number.charAt(j));
        }
        
        return sb.toString();
    }
}