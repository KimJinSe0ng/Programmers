WITH MAX_PRICE_INFO AS (
    SELECT
        CATEGORY,
        MAX(PRICE) AS MAX_PRICE
    FROM
        FOOD_PRODUCT
    WHERE
        CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY
        CATEGORY
)

SELECT
    FP.CATEGORY,
    FP.PRICE,
    FP.PRODUCT_NAME
FROM
    FOOD_PRODUCT FP
JOIN
    MAX_PRICE_INFO MPI ON FP.CATEGORY = MPI.CATEGORY
AND
    FP.PRICE = MPI.MAX_PRICE
ORDER BY
    FP.PRICE DESC;
