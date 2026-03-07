# Capgemini Java Training — Full Course Log

> **Duration:** 07 Jan 2026 – 07 Mar 2026 &nbsp;|&nbsp; **Days:** 45 &nbsp;|&nbsp; **Trainer:** Capgemini  
> A complete record of all topics studied, code written, and projects built during the Capgemini Java training programme.

---

## Table of Contents

| Module | Days | Topics |
|--------|------|--------|
| [Java Fundamentals](#-module-1--java-fundamentals) | 0 – 7 | Syntax, Variables, Operators, Loops, Methods |
| [Object-Oriented Programming](#-module-2--object-oriented-programming) | 8 – 14 | Inheritance, Polymorphism, Interfaces, Collections |
| [DSA — Foundations](#-module-3--dsa--foundations) | 15 – 18 | Arrays, Strings, Queue, Stack, Vector |
| [DSA — Algorithms](#-module-4--dsa--algorithms) | 19 – 24 | Sorting, Searching, Dynamic Programming, Greedy |
| [Advanced Java](#-module-5--advanced-java) | 32 – 37 | Generics, Lambda, Streams, Threads, File I/O |
| [SQL & Databases](#-module-6--sql--databases) | 26 – 30 | DDL, DML, DCL, TCL, Joins, Triggers |
| [Maven & JUnit Testing](#-module-7--maven--junit-testing) | 38 | Maven project setup, JUnit 5, Parameterized tests |
| [JDBC — MySQL](#-module-8--jdbc--mysql) | 40 – 41 | CRUD via JDBC, DAO & DTO pattern |
| [Hibernate / JPA](#-module-9--hibernate--jpa) | 43 – 44 | Entity mapping, Many-to-Many, JPQL |
| [SDLC & Soft Skills](#-module-10--sdlc--soft-skills) | 25, 27, 39, 42, 45 | Agile, Waterfall, Communication |

---

## 📘 Module 1 — Java Fundamentals

### Day 0 — 07 Jan 2026

**Topics:** Training orientation, syllabus walkthrough, Eclipse IDE setup, intro to Java, tokens, biometric registration.  
📁 [Day_00_07-01-2026/README.md](Day_00_07-01-2026/README.md)

---

### Day 1 — 08 Jan 2026

**Topics:** Eclipse workspace configuration, how Java runs a program, class naming conventions (camelCase), tokens, literals, variables, type conversions, operators and operator precedence.

| File | Description |
|------|-------------|
| [Tokens.java](Day_01_08-01-2026/Tokens.java) | Keywords, identifiers, literals, separators |
| [Variables.java](Day_01_08-01-2026/Variables.java) | Primitive types, var declaration, scope |
| [TypeConversions.java](Day_01_08-01-2026/TypeConversions.java) | Widening, narrowing, explicit casting |
| [Operators.java](Day_01_08-01-2026/Operators.java) | Arithmetic, relational, bitwise, precedence |

---

### Day 2 — 09 Jan 2026

**Topics:** Ternary operator, unary increment/decrement, logical operators, loops (`for`, `while`, `do-while`). *Homework: decimal to binary conversion.*

| File | Description |
|------|-------------|
| [TernaryAndUnary.java](Day_02_09-01-2026/TernaryAndUnary.java) | Conditional (ternary) and unary operators |
| [Loops.java](Day_02_09-01-2026/Loops.java) | for, while, do-while, nested loops |
| [DecimalToBinary.java](Day_02_09-01-2026/DecimalToBinary.java) | Decimal to binary homework solution |

---

### Day 3 — 10 Jan 2026

**Topics:** Pattern printing, methods/functions, recursion, quick sort, merge sort, linked list overview. *Weekly test.*

| File | Description |
|------|-------------|
| [PatternPrinting.java](Day_03_10-01-2026/PatternPrinting.java) | Star, number, pyramid patterns |
| [Methods.java](Day_03_10-01-2026/Methods.java) | Method definition, return types, overloading |
| [Recursion.java](Day_03_10-01-2026/Recursion.java) | Factorial, Fibonacci, recursive patterns |
| [Sorting.java](Day_03_10-01-2026/Sorting.java) | Bubble, selection, insertion sort |

---

### Day 4 — 13 Jan 2026

**Topics:** Methods and functions deep dive, recursion, OOP concepts (objects, classes), access specifiers, static vs non-static methods.

| File | Description |
|------|-------------|
| [ObjectsAndClasses.java](Day_04_13-01-2026/ObjectsAndClasses.java) | Class definition, object instantiation, methods |
| [AccessSpecifiers.java](Day_04_13-01-2026/AccessSpecifiers.java) | public, private, protected, default, static |

---

### Day 5 — 14 Jan 2026

**Topics:** Constructors (default, parameterized, copy), arrays, 2D arrays, classes and objects.

| File | Description |
|------|-------------|
| [Constructors.java](Day_05_14-01-2026/Constructors.java) | Default, parameterized, constructor chaining |
| [ArraysDemo.java](Day_05_14-01-2026/ArraysDemo.java) | 1D arrays, 2D arrays, array operations |
| [ClassesDemo.java](Day_05_14-01-2026/ClassesDemo.java) | Class design, object interaction |

---

### Day 6 — 15 Jan 2026

**Topics:** Advanced array operations, Strings, regex, `StringBuffer`, `StringBuilder`, practice problems.

| File | Description |
|------|-------------|
| [AdvancedArrays.java](Day_06_15-01-2026/AdvancedArrays.java) | Sorting, searching, sum, 2D manipulation |
| [StringsDemo.java](Day_06_15-01-2026/StringsDemo.java) | String methods, immutability, comparison |
| [RegexDemo.java](Day_06_15-01-2026/RegexDemo.java) | Pattern matching, email/phone validation |
| [StringBufferBuilder.java](Day_06_15-01-2026/StringBufferBuilder.java) | Mutable strings, performance comparison |

---

### Day 7 — 16 Jan 2026

**Topics:** Objects and classes advanced, encapsulation, `Scanner` for user input, sub-arrays, sliding window, two-pointer technique.

| File | Description |
|------|-------------|
| [Encapsulation.java](Day_07_16-01-2026/Encapsulation.java) | Private fields, getters/setters, data hiding |
| [ScannerInput.java](Day_07_16-01-2026/ScannerInput.java) | Scanner class, user input, input validation |
| [SubArrays.java](Day_07_16-01-2026/SubArrays.java) | Sliding window, two-pointer sub-array problems |

---

## 📗 Module 2 — Object-Oriented Programming

### Day 8 — 17 Jan 2026

**Topics:** Association (Aggregation & Composition), Inheritance basics. *Weekly assessment.*

| File | Description |
|------|-------------|
| [AssociationDemo.java](Day_08_17-01-2026/AssociationDemo.java) | HAS-A: aggregation vs composition |
| [InheritanceDemo.java](Day_08_17-01-2026/InheritanceDemo.java) | Single inheritance, `extends`, `super` keyword |

---

### Day 9 — 19 Jan 2026

**Topics:** Revision of all prior topics, types of inheritance (single, multilevel, hierarchical).

| File | Description |
|------|-------------|
| [InheritanceAdvanced.java](Day_09_19-01-2026/InheritanceAdvanced.java) | Multilevel & hierarchical inheritance chains |

---

### Day 10 — 20 Jan 2026

**Topics:** Upcasting, downcasting, polymorphism (compile-time and runtime).

| File | Description |
|------|-------------|
| [CastingAndPolymorphism.java](Day_10_20-01-2026/CastingAndPolymorphism.java) | Method overriding, dynamic dispatch, casting |

---

### Day 11 — 21 Jan 2026

**Topics:** Abstract classes, interfaces (default/static methods), exception handling (`try-catch-finally`, custom exceptions).

| File | Description |
|------|-------------|
| [AbstractClasses.java](Day_11_21-01-2026/AbstractClasses.java) | Abstract methods, template pattern |
| [Interfaces.java](Day_11_21-01-2026/Interfaces.java) | Interface implementation, multiple interfaces |
| [ExceptionHandling.java](Day_11_21-01-2026/ExceptionHandling.java) | try-catch, finally, throws, custom exceptions |

---

### Day 12 — 22 Jan 2026

**Topics:** Multiple error-handling strategies, wrapper classes (autoboxing/unboxing), Collections framework overview.

| File | Description |
|------|-------------|
| [ErrorHandling.java](Day_12_22-01-2026/ErrorHandling.java) | Multi-catch, nested try, exception hierarchy |
| [WrapperClasses.java](Day_12_22-01-2026/WrapperClasses.java) | Integer, Double, autoboxing, parseInt |
| [CollectionsOverview.java](Day_12_22-01-2026/CollectionsOverview.java) | List, Set, Map interfaces overview |

---

### Day 13 — 24 Jan 2026

**Topics:** LinkedList, Stack, HashMap with hashing. *Weekly Test (4 coding + 60 MCQ).*

| File | Description |
|------|-------------|
| [LinkedListDemo.java](Day_13_24-01-2026/LinkedListDemo.java) | LinkedList operations, iterator |
| [StackDemo.java](Day_13_24-01-2026/StackDemo.java) | Stack push/pop, applications |
| [HashMapDemo.java](Day_13_24-01-2026/HashMapDemo.java) | HashMap, hashing, collision handling |

---

### Day 14 — 27 Jan 2026

**Topics:** ArrayList, HashSet, LinkedHashSet, TreeSet, Comparator overriding.

| File | Description |
|------|-------------|
| [CollectionsAdvanced.java](Day_14_27-01-2026/CollectionsAdvanced.java) | ArrayList, HashSet, LinkedHashSet, TreeSet, Comparator |

---

## 📙 Module 3 — DSA: Foundations

### Day 15 — 28 Jan 2026

**Topics:** Introduction to Data Structures and Algorithms.  
📁 [Day_15_28-01-2026/README.md](Day_15_28-01-2026/README.md)

---

### Day 16 — 29 Jan 2026

**Topics:** Communication and soft skills session.  
📁 [Day_16_29-01-2026/README.md](Day_16_29-01-2026/README.md)

---

### Day 17 — 30 Jan 2026

**Topics:** DSA — Arrays and strings problem-solving.

| File | Description |
|------|-------------|
| [ArraysAndStrings.java](Day_17_30-01-2026/ArraysAndStrings.java) | Two-pointer, sliding window, string manipulation |

---

### Day 18 — 31 Jan 2026

**Topics:** Revision of Collections; Queue, Stack, Vector practical implementations. *Weekly test (2 problems).*

| File | Description |
|------|-------------|
| [QueueStackVector.java](Day_18_31-01-2026/QueueStackVector.java) | Queue (LinkedList/PriorityQueue), Stack, Vector |

---

## 📒 Module 4 — DSA: Algorithms

### Day 19 — 02 Feb 2026

**Topics:** Searching techniques (linear, binary), Merge Sort, Quick Sort.

| File | Description |
|------|-------------|
| [SearchingTechniques.java](Day_19_02-02-2026/SearchingTechniques.java) | Linear search, binary search, variants |
| [SortingAlgorithms.java](Day_19_02-02-2026/SortingAlgorithms.java) | Merge sort, quick sort, time complexity |

---

### Day 20 — 03 Feb 2026

**Topics:** Problem solving, introduction to Dynamic Programming (memoization, tabulation).

| File | Description |
|------|-------------|
| [DynamicProgramming.java](Day_20_03-02-2026/DynamicProgramming.java) | Fibonacci (memo/tab), LCS, coin change |

---

### Day 21 — 04 Feb 2026

**Topics:** Knapsack problem (0/1), Greedy algorithm foundations.

| File | Description |
|------|-------------|
| [KnapsackAndGreedy.java](Day_21_04-02-2026/KnapsackAndGreedy.java) | 0/1 Knapsack (DP), activity selection (greedy) |

---

### Day 22 — 05 Feb 2026

**Topics:** Fractional Knapsack, hashing (anagram), heaps, Huffman algorithm.

| File | Description |
|------|-------------|
| [FractionalKnapsack.java](Day_22_05-02-2026/FractionalKnapsack.java) | Fractional knapsack, min-heap, anagram check |

---

### Day 23 — 06 Feb 2026

**Topics:** Mock test.  
📁 [Day_23_06-02-2026/README.md](Day_23_06-02-2026/README.md)

---

### Day 24 — 07 Feb 2026

**Topics:** Mock test solution discussion, DP and Recursion revision. *Weekly programs test.*

| File | Description |
|------|-------------|
| [DPAndRecursion.java](Day_24_07-02-2026/DPAndRecursion.java) | Recursive DP, top-down vs bottom-up |

---

## 📕 Module 5 — Advanced Java

### Day 25 — 09 Feb 2026

**Topics:** Self-practice, meeting with Capgemini team.  
📁 [Day_25_09-02-2026/README.md](Day_25_09-02-2026/README.md)

---

### Day 32 — 17 Feb 2026

**Topics:** Binary search revision, heaps, priority queues, Advanced Java concepts.

| File | Description |
|------|-------------|
| [BinarySearchAndHeaps.java](Day_32_17-02-2026/BinarySearchAndHeaps.java) | Binary search, MinHeap, MaxHeap, PriorityQueue |

---

### Day 33 — 18 Feb 2026

**Topics:** Generic classes and methods, lambda expressions, functional interfaces.

| File | Description |
|------|-------------|
| [GenericsAndLambda.java](Day_33_18-02-2026/GenericsAndLambda.java) | Generic types, bounded wildcards, lambdas, Predicate/Function |

---

### Day 34 — 19 Feb 2026

**Topics:** Stream API, method references, Comparator, introduction to Threads.

| File | Description |
|------|-------------|
| [StreamAPIAndThreads.java](Day_34_19-02-2026/StreamAPIAndThreads.java) | Stream filter/map/reduce, method refs, Thread basics |

---

### Day 35 — 20 Feb 2026

**Topics:** Threads continued, synchronization, file handling (read/write).

| File | Description |
|------|-------------|
| [ThreadsFileHandling.java](Day_35_20-02-2026/ThreadsFileHandling.java) | synchronized, wait/notify, FileReader/BufferedWriter |

---

### Day 36 — 21 Feb 2026

**Topics:** TopBrains problems (3), Virtual Judge (72 questions). *Weekly test DSA + Java.*  
📁 [Day_36_21-02-2026/README.md](Day_36_21-02-2026/README.md)

---

### Day 37 — 23 Feb 2026

**Topics:** Self-practice on DSA and Java. M1 HackerRank assessment.  
📁 [Day_37_23-02-2026/README.md](Day_37_23-02-2026/README.md)

---

## 🗄️ Module 6 — SQL & Databases

### Day 26 — 10 Feb 2026

**Topics:** Introduction to DBMS, RDBMS concepts, relational model.  
📁 [Day_26_10-02-2026/README.md](Day_26_10-02-2026/README.md)

---

### Day 27 — 11 Feb 2026

**Topics:** English and soft skills session.  
📁 [Day_27_11-02-2026/README.md](Day_27_11-02-2026/README.md)

---

### Day 28 — 12 Feb 2026

**Topics:** SQL command categories — DDL, DML, DCL, TCL with data types.

| File | Description |
|------|-------------|
| [DDL.sql](Day_28_12-02-2026/DDL.sql) | CREATE, ALTER, DROP, TRUNCATE, RENAME |
| [DML.sql](Day_28_12-02-2026/DML.sql) | INSERT, UPDATE, DELETE, SELECT |
| [DCL.sql](Day_28_12-02-2026/DCL.sql) | GRANT, REVOKE |
| [TCL.sql](Day_28_12-02-2026/TCL.sql) | COMMIT, ROLLBACK, SAVEPOINT |

---

### Day 29 — 13 Feb 2026

**Topics:** WHERE, GROUP BY, HAVING clauses, JOIN types.

| File | Description |
|------|-------------|
| [WhereGroupByHaving.sql](Day_29_13-02-2026/WhereGroupByHaving.sql) | Filtering, aggregation, HAVING |
| [Joins.sql](Day_29_13-02-2026/Joins.sql) | INNER, LEFT, RIGHT, FULL OUTER, CROSS JOIN |

---

### Day 30 — 14 Feb 2026

**Topics:** Inner Join, Natural Join, Outer Joins, Triggers. *Weekly SQL Test.*

| File | Description |
|------|-------------|
| [JoinsAndTriggers.sql](Day_30_14-02-2026/JoinsAndTriggers.sql) | Advanced joins, BEFORE/AFTER triggers |

---

### Day 31 — 16 Feb 2026

**Topics:** DSA revision, Codechef and HackerRank practice.  
📁 [Day_31_16-02-2026/README.md](Day_31_16-02-2026/README.md)

---

## 🧪 Module 7 — Maven & JUnit Testing

### Day 38 — 24 Feb 2026

**Topics:** Maven project setup, JUnit 5, parameterized and non-parameterized unit tests, test input handling.

> **Maven project:** `Day_38_24-02-2026/student_test/`

| File | Description |
|------|-------------|
| [pom.xml](Day_38_24-02-2026/student_test/pom.xml) | JUnit 5.10 (`junit-jupiter-api/params/engine`), Surefire 3.1.2 |
| [Student.java](Day_38_24-02-2026/student_test/src/main/java/com/example/Student.java) | Student POJO with `isPassing()` and `getGradeLetter()` |
| [StudentTest.java](Day_38_24-02-2026/student_test/src/test/java/com/example/StudentTest.java) | 8 `@Test` + 3 `@ParameterizedTest` (`@CsvSource`, `@ValueSource`) |

**Run tests:**

```bash
cd Day_38_24-02-2026/student_test
mvn test
```

---

### Day 39 — 25 Feb 2026

**Topics:** English, soft skills and communication session.  
📁 [Day_39_25-02-2026/README.md](Day_39_25-02-2026/README.md)

---

## 🔌 Module 8 — JDBC & MySQL

### Day 40 — 26 Feb 2026

**Topics:** Java Database Connectivity (JDBC), MySQL connection setup, full CRUD using `PreparedStatement`.

> **Maven project:** `Day_40_26-02-2026/student_crud/`

| File | Description |
|------|-------------|
| [pom.xml](Day_40_26-02-2026/student_crud/pom.xml) | `mysql-connector-j 8.3.0` dependency |
| [Student.java](Day_40_26-02-2026/student_crud/src/main/java/com/example/Student.java) | Student model (id, name, age, email) |
| [StudentDAO.java](Day_40_26-02-2026/student_crud/src/main/java/com/example/StudentDAO.java) | `createTable`, `insert`, `getAll`, `getById`, `update`, `delete` |
| [App.java](Day_40_26-02-2026/student_crud/src/main/java/com/example/App.java) | Drives complete CRUD lifecycle |

**Prerequisite:**

```sql
CREATE DATABASE IF NOT EXISTS jpa_demo;
```

---

### Day 41 — 27 Feb 2026

**Topics:** DAO and DTO design pattern — separating data transfer from database logic.

> **Maven project:** `Day_41_27-02-2026/task_management/`

| File | Description |
|------|-------------|
| [pom.xml](Day_41_27-02-2026/task_management/pom.xml) | `mysql-connector-j 8.3.0` dependency |
| [TaskDTO.java](Day_41_27-02-2026/task_management/src/main/java/com/example/TaskDTO.java) | Data Transfer Object — plain fields, no SQL |
| [TaskDAO.java](Day_41_27-02-2026/task_management/src/main/java/com/example/TaskDAO.java) | All DB operations; `getAll`, `getById`, `getByStatus`, `insert`, `update`, `delete` |
| [App.java](Day_41_27-02-2026/task_management/src/main/java/com/example/App.java) | Full workflow: create tasks, filter by status, update, delete |

---

### Day 42 — 28 Feb 2026

**Topics:** Weekly test — Java and SQL (2 coding + 20 MCQ mock; 4 coding + 20 MCQ final).  
📁 [Day_42_28-02-2026/README.md](Day_42_28-02-2026/README.md)

---

## 🗂️ Module 9 — Hibernate / JPA

### Day 43 — 02 Mar 2026

**Topics:** Hibernate ORM, Many-to-Many entity relationship mapping, join table configuration.

> **Maven project:** `Day_43_02-03-2026/student_mapping/`

| File | Description |
|------|-------------|
| [pom.xml](Day_43_02-03-2026/student_mapping/pom.xml) | Hibernate 6.5.2, Jakarta Persistence 3.1, MySQL connector |
| [Student.java](Day_43_02-03-2026/student_mapping/src/main/java/com/example/Student.java) | `@Entity` owning side — `@ManyToMany` with `@JoinTable(student_course)` |
| [Course.java](Day_43_02-03-2026/student_mapping/src/main/java/com/example/Course.java) | `@Entity` inverse side — `@ManyToMany(mappedBy="courses")` |
| [persistence.xml](Day_43_02-03-2026/student_mapping/src/main/resources/META-INF/persistence.xml) | Persistence unit `studentMappingPU` |
| [App.java](Day_43_02-03-2026/student_mapping/src/main/java/com/example/App.java) | Persist students + courses, read back via JPQL |

**Tables auto-created by Hibernate:** `students`, `courses`, `student_course`

---

### Day 44 — 05 Mar 2026

**Topics:** Hibernate entity annotation mapping — `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`; JPQL queries; full entity lifecycle.

> **Maven project:** `Day_44_05-03-2026/student_hibernate/`

| File | Description |
|------|-------------|
| [pom.xml](Day_44_05-03-2026/student_hibernate/pom.xml) | Hibernate 6.5.2, Jakarta Persistence 3.1, MySQL connector |
| [Student.java](Day_44_05-03-2026/student_hibernate/src/main/java/com/example/Student.java) | Fully annotated entity: `@Entity @Table @Id @GeneratedValue @Column` |
| [persistence.xml](Day_44_05-03-2026/student_hibernate/src/main/resources/META-INF/persistence.xml) | Persistence unit `studentHibernatePU` |
| [App.java](Day_44_05-03-2026/student_hibernate/src/main/java/com/example/App.java) | `persist`, `find`, `merge`, JPQL SELECT, `remove` lifecycle demo |

---

## 📋 Module 10 — SDLC & Soft Skills

### Day 45 — 07 Mar 2026

**Topics:** Software Development Life Cycle — Waterfall and Agile models, phases, comparisons, real-world project examples.

| File | Description |
|------|-------------|
| [README.md](Day_45_07-03-2026/README.md) | Waterfall & Agile deep-dive, sprint examples, Scrum/Kanban overview |

---

## Technology Stack

| Technology | Version | Used In |
|------------|---------|---------|
| Java | 21 | All modules |
| Maven | 3.x | Days 38, 40, 41, 43, 44 |
| JUnit | 5.10.0 | Day 38 |
| MySQL | 8.x | Days 40, 41, 43, 44 |
| JDBC | — | Days 40, 41 |
| Hibernate ORM | 6.5.2.Final | Days 43, 44 |
| Jakarta Persistence | 3.1.0 | Days 43, 44 |
| MySQL Connector/J | 8.3.0 | Days 40, 41, 43, 44 |

---

## Database Setup

All JDBC and Hibernate projects connect to:

```
Host     : localhost:3306
Database : jpa_demo
User     : root
Password : system
```

One-time setup:

```sql
CREATE DATABASE IF NOT EXISTS jpa_demo;
```

Hibernate projects use `hibernate.hbm2ddl.auto=update` — tables are created/altered automatically on first run.

---

*Last updated: 07 Mar 2026*
