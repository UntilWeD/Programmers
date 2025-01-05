class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        
        while(!s.equals("1")){
            // 0 제거
            String temp = s.replace("1", "");
            s = s.replace("0", "");
            answer[1] += temp.length();
            answer[0]++;
            
            // 길이를 2진법으로
            s = Integer.toBinaryString(s.length());
        }
        
        
        return answer;
    }
}