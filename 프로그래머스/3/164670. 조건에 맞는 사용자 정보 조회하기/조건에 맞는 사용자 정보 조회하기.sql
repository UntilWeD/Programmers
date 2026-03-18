-- 코드를 입력하세요
SELECT      T2.USER_ID
           ,T2.NICKNAME
           ,T2.CITY || ' ' || T2.STREET_ADDRESS1 || ' ' || T2.STREET_ADDRESS2 AS 전체주소
           ,REGEXP_REPLACE(TLNO, '([0-9]{3})([0-9]{4})([0-9]{4})', '\1-\2-\3')
FROM        (
                SELECT      WRITER_ID
                           ,COUNT(1)    AS  POST_COUNT
                  FROM      USED_GOODS_BOARD   
                GROUP BY    WRITER_ID
            )   T1
           ,USED_GOODS_USER T2
WHERE       T1.WRITER_ID    =    T2.USER_ID 
  AND       T1.POST_COUNT   >    2
ORDER BY    T2.USER_ID  DESC
;