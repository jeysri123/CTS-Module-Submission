-- Exercise 5: Most Active Cities
-- List the top 5 cities with the highest number of distinct user registrations.

SELECT
    u.city,
    COUNT(DISTINCT r.user_id) AS distinct_registrations
FROM
    Users u
JOIN
    Registrations r ON u.user_id = r.user_id
GROUP BY
    u.city
ORDER BY
    distinct_registrations DESC
LIMIT 5;

-- Sample Results (replace with actual query results):
-- city        | distinct_registrations
-- ----------- | ----------------------
-- New York    | 2
-- Los Angeles | 2
-- Chicago     | 1
-- ...
