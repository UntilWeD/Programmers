import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        List<String> list = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        List<String> cases = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if('0' <= ch && '9' >= ch)
                sb.append(ch);
            else{ // 연산자 일 경우
                list.add(sb.toString());
                list.add(ch + "");
                sb.setLength(0);
                
                if(!operators.contains(ch + ""))
                    operators.add(ch + "");
            }
        }
        list.add(sb.toString());
        
        
        boolean[] visited = new boolean[operators.size()];
        dfs(operators, cases, visited, "");
        
        for(String ca : cases){
            List<String> tempList = new ArrayList<>(list);
            
            for(int j=0; j < ca.length(); j++){
                String operator = ca.charAt(j) + "";
                
                for(int k=0; k < tempList.size(); k++){
                    if(k < tempList.size() && tempList.get(k).equals(operator)){
                        String num1 = tempList.get(k - 1);
                        String num2 = tempList.get(k + 1);
                        String result = calculation(num1, operator, num2);
                        
                        
                        tempList.set(k - 1, result);
                        tempList.remove(k);  
                        tempList.remove(k);  
                        
                        k--; 
                    }
                }
            }
            
            long result = Math.abs(Long.parseLong(tempList.get(0)));
            answer = Math.max(answer, result);
        }
    
        
        
        return answer;
    }
    
    public void dfs(List<String> operators, List<String> cases, boolean[] visited, String temp){    
        for(int i=0; i < operators.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(operators, cases, visited, temp + operators.get(i));
                visited[i] = false;
            }
        }
        
        
        if(temp.length() == operators.size())
            cases.add(temp);
    }
    
    public String calculation(String num1, String operator, String num2){
        long x = Long.parseLong(num1);
        long y = Long.parseLong(num2);
        long answer = 0;
        
        switch(operator){
            case "+":
                answer = x+y;
                break;
            case "-":
                answer = x-y;
                break;
            case "*":
                answer = x*y;
                break;
            default:
                break;
        }
        
        return answer + "";
    }
}