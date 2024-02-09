class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        int generalAnt = hp/5;
        hp %= 5;
        int soldierAnt = hp/3;
        hp %= 3;
        int workerAnt =  hp/1;
        
    
        
        
        
        
        return generalAnt+soldierAnt+workerAnt;
    }
}