-- 코드를 입력하세요
-- 기간 = 보호시작일 - 입양일
SELECT      ANIMAL_ID
           ,NAME
FROM        (
                SELECT      T1.ANIMAL_ID
                           ,T2.NAME
                           ,(T2.DATETIME - T1.DATETIME) AS PERIOD
                  FROM      ANIMAL_INS  T1
                           ,ANIMAL_OUTS T2
                 WHERE      T1.ANIMAL_ID    =   T2.ANIMAL_ID
                ORDER   BY  PERIOD DESC
            )
WHERE   ROWNUM <= 2
;
  