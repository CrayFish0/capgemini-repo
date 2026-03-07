# Day 26 – 10.02.2026: Introduction to DB, DBMS, RDBMS

## Key Concepts

### Database (DB)
An organized collection of structured data stored electronically.

### DBMS (Database Management System)
Software that manages databases. Examples: MySQL, Oracle, SQLite, MongoDB.

### RDBMS (Relational DBMS)
Stores data in tables (relations) with rows and columns.
Uses SQL (Structured Query Language).
Examples: MySQL, PostgreSQL, Oracle DB, SQL Server.

## Core Terminology
| Term       | Description                             |
|------------|-----------------------------------------|
| Table      | A collection of rows and columns        |
| Row/Record | A single data entry                     |
| Column/Field | An attribute of an entity              |
| Primary Key | Unique identifier for a row            |
| Foreign Key | Links to the primary key of another table |
| Index      | Speed up data retrieval                 |
| Schema     | Structure/design of the database        |

## ACID Properties
- **A**tomicity  – All operations in a transaction succeed or all fail.
- **C**onsistency – DB moves from one valid state to another.
- **I**solation  – Concurrent transactions do not interfere.
- **D**urability – Committed transactions survive system failures.

## Normalization (brief)
- **1NF** – Atomic columns, no repeating groups.
- **2NF** – 1NF + no partial dependency.
- **3NF** – 2NF + no transitive dependency.
