-- 코드를 입력하세요
-- 음식종류별로
-- 즐겨찾기수가 가장 많은
-- 1) 우선 음식종류별 가장 좋아요 수가 많은 행데이터 선택
SELECT  FOOD_TYPE
       ,REST_ID
       ,REST_NAME
       ,FAVORITES
FROM    REST_INFO 
WHERE  (FOOD_TYPE,FAVORITES)   IN   (
                                        SELECT       FOOD_TYPE
                                                    ,MAX(FAVORITES)
                                          FROM       REST_INFO
                                        GROUP BY     FOOD_TYPE
                                    ) 
ORDER BY    FOOD_TYPE   DESC