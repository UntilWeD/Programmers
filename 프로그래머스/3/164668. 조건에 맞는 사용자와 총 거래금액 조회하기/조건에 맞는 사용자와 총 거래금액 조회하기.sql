-- 코드를 입력하세요
-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID
-- 판매 상태가 '완료'인 게시글의 ID
SELECT      T2.USER_ID
           ,T2.NICKNAME
           ,SUM(T1.PRICE) AS TOTAL_SALES
  FROM      USED_GOODS_BOARD  T1
           ,USED_GOODS_USER   T2
 WHERE      T1.STATUS    =  'DONE'
   AND      T1.WRITER_ID =  T2.USER_ID
GROUP BY    USER_ID, NICKNAME
 HAVING     SUM(T1.PRICE) >= 700000
ORDER BY    TOTAL_SALES ASC
;