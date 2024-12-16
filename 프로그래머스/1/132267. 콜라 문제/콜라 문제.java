class Solution {
    public int solution(int a, int b, int n) {
        Cola cola = new Cola();
        
        return cola.getColaBottle(a,b,n);
    }
}

class Cola {
    
    public int getColaBottle(int need, int reward, int empty){
        if(empty >= need){
            return getColaBottle(need, reward,((empty / need)*reward) + (empty % need)) + ((empty / need)*reward);
        } else{
            return 0;
        }

            
    }
}
        
        

