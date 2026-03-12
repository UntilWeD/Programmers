-- 코드를 입력하세요
SELECT       T1.TITLE    
            ,T1.BOARD_ID  
            ,T2.REPLY_ID  
            ,T2.WRITER_ID 
            ,T2.CONTENTS  
            ,TO_CHAR(T2.CREATED_DATE, 'YYYY-MM-DD')
  FROM       USED_GOODS_BOARD T1
            ,USED_GOODS_REPLY T2
 WHERE       T1.BOARD_ID = T2.BOARD_ID
   AND       TO_CHAR(T1.CREATED_DATE, 'YYYYMM') = '202210'
ORDER BY     T2.CREATED_DATE ASC
            ,T1.TITLE        ASC
;