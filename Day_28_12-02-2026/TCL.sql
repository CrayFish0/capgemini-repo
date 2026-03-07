-- Day 28 – TCL (Transaction Control Language)
-- TCL commands manage transactions: COMMIT, ROLLBACK, SAVEPOINT

USE capgemini_training;

-- A transaction is a sequence of SQL statements treated as a unit.
-- Either all succeed (COMMIT) or all are undone (ROLLBACK).

-- ===== COMMIT Example =====
START TRANSACTION;

INSERT INTO students (name, email, dob, department, city) VALUES
    ('Frank D''souza', 'frank@example.com', '2002-08-20', 'Computer Science', 'Goa');

UPDATE enrollments SET grade = 'B+' WHERE student_id = 1 AND course_id = 1;

COMMIT;  -- saves all changes permanently

-- ===== ROLLBACK Example =====
START TRANSACTION;

DELETE FROM enrollments WHERE student_id = 5;
DELETE FROM students    WHERE student_id = 5;

-- Oops – we don't actually want this; undo everything
ROLLBACK;

-- ===== SAVEPOINT Example =====
START TRANSACTION;

INSERT INTO courses (course_name, credits, duration_hrs) VALUES
    ('DevOps Basics', 2, 30);

SAVEPOINT after_insert;

UPDATE courses SET credits = 999 WHERE course_name = 'DevOps Basics';  -- mistake!

-- Roll back only to the savepoint (INSERT is kept)
ROLLBACK TO SAVEPOINT after_insert;

-- Now commit the correct INSERT
COMMIT;

-- ===== RELEASE SAVEPOINT =====
-- RELEASE SAVEPOINT after_insert;  -- removes the savepoint marker (already committed above)

-- ===== Verify =====
SELECT * FROM students;
SELECT * FROM courses;
SELECT * FROM enrollments;
