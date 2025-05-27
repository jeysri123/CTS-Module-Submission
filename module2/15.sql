-- Exercise 15: Event Session Time Conflict
-- Identify overlapping sessions within the same event (i.e., session start and end times that conflict).

SELECT
    e.title AS event_title,
    s1.title AS session1_title,
    s1.start_time AS session1_start,
    s1.end_time AS session1_end,
    s2.title AS session2_title,
    s2.start_time AS session2_start,
    s2.end_time AS session2_end
FROM
    Events e
JOIN
    Sessions s1 ON e.event_id = s1.event_id
JOIN
    Sessions s2 ON e.event_id = s2.event_id
WHERE
    s1.session_id < s2.session_id -- Avoid comparing a session with itself and duplicate pairs
    AND (
        (s1.start_time BETWEEN s2.start_time AND s2.end_time)
        OR (s1.end_time BETWEEN s2.start_time AND s2.end_time)
        OR (s2.start_time BETWEEN s1.start_time AND s1.end_time)
        OR (s2.end_time BETWEEN s1.start_time AND s1.end_time)
    );

-- Sample Results (replace with actual query results if conflicts exist):
-- event_title | session1_title | session1_start | session1_end | session2_title | session2_start | session2_end
-- ----------- | -------------- | -------------- | ------------ | -------------- | -------------- | ------------
-- ...
