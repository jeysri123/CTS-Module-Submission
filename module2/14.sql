-- Exercise 14: Most Registered Events
-- List top 3 events based on the total number of user registrations.

SELECT
    e.title,
    COUNT(r.registration_id) AS registration_count
FROM
    Events e
JOIN
    Registrations r ON e.event_id = r.event_id
GROUP BY
    e.event_id, e.title
ORDER BY
    registration_count DESC
LIMIT 3;

-- Sample Results (replace with actual query results):
-- title                 | registration_count
-- --------------------- | ------------------
-- Tech Innovators Meetup  | 2
-- AI & ML Conference    | 2
-- Frontend Development... | 1
