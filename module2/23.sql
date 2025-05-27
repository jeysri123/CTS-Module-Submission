-- Exercise 23: Registration Trends
-- Show a month-wise registration count trend over the past 12 months.

SELECT
    DATE_FORMAT(registration_date, '%Y-%m') AS registration_month,
    COUNT(registration_id) AS monthly_registrations
FROM
    Registrations
WHERE
    registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 12 MONTH)
GROUP BY
    registration_month
ORDER BY
    registration_month ASC;

-- Sample Results (replace with actual query results):
-- registration_month | monthly_registrations
-- ------------------ | ---------------------
-- 2024-12            | 3
-- 2025-01            | 1
-- 2025-02            | 1
-- 2025-04            | 2
-- 2025-05            | 2
-- 2025-06            | 1
-- ...
