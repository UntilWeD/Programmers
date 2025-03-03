import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        // 예약을 시작 시간 기준으로 정렬하기
        Arrays.sort(book_time, (a, b) -> {
            String[] timeA = a[0].split(":");
            String[] timeB = b[0].split(":");
            int startA = Integer.parseInt(timeA[0]) * 60 + Integer.parseInt(timeA[1]);
            int startB = Integer.parseInt(timeB[0]) * 60 + Integer.parseInt(timeB[1]);
            return startA - startB;
        });
        
        List<Room> rooms = new ArrayList<>();
        
        for(int i=0; i < book_time.length; i++){
            // 시간 분리
            String[] temp1 = book_time[i][0].split(":");
            String[] temp2 = book_time[i][1].split(":");
            
            // 시간량 변환
            int start = Integer.parseInt(temp1[0]) * 60 + Integer.parseInt(temp1[1]);
            int end = Integer.parseInt(temp2[0]) * 60 + Integer.parseInt(temp2[1])+10;
            
            boolean booked = false;
            
            // 시간대가 가능한 객실 중 가장 먼저 찾은 객실에 예약
            for(Room room : rooms){
                if(room.canBook(start, end)){
                    room.bookRoom(start, end);
                    booked = true;
                    break;
                }
            }
            
            // 가능한 객실이 없으면 새 객실 추가
            if(!booked){
                Room room = new Room();
                room.bookRoom(start, end);
                rooms.add(room);
            }
        }
        return rooms.size();
    }
}

class Room{
    // 해당 객실의 모든 예약 시간을 저장 (시작 시간, 종료 시간+청소)
    List<int[]> reservations = new ArrayList<>();
    
    // 예약가능한지 확인
    public boolean canBook(int start, int end){
        
        for(int[] reservation : reservations){
            // 새 예약이 기존 예약과 겹치면 예약 불가
            if(start < reservation[1] && end > reservation[0]){
                return false;
            }
        }
        return true;
    }
    
    // 예약
    public void bookRoom(int start, int end){
        reservations.add(new int[]{start, end});
        
        // 시작 시간 기준으로 정렬
        Collections.sort(reservations, Comparator.comparingInt(a -> a[0]));
    }
}