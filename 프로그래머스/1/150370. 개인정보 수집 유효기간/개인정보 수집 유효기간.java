import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int to = toNumber(splitTheDots(today));
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            int sum = toNumber(splitTheDots(privacies[i].substring(0, 10)));
            for(int j=0; j<terms.length; j++){
                if(terms[j].charAt(0) == privacies[i].charAt(privacies[i].length() -1)){
                    sum += Integer.parseInt(terms[j].substring(2)) * 28;
                    break;
                }
            }
            // 유효기간을 넘었을때
            if(sum <= to){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public String[] splitTheDots(String str){
        return str.split("\\.");
    }
    
    public int toNumber(String[] date){
        int sum=0;
        sum += Integer.parseInt(date[0])*28*12 + Integer.parseInt(date[1])*28 + Integer.parseInt(date[2]);
        return sum;
    }
}