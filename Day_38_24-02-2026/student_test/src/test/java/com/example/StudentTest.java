package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

// Day 38 – JUnit 5 Unit Tests for Student class
// Non-parameterized tests verify fixed scenarios.
// Parameterized tests reuse the same logic across multiple inputs.
public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(1, "Alice", 20, 85.0);
    }

    // ── Non-Parameterized Tests ────────────────────────────────────────────────

    @Test
    void testStudentCreation() {
        assertEquals(1, student.getId());
        assertEquals("Alice", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(85.0, student.getGrade());
    }

    @Test
    void testDefaultConstructorCreatesEmptyStudent() {
        Student s = new Student();
        assertEquals(0, s.getId());
        assertNull(s.getName());
        assertEquals(0, s.getAge());
        assertEquals(0.0, s.getGrade());
    }

    @Test
    void testIsPassingWhenGradeIsAboveThreshold() {
        assertTrue(student.isPassing()); // grade = 85
    }

    @Test
    void testIsFailingWhenGradeIsBelowThreshold() {
        student.setGrade(45.0);
        assertFalse(student.isPassing());
    }

    @Test
    void testIsPassingWhenGradeIsExactlyFifty() {
        student.setGrade(50.0);
        assertTrue(student.isPassing());
    }

    @Test
    void testGradeLetterIsB() {
        assertEquals("B", student.getGradeLetter()); // grade = 85
    }

    @Test
    void testSetterUpdatesGradeCorrectly() {
        student.setGrade(72.0);
        assertEquals(72.0, student.getGrade());
        assertEquals("C", student.getGradeLetter());
    }

    @Test
    void testToStringContainsName() {
        assertTrue(student.toString().contains("Alice"));
    }

    // ── Parameterized Tests ────────────────────────────────────────────────────

    /**
     * Tests getGradeLetter() for all grade bands using multiple CSV rows.
     * Each row supplies (grade, expectedLetter).
     */
    @ParameterizedTest
    @CsvSource({
            "95.0, A",
            "85.0, B",
            "75.0, C",
            "65.0, D",
            "49.9, F",
            "0.0,  F"
    })
    void testGradeLetterParameterized(double grade, String expectedLetter) {
        student.setGrade(grade);
        assertEquals(expectedLetter.trim(), student.getGradeLetter());
    }

    /**
     * Tests isPassing() returns true for grades at or above the pass mark.
     */
    @ParameterizedTest
    @ValueSource(doubles = { 50.0, 60.0, 75.5, 88.0, 100.0 })
    void testIsPassingForPassingGrades(double grade) {
        student.setGrade(grade);
        assertTrue(student.isPassing());
    }

    /**
     * Tests isPassing() returns false for grades below the pass mark.
     */
    @ParameterizedTest
    @ValueSource(doubles = { 0.0, 10.0, 25.0, 49.9 })
    void testIsFailingForFailingGrades(double grade) {
        student.setGrade(grade);
        assertFalse(student.isPassing());
    }

    /**
     * Tests the full constructor with multiple sets of field values.
     */
    @ParameterizedTest
    @CsvSource({
            "1, Alice,   20, 85.0",
            "2, Bob,     22, 72.0",
            "3, Charlie, 19, 91.0",
            "4, Diana,   21, 48.5"
    })
    void testConstructorParameterized(int id, String name, int age, double grade) {
        Student s = new Student(id, name, age, grade);
        assertEquals(id, s.getId());
        assertEquals(name.trim(), s.getName());
        assertEquals(age, s.getAge());
        assertEquals(grade, s.getGrade());
    }
}
