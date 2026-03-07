-- Day 28 – DCL (Data Control Language)
-- DCL commands manage access permissions: GRANT, REVOKE

-- ===== Create a new user (MySQL syntax) =====
CREATE USER IF NOT EXISTS 'trainee_user'@'localhost' IDENTIFIED BY 'TrainPass@2026';

-- ===== GRANT permissions =====
-- Grant SELECT only on students table
GRANT SELECT ON capgemini_training.students TO 'trainee_user'@'localhost';

-- Grant SELECT, INSERT on specific tables
GRANT SELECT, INSERT ON capgemini_training.courses TO 'trainee_user'@'localhost';

-- Grant all privileges on the database
-- GRANT ALL PRIVILEGES ON capgemini_training.* TO 'trainee_user'@'localhost';

-- Apply privilege changes
FLUSH PRIVILEGES;

-- ===== REVOKE permissions =====
REVOKE INSERT ON capgemini_training.courses FROM 'trainee_user'@'localhost';

-- Revoke all privileges
-- REVOKE ALL PRIVILEGES ON capgemini_training.* FROM 'trainee_user'@'localhost';

-- ===== SHOW GRANTS =====
SHOW GRANTS FOR 'trainee_user'@'localhost';

-- ===== DROP USER =====
-- DROP USER IF EXISTS 'trainee_user'@'localhost';
