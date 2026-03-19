-- 코드를 입력하세요
-- 조회수가 가장 높은 중고거래 게시물
-- 파일 경로 필요 컬럼 조회
-- 완성
SELECT   ('/home/grep/src/' || T2.BOARD_ID || '/' || T2.FILE_ID || T2.FILE_NAME || T2.FILE_EXT ) 
            AS FILE_PATH
  FROM   USED_GOODS_BOARD   T1
        ,USED_GOODS_FILE    T2
 WHERE   T1.VIEWS =  (
                          SELECT      MAX(T1.VIEWS)
                            FROM      USED_GOODS_BOARD T1
                     ) 
   AND   T1.BOARD_ID    =   T2.BOARD_ID
ORDER BY T2.FILE_ID DESC
;