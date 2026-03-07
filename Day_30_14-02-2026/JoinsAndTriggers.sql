-- Day 30 – Inner Join, Natural Join, Outer Join (detailed), Triggers

USE capgemini_training;

-- ===== INNER JOIN (explicit) =====
SELECT s.name, c.course_name, e.grade
FROM students s
INNER JOIN enrollments e USING (student_id)
INNER JOIN courses     c USING (course_id);

-- ===== NATURAL JOIN =====
-- Automatically joins on columns with the same name in both tables.
-- Requires identical column NAME in both tables.
SELECT * FROM students NATURAL JOIN enrollments;  -- joins on student_id

-- ===== OUTER JOINS =====
-- LEFT OUTER
SELECT s.name, e.grade
FROM students s
LEFT OUTER JOIN enrollments e ON s.student_id = e.student_id;

-- RIGHT OUTER
SELECT c.course_name, e.grade
FROM enrollments e
RIGHT OUTER JOIN courses c ON e.course_id = c.course_id;

-- ===== TRIGGERS =====
-- A trigger is a stored procedure that fires automatically on INSERT/UPDATE/DELETE.

-- Create an audit log table
CREATE TABLE IF NOT EXISTS audit_log (
    log_id     INT PRIMARY KEY AUTO_INCREMENT,
    action     VARCHAR(20),
    student_id INT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- AFTER INSERT trigger on students
DELIMITER //
CREATE TRIGGER after_student_insert
AFTER INSERT ON students
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (action, student_id)
    VALUES ('INSERT', NEW.student_id);
END //
DELIMITER ;

-- BEFORE UPDATE trigger (prevent negative student_id – just a demo)
DELIMITER //
CREATE TRIGGER before_student_update
BEFORE UPDATE ON students
FOR EACH ROW
BEGIN
    IF NEW.name = '' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Student name cannot be empty.';
    END IF;
END //
DELIMITER ;

-- AFTER DELETE trigger
DELIMITER //
CREATE TRIGGER after_student_delete
AFTER DELETE ON students
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (action, student_id)
    VALUES ('DELETE', OLD.student_id);
END //
DELIMITER ;

-- Test triggers
INSERT INTO students (name, email, dob, department, city)
VALUES ('Test User', 'test@example.com', '2000-01-01', 'Test', 'TestCity');

SELECT * FROM audit_log;

-- Show triggers
SHOW TRIGGERS FROM capgemini_training;

-- Drop a trigger
-- DROP TRIGGER IF EXISTS after_student_insert;
