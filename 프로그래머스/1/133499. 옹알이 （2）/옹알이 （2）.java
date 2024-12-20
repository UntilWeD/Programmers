class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] array = {"aya", "ye", "woo", "ma"};

        
        for(int i=0; i< babbling.length; i++){
            String temp = babbling[i];
            for(int j=0; j<array.length; j++){
                if(babbling[i].indexOf(array[j]+array[j]) != -1)
                    break;
                if(babbling[i].indexOf(array[j]) != -1){
                    temp = temp.replace(array[j], " ");
                }
            }
            
            if(temp.trim().equals(""))
                answer++;
        }
        
        return answer;
    }
}