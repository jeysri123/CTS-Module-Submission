-- Exercise 11: Daily New User Count
-- Find the number of users who registered each day in the last 7 days.

SELECT
    registration_date,
    COUNT(user_id) AS new_user_count
FROM
    Users
WHERE
    registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 7 DAY)
GROUP BY
    registration_date
ORDER BY
    registration_date ASC;

-- Sample Results (replace with actual query results):
-- registration_date | new_user_count
-- ----------------- | --------------
-- 2025-05-20        | 3
-- 2025-05-21        | 1
-- ...
