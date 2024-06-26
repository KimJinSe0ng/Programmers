SELECT
    DISTINCT CRCC.CAR_ID
FROM
    CAR_RENTAL_COMPANY_CAR CRCC JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH
ON CRCC.CAR_ID = CRCRH.CAR_ID AND CRCC.CAR_TYPE = '세단'
WHERE
    MONTH(START_DATE) = 10
ORDER BY CRCC.CAR_ID DESC;
