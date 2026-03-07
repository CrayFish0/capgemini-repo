-- Day 29 – WHERE, GROUP BY, HAVING Clauses

USE capgemini_training;

-- ===== WHERE (filter rows) =====
-- Simple condition
SELECT * FROM students WHERE department = 'Computer Science';

-- Multiple conditions
SELECT name, email FROM students
WHERE department = 'Computer Science' AND city = 'Mumbai';

-- Pattern matching
SELECT name FROM students WHERE name LIKE 'A%';
SELECT name FROM students WHERE email LIKE '%@example.com';

-- Range
SELECT name, dob FROM students WHERE dob BETWEEN '2001-01-01' AND '2002-12-31';

-- IN clause
SELECT name, department FROM students WHERE department IN ('Computer Science', 'Electronics');

-- NOT condition
SELECT name FROM students WHERE department NOT IN ('Mechanical');

-- NULL check
SELECT name FROM students WHERE city IS NOT NULL;

-- ===== GROUP BY (aggregate rows) =====
-- Count students per department
SELECT department, COUNT(*) AS student_count
FROM students
GROUP BY department;

-- Average grade isn't directly possible with CHAR grades; let's use credits as an example
SELECT c.course_name, COUNT(e.enroll_id) AS total_enrolled
FROM courses c
LEFT JOIN enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name;

-- ===== HAVING (filter after GROUP BY) =====
-- Departments with more than 1 student
SELECT department, COUNT(*) AS cnt
FROM students
GROUP BY department
HAVING COUNT(*) > 1;

-- Courses enrolled by more than 0 students
SELECT c.course_name, COUNT(e.student_id) AS enrolled
FROM courses c
JOIN enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name
HAVING enrolled >= 1
ORDER BY enrolled DESC;

-- ===== ORDER BY =====
SELECT name, city FROM students ORDER BY city ASC, name DESC;

-- ===== LIMIT / OFFSET =====
SELECT * FROM students ORDER BY student_id LIMIT 3;           -- first 3
SELECT * FROM students ORDER BY student_id LIMIT 3 OFFSET 2; -- skip 2, get next 3

-- ===== Aggregate Functions =====
SELECT
    COUNT(*)   AS total_students,
    MIN(dob)   AS oldest,
    MAX(dob)   AS youngest
FROM students;
