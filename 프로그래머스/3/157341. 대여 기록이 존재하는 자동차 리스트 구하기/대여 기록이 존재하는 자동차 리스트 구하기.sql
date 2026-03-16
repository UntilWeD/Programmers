-- 코드를 입력하세요
SELECT      T1.CAR_ID
FROM        CAR_RENTAL_COMPANY_CAR            T1
           ,CAR_RENTAL_COMPANY_RENTAL_HISTORY T2
 WHERE      T1.CAR_ID                     = T2.CAR_ID
   AND      T1.CAR_TYPE                   = '세단'
   AND      TO_CHAR(T2.START_DATE, 'MM')  = '10'
GROUP BY    T1.CAR_ID
ORDER BY    T1.CAR_ID DESC
;