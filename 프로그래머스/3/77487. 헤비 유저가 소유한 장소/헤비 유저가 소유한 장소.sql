-- 코드를 입력하세요
-- 아 헤비유저가 아닌 애들만 

SELECT      ID
           ,NAME
           ,HOST_ID
  FROM      PLACES 
 WHERE      HOST_ID IN  (
                            SELECT      HOST_ID
                              FROM      PLACES
                             GROUP BY   HOST_ID
                             HAVING     COUNT(ID) > 1
                        )
ORDER BY    ID