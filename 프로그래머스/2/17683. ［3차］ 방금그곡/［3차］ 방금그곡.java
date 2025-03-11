import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int maxTime = 0;
        HashMap<String, String> map = new HashMap<>();
        map.put("C#", "c");
        map.put("D#", "d");
        map.put("F#", "f");
        map.put("G#", "g");
        map.put("A#", "a");
        map.put("B#", "b");
        map.put("E#", "e");
        m = removePoint(map, m);
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] musicInfo = musicinfos[i].split(",");
            int time = getTime(musicInfo[0], musicInfo[1]);
            
            String convertedMusic = removePoint(map, musicInfo[3]);
            String playedMusic = getMusic(time, convertedMusic);
            
            if(playedMusic.contains(m)){
                if(time > maxTime){
                    maxTime = time;
                    answer = musicInfo[2];
                }
            }
        }
        
        
        return answer;
    }
    public String removePoint(HashMap<String, String> map, String music){
        String[] keys = {"C#", "D#", "F#", "G#", "A#", "B#", "E#"};
        for(String key : keys){
            music = music.replace(key, map.get(key));
        }
        
        return music;
    }
    
    public int getTime(String start, String end){
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        
        return (Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1])) 
                - (Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]));
    }
    
    public String getMusic(int time, String note){
        StringBuilder temp = new StringBuilder();
        for(int i=0; i < time; i++)
            temp.append(note.charAt(i % note.length()));
        return temp.toString();
    }
}