-- Exercise 22: Duplicate Registrations Check
-- Detect if a user has been registered more than once for the same event.

SELECT
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM
    Registrations
GROUP BY
    user_id, event_id
HAVING
    COUNT(*) > 1;

-- Sample Results (replace with actual query results if duplicates exist):
-- user_id | event_id | registration_count
-- -------- | -------- | ------------------
-- ...
