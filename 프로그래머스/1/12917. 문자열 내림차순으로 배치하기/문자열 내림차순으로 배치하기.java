class Solution {
    public String solution(String s) {
        String answer = "";
        int[] intArray = new int[s.length()];
        int temp = 0;
        
        for(int i=0; i<s.length(); i++){
            intArray[i] = (int)s.charAt(i);
        }
        
        for(int i=0; i<intArray.length; i++){
            for(int j=i; j < intArray.length; j++){
                if(intArray[i] < intArray[j]){
                    temp = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = temp;
                }
            }
        }
        
        for(int i=0; i<s.length(); i++){
            answer += (char)intArray[i];
        }
        
        return answer;
    }
}