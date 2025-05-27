-- Exercise 24: Average Session Duration per Event
-- Compute the average duration (in minutes) of sessions in each event.

SELECT
    e.title,
    AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS average_session_duration_minutes
FROM
    Events e
JOIN
    Sessions s ON e.event_id = s.event_id
GROUP BY
    e.event_id, e.title
ORDER BY
    average_session_duration_minutes DESC;

-- Sample Results (replace with actual query results):
-- title                   | average_session_duration_minutes
-- ----------------------- | --------------------------------
-- Tech Innovators Meetup    | 75.0000
-- AI & ML Conference      | 90.0000
-- Frontend Development... | 120.0000
-- ...
