class Solution {
    public int solution(int n) {
        int n1 = 2;
        int n2 = 1;
        
        if(n == 1) return n1;
        if(n == 2) return n2;
        
        
        for(int i = 3 ; i <= n; i++){
            int current = (n1+n2) %1000000007;
            n2 = n1;
            n1 = current;
        }
        
        return n1;
    }
    
}