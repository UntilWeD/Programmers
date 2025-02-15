class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i < numbers.length; i++){
            
            long num = numbers[i];
            
            // 짝수일 경우:num + 1
            if(num%2 == 0){
                answer[i] = num+1;
            } else {
                // 홀수일 경우: 가장 낮은 0을 1로, 그 오른쪽 비트를 조정
                long lowestZero = (~num) & (num + 1); // 가장 낮은 0의 위치
                answer[i] = num + lowestZero - (lowestZero >> 1);
            }
            
        }
        
        return answer;
    }
}