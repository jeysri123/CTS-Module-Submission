-- Exercise 10: Feedback Gap
-- Identify events that had registrations but received no feedback at all.

SELECT
    e.title
FROM
    Events e
JOIN
    Registrations r ON e.event_id = r.event_id
LEFT JOIN
    Feedback f ON e.event_id = f.event_id
WHERE
    f.feedback_id IS NULL
GROUP BY
    e.event_id, e.title;

-- Sample Results (replace with actual query results):
-- title
-- -----------------------
-- Frontend Development...
-- ...
