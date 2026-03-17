-- 코드를 입력하세요
SELECT T1.*
FROM
            (
                SELECT      A.NAME
                           ,A.DATETIME
                  FROM      ANIMAL_INS      A
                           ,ANIMAL_OUTS     B 

                 WHERE      A.ANIMAL_ID    =   B.ANIMAL_ID(+)
                   AND      B.ANIMAL_ID IS NULL
                ORDER BY    A.DATETIME
            ) T1
WHERE       ROWNUM <= 3
ORDER BY    T1.DATETIME
;