-- Day 28 – DML (Data Manipulation Language)
-- DML commands manage the data: INSERT, UPDATE, DELETE, SELECT

USE capgemini_training;

-- ===== INSERT =====
INSERT INTO students (name, email, dob, department, city) VALUES
    ('Alice Sharma',   'alice@example.com',   '2002-03-15', 'Computer Science', 'Mumbai'),
    ('Bob Patel',      'bob@example.com',      '2001-07-22', 'Electronics',      'Delhi'),
    ('Charlie Menon',  'charlie@example.com',  '2003-01-10', 'Computer Science', 'Kochi'),
    ('Diana Verma',    'diana@example.com',    '2002-11-30', 'Mechanical',       'Pune'),
    ('Eve Singh',      'eve@example.com',      '2001-05-18', 'Computer Science', 'Bengaluru');

INSERT INTO courses (course_name, credits, duration_hrs) VALUES
    ('Java Programming',     4, 60),
    ('Data Structures',      4, 55),
    ('SQL and Databases',    3, 40),
    ('Spring Boot',          3, 50),
    ('Machine Learning',     5, 80);

INSERT INTO enrollments (student_id, course_id, enroll_date, grade) VALUES
    (1, 1, '2026-01-07', 'A'),
    (1, 2, '2026-01-07', 'B+'),
    (2, 1, '2026-01-08', 'A-'),
    (3, 3, '2026-01-08', 'B'),
    (4, 4, '2026-01-10', 'A'),
    (5, 5, '2026-01-10', 'A+');

-- ===== SELECT =====
SELECT * FROM students;
SELECT name, email, department FROM students WHERE department = 'Computer Science';
SELECT name, city FROM students ORDER BY name ASC;
SELECT TOP 3 name, department FROM students;  -- SQL Server syntax; use LIMIT 3 in MySQL

-- ===== UPDATE =====
UPDATE students SET city = 'Hyderabad' WHERE student_id = 2;
UPDATE enrollments SET grade = 'A' WHERE student_id = 3 AND course_id = 3;

-- ===== DELETE =====
-- Delete a specific record
DELETE FROM enrollments WHERE enroll_id = 6;

-- Delete with condition
DELETE FROM students WHERE department = 'Mechanical';

-- ===== Verify =====
SELECT * FROM students;
SELECT * FROM enrollments;
