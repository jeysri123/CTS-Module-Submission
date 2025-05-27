-- Exercise 17: Multi-Session Speakers
-- Identify speakers who are handling more than one session across all events.

SELECT
    speaker_name,
    COUNT(session_id) AS total_sessions
FROM
    Sessions
GROUP BY
    speaker_name
HAVING
    COUNT(session_id) > 1;

-- Sample Results (replace with actual query results):
-- speaker_name   | total_sessions
-- -------------- | --------------
-- Alice Johnson  | 1  (Based on sample data, no speakers have more than 1 session)
-- Bob Smith      | 1
-- Charlie Lee    | 1
-- Dr. Tech       | 1
-- ... (adjust based on your actual data if there are speakers with multiple sessions)
