class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(bill[0] > wallet[0] || bill[1] > wallet[1]){
            // 90도 돌렸을 경우
            if(bill[0] <= wallet[1] && bill[1] <= wallet[0])
                break;
            
            if(bill[0] > bill[1]){
                bill[0] = bill[0]/2;
                answer++;
            } else{
                bill[1] = bill[1]/2;
                answer++;
            }
            
        }
        
        return answer;
    }
}