class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[i].length; j++){
                answer[i][j] = matrixMultiplication(arr1, arr2, i, j);
            }
        }
        
        
        
        return answer;
    }
    
    public int matrixMultiplication(int[][] arr1, int[][] arr2, int rows, int cols){
        int sum = 0;
        for(int i=0; i<arr2.length; i++){
            sum += arr1[rows][i] * arr2[i][cols]; 
        }
        return sum;
    }
}