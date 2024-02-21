class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String s = Integer.toString(order);
        
        for(int i=0; i<s.length(); i++){
            if(((s.charAt(i)-'0') % 3) == 0 && s.charAt(i)-'0' != 0)
                answer++;
        }
        
        return answer;
    }
}