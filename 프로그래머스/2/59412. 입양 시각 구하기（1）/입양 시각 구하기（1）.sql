-- 1) 우선 HOUR부터 현재 존재하는 시간별로 나누기 
SELECT      T2.HOUR
           ,COUNT(1)
FROM        ANIMAL_OUTS T1,
            -- 현재 존재하는 시간별 시간대를 구한다.        
            (
                SELECT DISTINCT  TO_NUMBER(TO_CHAR(DATETIME, 'HH24')) AS HOUR
                  FROM ANIMAL_OUTS
                 WHERE TO_CHAR(DATETIME, 'HH24') BETWEEN '09' AND '19' -- 09 ~ 19 사이 
            ) T2
WHERE       TO_CHAR(T1.DATETIME, 'HH24') = T2.HOUR 
GROUP BY    T2.HOUR
ORDER BY    T2.HOUR ASC
;


