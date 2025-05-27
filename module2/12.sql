-- Exercise 12: Event with Maximum Sessions
-- List the event(s) with the highest number of sessions.

SELECT
    e.title,
    COUNT(s.session_id) AS session_count
FROM
    Events e
LEFT JOIN
    Sessions s ON e.event_id = s.event_id
GROUP BY
    e.event_id, e.title
ORDER BY
    session_count DESC
LIMIT 1; -- To get only the top event. Use RANK() or DENSE_RANK() for ties if needed in a more complex scenario.

-- Sample Results (replace with actual query results):
-- title                 | session_count
-- --------------------- | -------------
-- Tech Innovators Meetup  | 2
