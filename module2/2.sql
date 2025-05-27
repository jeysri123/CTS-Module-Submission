-- Exercise 2: Top Rated Events
-- Identify events with the highest average rating, considering only those that have received at least 10 feedback submissions.

SELECT
    e.title,
    AVG(f.rating) AS average_rating
FROM
    Events e
JOIN
    Feedback f ON e.event_id = f.event_id
GROUP BY
    e.event_id, e.title
HAVING
    COUNT(f.feedback_id) >= 10 -- Filter for events with at least 10 feedback submissions
ORDER BY
    average_rating DESC;

-- Sample Results (replace with actual query results):
-- title                 | average_rating
-- --------------------- | --------------
-- Event Title Example 1 | 4.8
-- Event Title Example 2 | 4.5
-- ...

-- Exercise 3: Inactive Users
-- Retrieve users who have not registered for any events in the last 90 days.

SELECT
    u.user_id,
    u.full_name,
    u.email
FROM
    Users u
LEFT JOIN
    Registrations r ON u.user_id = r.user_id
WHERE
    u.user_id NOT IN (
        SELECT user_id
        FROM Registrations
        WHERE registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 90 DAY)
    );

-- Sample Results (replace with actual query results):
-- user_id | full_name    | email
-- -------- | ------------ | -------------------
-- 6        | User Six     | user6@example.com
-- 7        | User Seven   | user7@example.com
-- ...