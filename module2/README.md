# Module 2: ANSI SQL Exercises

This module contains SQL exercises for a Community Event Portal database system. The exercises demonstrate various SQL queries and operations using MySQL.

## Database Schema

### 1. Users Table
- `user_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `full_name` (VARCHAR(100), NOT NULL)
- `email` (VARCHAR(100), UNIQUE, NOT NULL)
- `city` (VARCHAR(100), NOT NULL)
- `registration_date` (DATE, NOT NULL)

### 2. Events Table
- `event_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `title` (VARCHAR(200), NOT NULL)
- `description` (TEXT)
- `city` (VARCHAR(100), NOT NULL)
- `start_date` (DATETIME, NOT NULL)
- `end_date` (DATETIME, NOT NULL)
- `status` (ENUM: 'upcoming','completed','cancelled')
- `organizer_id` (INT, FOREIGN KEY → Users)

### 3. Sessions Table
- `session_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `event_id` (INT, FOREIGN KEY → Events)
- `title` (VARCHAR(200), NOT NULL)
- `speaker_name` (VARCHAR(100), NOT NULL)
- `start_time` (DATETIME, NOT NULL)
- `end_time` (DATETIME, NOT NULL)

### 4. Registrations Table
- `registration_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `user_id` (INT, FOREIGN KEY → Users)
- `event_id` (INT, FOREIGN KEY → Events)
- `registration_date` (DATE, NOT NULL)

### 5. Feedback Table
- `feedback_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `user_id` (INT, FOREIGN KEY → Users)
- `event_id` (INT, FOREIGN KEY → Events)
- `rating` (INT, CHECK 1-5)
- `comments` (TEXT)
- `feedback_date` (DATE, NOT NULL)

### 6. Resources Table
- `resource_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `event_id` (INT, FOREIGN KEY → Events)
- `resource_type` (ENUM: 'pdf','image','link')
- `resource_url` (VARCHAR(255), NOT NULL)
- `uploaded_at` (DATETIME, NOT NULL)

## Exercise Files

The module contains 25 SQL exercise files (1.sql through 25.sql), each addressing different aspects of database querying:

1. User Upcoming Events
2. Top Rated Events
3. Inactive Users
4. Peak Session Hours
5. Most Active Cities
6. Event Resource Summary
7. Low Feedback Alerts
8. Sessions per Upcoming Event
9. Organizer Event Summary
10. Feedback Gap
11. Daily New User Count
12. Event with Maximum Sessions
13. Average Rating per City
14. Most Registered Events
15. Event Session Time Conflict
16. Unregistered Active Users
17. Multi-Session Speakers
18. Resource Availability Check
19. Completed Events with Feedback Summary
20. User Engagement Index
21. Top Feedback Providers
22. Duplicate Registrations Check
23. Registration Trends
24. Average Session Duration per Event
25. Events Without Sessions

## How to Use

1. Each SQL file contains a specific query with comments explaining its purpose
2. Replace placeholder values (like `[replace_with_user_id]`) with actual values
3. Execute the queries in a MySQL environment
4. Sample results are provided in comments for reference

## Sample Data

The exercises use sample data that includes:
- 5 users
- 3 events
- 4 sessions
- 5 registrations
- 3 feedback entries
- 3 resources

## Requirements

- MySQL 5.7 or higher
- Basic understanding of SQL syntax
- Familiarity with JOIN operations and aggregate functions

## Notes

- All queries are written in ANSI SQL standard
- Queries include comments for better understanding
- Sample results are provided where applicable
- Some queries may need parameter adjustments based on your specific needs 