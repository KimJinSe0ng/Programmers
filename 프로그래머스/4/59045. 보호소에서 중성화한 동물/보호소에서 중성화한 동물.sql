-- 중성화를 거치지 않은 동물은 성별 및 중성화 여부에 Intact
-- 중성화를 거친 동물은 Spayed 또는 Neutered라고 표시되어있습니다.
SELECT
    AI.ANIMAL_ID,
    AI.ANIMAL_TYPE,
    AI.NAME
FROM
    ANIMAL_INS AI
JOIN
    ANIMAL_OUTS AO
ON
    AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE
    AI.SEX_UPON_INTAKE LIKE 'Intact%' AND
    (AO.SEX_UPON_OUTCOME LIKE 'Spayed%' OR AO.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY
    AI.ANIMAL_ID;