-- Exercise 9: Organizer Event Summary
-- For each event organizer, show the number of events created and their current status (upcoming, completed, cancelled).

SELECT
    u.full_name AS organizer_name,
    COUNT(e.event_id) AS total_events,
    COUNT(CASE WHEN e.status = 'upcoming' THEN e.event_id END) AS upcoming_events,
    COUNT(CASE WHEN e.status = 'completed' THEN e.event_id END) AS completed_events,
    COUNT(CASE WHEN e.status = 'cancelled' THEN e.event_id END) AS cancelled_events
FROM
    Users u
LEFT JOIN
    Events e ON u.user_id = e.organizer_id
GROUP BY
    u.user_id, u.full_name
ORDER BY
    total_events DESC;

-- Sample Results (replace with actual query results):
-- organizer_name | total_events | upcoming_events | completed_events | cancelled_events
-- -------------- | ------------ | --------------- | ---------------- | ----------------
-- Alice Johnson  | 1            | 1               | 0                | 0
-- Bob Smith      | 1            | 1               | 0                | 0
-- Charlie Lee    | 1            | 0               | 1                | 0
-- Diana King     | 0            | 0               | 0                | 0
-- Ethan Hunt     | 0            | 0               | 0                | 0
