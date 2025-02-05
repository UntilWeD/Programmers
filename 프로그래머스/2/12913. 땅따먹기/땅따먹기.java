class Solution {
    int solution(int[][] land) {
        int[] arr = land[0].clone();
        
      
        // 현재 행
        for(int i=1; i < land.length; i++){
            int[] temp = new int[arr.length];
            // 이전 행까지의 최대 값, j 열로 순환
            for(int j = 0; j < arr.length; j++){
                int max = 0;
                for(int k = 0 ; k < 4; k++){
                    if(k==j) continue;
                    max = Math.max(max, arr[k]);
                }
                temp[j] = land[i][j] + max;
            }
            arr = temp;
        }
        
        int answer = 0;
        for(int sum : arr){
            answer = Math.max(sum, answer);
        }

        return answer;
    }
}