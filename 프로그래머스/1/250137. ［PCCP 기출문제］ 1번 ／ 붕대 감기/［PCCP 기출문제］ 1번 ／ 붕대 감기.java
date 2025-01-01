class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int bonus_time = 0;
        int pre_time = 0;
        int max_health = health;
        
        for(int i=0; i<attacks.length; i++){
            int time = attacks[i][0] - pre_time- 1;
            
            bonus_time = time;
            health += time * bandage[1] + ((time / bandage[0]) * bandage[2]);
            if(health >= max_health)
                health=max_health;
            
            health -= attacks[i][1];
            
            if(health <= 0)
                return -1;
            pre_time =  attacks[i][0];
            bonus_time = 0;
        }
        
        
        return health;
    }
    
    
}