import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.equals("")) return "";
        return makeBracket(p);
    }
    
    public String makeBracket(String w){
        if (w.equals("")) return "";
        
        int[] counts = new int[2];
        String answer = "";
        String u = "";
        String v = "";
        
        int index = 0;
        while(index != w.length()){
            char ch = w.charAt(index++);
            u += ch;
            
            if(ch == '('){
                counts[0]++;
            } else if (ch == ')'){
                counts[1]++;
            }
            
            // 균형잡힌 문자열이라면
            if(counts[0] == counts[1]){
                v = w.substring(index);
                break;
            }
        }
        
        if(isRight(u)){     // 올바른 괄호 문자열이라면
            answer += u;
            answer += makeBracket(v);
        } else {        // 올바르지 않은 괄호 문자열이라면
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(makeBracket(v));
            sb.append(")");
            
            u =  u.substring(1, u.length()-1);
            for(int i=0; i < u.length(); i++){
                char ch = u.charAt(i);
                if(ch == '(') sb.append(")");
                else sb.append("(");
            }
            
            answer += sb.toString();
        }       
            
        
        
        return answer;
    }
    
    public boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if(stack.peek() == '(' && ch == ')'){ // 한 쌍일 때
                stack.pop();
            } else{                               // 한 쌍이 아니라면
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}