-- 코드를 입력하세요
-- 각각의 카테고리마다 최고의 가격을 가진 상품을 찾아야함 -> 가격이 '키'가 될 수 있는가?
SELECT  CATEGORY
       ,PRICE        AS MAX_PRICE
       ,PRODUCT_NAME
  FROM  FOOD_PRODUCT 
 WHERE  PRICE IN        (
                            SELECT       MAX(PRICE)
                              FROM       FOOD_PRODUCT
                            GROUP BY     CATEGORY
                        )
   AND  CATEGORY IN ('과자', '국', '김치', '식용유')                     
ORDER BY    MAX_PRICE   DESC
;