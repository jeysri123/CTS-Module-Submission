-- Exercise 21: Top Feedback Providers
-- List top 5 users who have submitted the most feedback entries.

SELECT
    u.full_name,
    COUNT(f.feedback_id) AS feedback_count
FROM
    Users u
JOIN
    Feedback f ON u.user_id = f.user_id
GROUP BY
    u.user_id, u.full_name
ORDER BY
    feedback_count DESC
LIMIT 5;

-- Sample Results (replace with actual query results):
-- full_name   | feedback_count
-- ----------- | --------------
-- Bob Smith   | 1
-- Charlie Lee | 1
-- Diana King  | 1
-- ... (adjust based on your data if users have more feedback entries)
