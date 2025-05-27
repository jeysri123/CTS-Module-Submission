-- Exercise 19: Completed Events with Feedback Summary
-- For completed events, show total registrations and average feedback rating.

SELECT
    e.title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    AVG(f.rating) AS average_feedback_rating
FROM
    Events e
LEFT JOIN
    Registrations r ON e.event_id = r.event_id
LEFT JOIN
    Feedback f ON e.event_id = f.event_id
WHERE
    e.status = 'completed'
GROUP BY
    e.event_id, e.title;

-- Sample Results (replace with actual query results):
-- title              | total_registrations | average_feedback_rating
-- ------------------ | ------------------- | -------------------------
-- AI & ML Conference | 2                   | 4.5
-- ...
