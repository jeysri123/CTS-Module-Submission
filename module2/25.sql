-- Exercise 25: Events Without Sessions
-- List all events that currently have no sessions scheduled under them.

SELECT
    e.title
FROM
    Events e
LEFT JOIN
    Sessions s ON e.event_id = s.event_id
WHERE
    s.session_id IS NULL;

-- Sample Results (replace with actual query results if any events have no sessions):
-- title
-- ---------
-- ...
