class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i=0;
        int j=0;
        int k=0;
        while(k < goal.length){
            if(goal[k].equals(cards1[i])){
                i++;
                k++;
                if(i >= cards1.length){
                    i--;
                }
            } else if(goal[k].equals(cards2[j])){
                j++;
                k++;
                if(j >= cards2.length){
                    j--;
                }
            } else{
                return "No";
            }
        }
        
        return "Yes";
    }
}