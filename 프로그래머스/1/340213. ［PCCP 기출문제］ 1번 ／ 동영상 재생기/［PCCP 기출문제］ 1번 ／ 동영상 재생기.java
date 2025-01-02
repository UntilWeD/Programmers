class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] time = {Integer.parseInt(pos.substring(0,2)), Integer.parseInt(pos.substring(3))};
        int[] op_start_time = {Integer.parseInt(op_start.substring(0,2)), Integer.parseInt(op_start.substring(3))};
        int[] op_end_time = {Integer.parseInt(op_end.substring(0,2)), Integer.parseInt(op_end.substring(3))};
        int[] video_len_time = {Integer.parseInt(video_len.substring(0,2)), Integer.parseInt(video_len.substring(3))};
        
        check_op(op_start_time, op_end_time, time);
        for(int i=0; i<commands.length; i++){
            if(commands[i].equals("next")){
                time[1] += 10;
            } else{
                time[1] -= 10;
            }
            getTime(video_len_time, time);
            check_op(op_start_time, op_end_time, time);
        }
        
        String answer = (time[0] < 10 ? "0"+time[0] : "" + time[0]) +":";
        answer += time[1] < 10 ? "0"+time[1] : "" + time[1];
        return answer;
    }
    
    
    // 오프닝 체크
    public void check_op(int[] op_start_time, int[] op_end_time, int[] time){
        if( time[0] < op_end_time[0] || (time[0] == op_end_time[0] && time[1] <= op_end_time[1])){
            if(time[0] > op_start_time[0] || (time[0] == op_start_time[0] && time[1] >= op_start_time[1])){
                time[0] = op_end_time[0];
                time[1] = op_end_time[1];
            }
        }
    }
    
    // 시간 계산
    public void getTime(int[] video_len_time,int[] time){
        // 초 연산
        if(time[1] >= 60){
            time[0]++;
            time[1] = time[1]%60;
        } else if(time[1] < 0){
            //만약 분이 0분이라면
            if(time[0] <=0){
                time[1] = 0;
            } else{
                time[0]--;
                time[1] += 60; 
            }
        }
        // 비디오 길이 체크
        if(time[0] > video_len_time[0] || (time[0] == video_len_time[0] && time[1] >= video_len_time[1])){
            time[0] = video_len_time[0];
            time[1] = video_len_time[1];
        }
    }
}