-- Exercise 13: Average Rating per City
-- Calculate the average feedback rating of events conducted in each city.

SELECT
    e.city,
    AVG(f.rating) AS average_rating
FROM
    Events e
JOIN
    Feedback f ON e.event_id = f.event_id
GROUP BY
    e.city
ORDER BY
    average_rating DESC;

-- Sample Results (replace with actual query results):
-- city    | average_rating
-- --------- | --------------
-- Chicago | 4.5
-- ...
