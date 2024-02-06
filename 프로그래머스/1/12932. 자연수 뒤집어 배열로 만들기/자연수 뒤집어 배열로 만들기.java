class Solution {
    public int[] solution(long n) {
        String Sanswer = String.valueOf(n);
        int[] answer = new int[Sanswer.length()];
        int j=0;
        
        for(int i=0; i<Sanswer.length(); i++){
            answer[Sanswer.length()-1-i] = Character.getNumericValue(Sanswer.charAt(i));
        }
        
        return answer;
    }
}