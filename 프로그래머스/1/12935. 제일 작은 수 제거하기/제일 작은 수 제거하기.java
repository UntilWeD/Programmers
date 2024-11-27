class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1){
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];
        
		
        int min = arr[0];
        int k=0;
        
        for(int i=0; i < arr.length; i++){
            min = (min > arr[i] ) ?  arr[i] : min;
        }
        for(int j=0; j < arr.length; j++){
            if(arr[j] == min){
            } else{
            	answer[k] = arr[j];
                k++;
            }
        }
        
        
        return answer;
    }
}