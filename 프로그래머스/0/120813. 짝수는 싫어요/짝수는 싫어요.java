class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(int)(Math.ceil(n/2.0))];
        int i = 0;
        int j = 1;
        
        while(true){
            if( j % 2 != 0){
                answer[i++] = j;
            }
            if(j == n){
                break;
            }
            j++;
        }
        
        return answer;
    }
}