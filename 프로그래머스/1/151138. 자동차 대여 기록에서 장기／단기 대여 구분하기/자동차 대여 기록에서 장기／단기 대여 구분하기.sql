-- 코드를 입력하세요
SELECT      
            HISTORY_ID
           ,CAR_ID
           ,TO_CHAR(START_DATE, 'YYYY-MM-DD')
           ,TO_CHAR(END_DATE,   'YYYY-MM-DD')
           ,CASE WHEN (END_DATE - START_DATE + 1) >= 30 
                 THEN '장기 대여'
                 ELSE '단기 대여'
             END   AS RENT_TYPE
  FROM      CAR_RENTAL_COMPANY_RENTAL_HISTORY 
 WHERE      TO_CHAR(START_DATE, 'YYYYMM') = '202209'
ORDER BY    HISTORY_ID DESC
;