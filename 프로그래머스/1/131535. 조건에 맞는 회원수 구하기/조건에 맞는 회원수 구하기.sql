-- 코드를 입력하세요
SELECT       SUM(1)
  FROM       USER_INFO 
 WHERE       TO_CHAR(JOINED, 'YYYY')  = '2021'
   AND       AGE BETWEEN 20 AND 29
   AND       AGE IS NOT NULL
;