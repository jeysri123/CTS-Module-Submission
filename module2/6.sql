-- Exercise 6: Event Resource Summary
-- Generate a report showing the number of resources (PDFs, images, links) uploaded for each event.

SELECT
    e.title,
    COUNT(r.resource_id) AS total_resources,
    COUNT(CASE WHEN r.resource_type = 'pdf' THEN r.resource_id END) AS pdf_resources,
    COUNT(CASE WHEN r.resource_type = 'image' THEN r.resource_id END) AS image_resources,
    COUNT(CASE WHEN r.resource_type = 'link' THEN r.resource_id END) AS link_resources
FROM
    Events e
LEFT JOIN
    Resources r ON e.event_id = r.event_id
GROUP BY
    e.event_id, e.title
ORDER BY
    total_resources DESC;

-- Sample Results (replace with actual query results):
-- title                 | total_resources | pdf_resources | image_resources | link_resources
-- --------------------- | --------------- | ------------- | --------------- | --------------
-- Tech Innovators Meetup  | 1               | 1             | 0               | 0
-- AI & ML Conference    | 1               | 0             | 1               | 0
-- Frontend Development... | 1               | 0             | 0               | 1
-- ...
