-- Day 28 – DDL (Data Definition Language)
-- DDL commands define the structure of the database: CREATE, ALTER, DROP, TRUNCATE, RENAME

-- ===== CREATE DATABASE & TABLE =====
CREATE DATABASE IF NOT EXISTS capgemini_training;
USE capgemini_training;

CREATE TABLE IF NOT EXISTS students (
    student_id   INT           PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(100)  NOT NULL,
    email        VARCHAR(150)  UNIQUE NOT NULL,
    dob          DATE,
    department   VARCHAR(50)   DEFAULT 'General',
    created_at   TIMESTAMP     DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS courses (
    course_id    INT           PRIMARY KEY AUTO_INCREMENT,
    course_name  VARCHAR(100)  NOT NULL,
    credits      INT           CHECK (credits BETWEEN 1 AND 6),
    duration_hrs INT
);

CREATE TABLE IF NOT EXISTS enrollments (
    enroll_id   INT  PRIMARY KEY AUTO_INCREMENT,
    student_id  INT  NOT NULL,
    course_id   INT  NOT NULL,
    enroll_date DATE DEFAULT (CURRENT_DATE),
    grade       CHAR(2),
    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id)  REFERENCES courses(course_id)   ON DELETE RESTRICT
);

-- ===== ALTER (modify table structure) =====
ALTER TABLE students ADD COLUMN phone VARCHAR(15);
ALTER TABLE students MODIFY COLUMN phone VARCHAR(20);
ALTER TABLE students DROP COLUMN phone;
ALTER TABLE students ADD COLUMN city VARCHAR(50) AFTER email;

-- ===== RENAME =====
-- ALTER TABLE students RENAME TO trainees;  -- uncomment to test, then rename back

-- ===== TRUNCATE (removes all rows, keeps structure) =====
-- TRUNCATE TABLE enrollments;

-- ===== DROP (removes table entirely) =====
-- DROP TABLE IF EXISTS enrollments;
-- DROP DATABASE IF EXISTS capgemini_training;

-- ===== SHOW / DESCRIBE =====
SHOW TABLES;
DESCRIBE students;
DESCRIBE courses;
DESCRIBE enrollments;
