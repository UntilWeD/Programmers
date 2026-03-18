-- 코드를 입력하세요
SELECT  ANIMAL_ID, NAME
FROM    (
            SELECT      T2.ANIMAL_ID
                       ,T2.NAME
              FROM      ANIMAL_INS  T1
                       ,ANIMAL_OUTS T2
             WHERE      T1.ANIMAL_ID(+)    =   T2.ANIMAL_ID
               AND      T1.ANIMAL_ID IS NULL
        )
ORDER BY    ANIMAL_ID