-- Exercise 18: Resource Availability Check
-- List all events that do not have any resources uploaded.

SELECT
    e.title
FROM
    Events e
LEFT JOIN
    Resources r ON e.event_id = r.event_id
WHERE
    r.resource_id IS NULL;

-- Sample Results (replace with actual query results):
-- title
-- ---------
-- ... (If any events have no resources, they will appear here)
