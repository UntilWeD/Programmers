-- 코드를 입력하세요
-- 대여중이 나오면 안됨
SELECT      T1.CAR_ID
           ,CASE WHEN   T2.CAN_RENT IS NULL THEN    '대여 가능'
                 ELSE   '대여중'
            END  AS     AVAILABILITY
  FROM      (
                SELECT      CAR_ID
                  FROM      CAR_RENTAL_COMPANY_RENTAL_HISTORY 
              GROUP BY      CAR_ID
            ) T1
           ,(
                SELECT      CAR_ID AS CAN_RENT
                  FROM      CAR_RENTAL_COMPANY_RENTAL_HISTORY
                 WHERE      TO_DATE('2022-10-16', 'YYYY-MM-DD') BETWEEN START_DATE AND END_DATE
            ) T2
 WHERE      T1.CAR_ID   =   T2.CAN_RENT(+)
ORDER BY    T1.CAR_ID   DESC
;