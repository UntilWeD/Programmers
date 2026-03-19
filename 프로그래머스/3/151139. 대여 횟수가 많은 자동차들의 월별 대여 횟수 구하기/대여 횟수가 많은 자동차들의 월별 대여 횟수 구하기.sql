-- 코드를 입력하세요
-- 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회이상인 자동차ID
-- 의 '8, 9월 달의 ' '총 대여 횟수' (RECORDS)
-- 1) 월 오름차순
-- 2) 자동차 ID 내림차순
-- !!특정 월의 총 대여횟수가 0인 경우에는 제외!!

-- 대여 기준
-- 1. 시작날짜가 저 기간 안에 무조건 들어가 있어야 한다
SELECT      EXTRACT(MONTH FROM START_DATE)     AS MONTH
           ,CAR_ID
           ,COUNT(1)   AS RECORDS
  FROM      CAR_RENTAL_COMPANY_RENTAL_HISTORY
 WHERE      START_DATE >= TO_DATE('2022-08-01', 'YYYY-MM-DD')
   AND      START_DATE <  TO_DATE('2022-11-01', 'YYYY-MM-DD')
   AND      CAR_ID  IN (
                            SELECT      CAR_ID
                              FROM      CAR_RENTAL_COMPANY_RENTAL_HISTORY
                             WHERE      START_DATE >= TO_DATE('2022-08-01', 'YYYY-MM-DD') 
                               AND      START_DATE <  TO_DATE('2022-11-01', 'YYYY-MM-DD')
                          GROUP BY      CAR_ID
                            HAVING    COUNT(1) >= 5
                       )   
GROUP BY    EXTRACT(MONTH FROM START_DATE), CAR_ID
ORDER BY    MONTH ASC,  CAR_ID DESC
;
                    
                    
                    
                    