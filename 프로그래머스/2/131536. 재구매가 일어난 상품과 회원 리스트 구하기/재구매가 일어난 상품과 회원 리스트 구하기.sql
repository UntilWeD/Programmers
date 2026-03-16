--  하나의 USER_ID가 동일한 PRODUCT_ID를 가지고 있는 2가지 이상의
--  행데이터를 1가지 행데이터로 조회되게 해야한다.  
SELECT      T1.USER_ID
           ,T1.PRODUCT_ID
  FROM     (
                SELECT      USER_ID
                           ,PRODUCT_ID
                           ,COUNT(1)    AS SUM
                FROM        ONLINE_SALE
                GROUP BY    USER_ID, PRODUCT_ID
           ) T1
 WHERE      SUM > 1
ORDER BY    T1.USER_ID ASC, T1.PRODUCT_ID DESC
;