-- Exercise 16: Unregistered Active Users
-- Find users who created an account in the last 30 days but haven't registered for any events.

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.registration_date
FROM
    Users u
LEFT JOIN
    Registrations r ON u.user_id = r.user_id
WHERE
    u.registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 30 DAY)
    AND r.registration_id IS NULL;

-- Sample Results (replace with actual query results):
-- user_id | full_name  | email               | registration_date
-- -------- | ---------- | ------------------- | -----------------
-- 8        | User Eight | user8@example.com   | 2025-05-25
-- ...
