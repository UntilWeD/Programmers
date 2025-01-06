class Solution {
    public int solution(int n) {
        int sum = 0;
        
        String binary = Integer.toBinaryString(n);
        binary = binary.replace("0", "");
        sum = binary.length();
        
        while(true){
            String temp = Integer.toBinaryString(++n);
            temp = temp.replace("0", "");
            if(sum == temp.length())
                break;
        }
        
        return n;
    }
}