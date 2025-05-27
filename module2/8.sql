-- Exercise 8: Sessions per Upcoming Event
-- Display all upcoming events with the count of sessions scheduled for them.

SELECT
    e.title,
    COUNT(s.session_id) AS session_count
FROM
    Events e
LEFT JOIN
    Sessions s ON e.event_id = s.event_id
WHERE
    e.status = 'upcoming'
GROUP BY
    e.event_id, e.title
ORDER BY
    session_count DESC;

-- Sample Results (replace with actual query results):
-- title                   | session_count
-- ----------------------- | -------------
-- Tech Innovators Meetup    | 2
-- Frontend Development...   | 1
-- ...
