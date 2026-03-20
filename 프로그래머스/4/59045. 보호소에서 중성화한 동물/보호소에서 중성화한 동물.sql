-- ANIMAL_INS 테이블에서는 중성화여부(SEX_UPON_INTAKE)가 
-- 암컷의 경우 Intact Female, 수컷의 경우 Intact Male 이였다가
-- ANIMAL_OUTS 테이블에서는 중성화여부(SEX_UPON_OUTCOME)가 
-- 암컷의 경우 Spayed Female, 수컷의 경우 Neutered Male 이어야 함
SELECT                  T1.ANIMAL_ID
                       ,T1.ANIMAL_TYPE
                       ,T1.NAME
  FROM  (
            SELECT      ANIMAL_ID
                       ,ANIMAL_TYPE
                       ,NAME
              FROM      ANIMAL_INS
             WHERE      SEX_UPON_INTAKE    IN  ('Intact Female', 'Intact Male')
        ) T1
       ,(
            SELECT      ANIMAL_ID
                       ,ANIMAL_TYPE
                       ,NAME
              FROM      ANIMAL_OUTS
             WHERE      SEX_UPON_OUTCOME    IN  ('Spayed Female', 'Neutered Male')
        ) T2
 WHERE    T1.ANIMAL_ID = T2.ANIMAL_ID
ORDER BY  T1.ANIMAL_ID
;