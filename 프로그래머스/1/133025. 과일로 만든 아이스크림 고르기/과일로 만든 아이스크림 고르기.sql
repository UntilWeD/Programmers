-- 코드를 입력하세요
SELECT      T1.FLAVOR
  FROM      FIRST_HALF     T1
           ,ICECREAM_INFO  T2
 WHERE      T1.FLAVOR = T2.FLAVOR
   AND      T1.TOTAL_ORDER > 3000
   AND      T2.INGREDIENT_TYPE = 'fruit_based'
ORDER BY    T1.TOTAL_ORDER DESC
;
            