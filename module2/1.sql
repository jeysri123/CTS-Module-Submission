-- Exercise 1: User Upcoming Events
-- Show a list of all upcoming events a user is registered for in their city, sorted by date.

SELECT
    u.full_name,
    e.title AS event_title,
    e.description,
    e.start_date,
    e.end_date,
    e.city
FROM
    Users u
JOIN
    Registrations r ON u.user_id = r.user_id
JOIN
    Events e ON r.event_id = e.event_id
WHERE
    u.user_id = 39
    AND e.status = 'upcoming'
    AND e.city = u.city
    AND e.start_date > CURRENT_DATE() -- Only show upcoming events in the future
ORDER BY
    e.start_date ASC;

-- Sample Results (replace with actual query results):
-- full_name     | event_title          | description                     | start_date          | end_date            | city
-- ------------- | -------------------- | ------------------------------- | ------------------- | ------------------- | ----------
-- Alice Johnson | Tech Innovators Meetup | A meetup for tech enthusiasts.  | 2025-06-10 10:00:00 | 2025-06-10 16:00:00 | New York
-- ... add more results based on your data and chosen user_id