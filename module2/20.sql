-- Exercise 20: User Engagement Index
-- For each user, calculate how many events they attended and how many feedbacks they submitted.

SELECT
    u.full_name,
    COUNT(DISTINCT r.event_id) AS events_registered_for,
    COUNT(DISTINCT f.feedback_id) AS feedback_submitted
FROM
    Users u
LEFT JOIN
    Registrations r ON u.user_id = r.user_id
LEFT JOIN
    Feedback f ON u.user_id = f.user_id
GROUP BY
    u.user_id, u.full_name
ORDER BY
    events_registered_for DESC, feedback_submitted DESC;

-- Sample Results (replace with actual query results):
-- full_name     | events_registered_for | feedback_submitted
-- ------------- | --------------------- | ------------------
-- Alice Johnson | 1                     | 0
-- Bob Smith     | 1                     | 1
-- Charlie Lee   | 1                     | 1
-- Diana King    | 1                     | 1
-- Ethan Hunt    | 1                     | 0
-- ...
