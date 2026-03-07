-- Day 29 – SQL Joins
-- Joins combine rows from two or more tables based on a related column.

USE capgemini_training;

-- Sample data reminder:
-- students(student_id, name, department, city)
-- courses(course_id, course_name, credits)
-- enrollments(enroll_id, student_id, course_id, grade)

-- ===== INNER JOIN =====
-- Returns rows that have matching values in BOTH tables
SELECT s.name, s.department, c.course_name, e.grade
FROM enrollments e
INNER JOIN students s ON e.student_id = s.student_id
INNER JOIN courses  c ON e.course_id  = c.course_id
ORDER BY s.name;

-- ===== LEFT JOIN (LEFT OUTER JOIN) =====
-- Returns ALL rows from left table + matched rows from right table (NULLs for no match)
SELECT s.name, c.course_name
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
LEFT JOIN courses     c ON e.course_id  = c.course_id
ORDER BY s.name;

-- Students with NO enrollment
SELECT s.name FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
WHERE e.enroll_id IS NULL;

-- ===== RIGHT JOIN (RIGHT OUTER JOIN) =====
-- All rows from right table + matched from left
SELECT c.course_name, s.name
FROM students s
RIGHT JOIN enrollments e ON s.student_id = e.student_id
RIGHT JOIN courses     c ON e.course_id  = c.course_id
ORDER BY c.course_name;

-- ===== FULL OUTER JOIN =====
-- MySQL doesn't have FULL OUTER JOIN natively – simulate with UNION
SELECT s.name, c.course_name
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
LEFT JOIN courses     c ON e.course_id  = c.course_id
UNION
SELECT s.name, c.course_name
FROM students s
RIGHT JOIN enrollments e ON s.student_id = e.student_id
RIGHT JOIN courses     c ON e.course_id  = c.course_id;

-- ===== CROSS JOIN =====
-- Cartesian product (every row from A with every row from B)
SELECT s.name, c.course_name
FROM students s
CROSS JOIN courses c
LIMIT 10;

-- ===== SELF JOIN =====
-- Join a table with itself (e.g., find students in same department)
SELECT a.name AS student1, b.name AS student2, a.department
FROM students a
JOIN students b ON a.department = b.department AND a.student_id < b.student_id
ORDER BY a.department;
