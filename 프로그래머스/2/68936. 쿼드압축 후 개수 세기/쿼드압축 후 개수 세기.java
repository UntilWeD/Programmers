class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        quadTree(arr, arr.length, 0, 0, answer);
        
        return answer;
    }

    public void quadTree(int[][] arr, int size, int x, int y, int[] answer){
        if(canBeZip(arr, x, y, size)){
            if(arr[x][y] == 0)
                answer[0]++;
            else
                answer[1]++;
            return;
        }
        quadTree(arr, size/2, x, y, answer);
        quadTree(arr, size/2, x, y+size/2, answer);
        quadTree(arr, size/2, x+size/2, y, answer);
        quadTree(arr, size/2, x+size/2, y+size/2, answer);
        return;
    }
    
    public boolean canBeZip(int[][] arr, int x, int y, int size){
        int target = arr[x][y];
        for(int i=x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(arr[i][j] != target){
                    return false;
                }
            }
        }
        return true;
    }
}