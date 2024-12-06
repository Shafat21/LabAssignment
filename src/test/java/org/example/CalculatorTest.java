package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

//
    //Question 1 Number 1
//
    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Initializing resources before all tests...");
        calculator = new Calculator();
    }

    @BeforeEach
    void setUpBeforeEach() {
        System.out.println("Setting up before each test...");
    }

    @AfterEach
    void cleanUpAfterEach() {
        System.out.println("Cleaning up after each test...");
    }

    @AfterAll
    static void cleanUpAfterAll() {
        System.out.println("Cleaning up resources after all tests...");
        calculator = null;
    }
//
    //Question 1 Number 2
//
    @Test
    void testOfNumberTwo() {
        Integer result = calculator.add(10, 5);
        assertNotNull(result);
        assertEquals(15, result);

        Integer result2 = calculator.add(null, 5);
        assertNull(result2);

        Integer result3 = calculator.divide(10, 2);
        assertNotNull(result3);
        assertEquals(5, result3);

        Integer result4 = calculator.divide(10, 0);
        assertNull(result4);

        Integer result5 = calculator.add(3, 3);
        assertNotEquals(10, result5);

        Integer result6 = calculator.add(4, 4);
        assertTrue(result6 == 8);
        assertFalse(result6 == 9);

        Integer result7 = calculator.divide(9, 3);
        assertTrue(result7 == 3);
        assertFalse(result7 == 4);
    }
//
    //Question 1 Number 3
//
    @Test
    void testOfNumberThree() {
        // Verify exception is thrown for division by zero
        assertThrows(ArithmeticException.class, () -> {
            if (calculator.divide(10, 0) == null) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
        });

        // Verify no exception is thrown for valid division
        assertDoesNotThrow(() -> {
            Integer result = calculator.divide(10, 2);
            assertNotNull(result, "Result should not be null for valid division");
            assertEquals(5, result, "10 / 2 should equal 5");
        });
    }

//
    //Question 1 Number 4
//
    @Test
    void testOfNumberFour() {
        int[] expected = {1, 2, 3, 4};
        int[] actual = {1, 2, 3, 4};

        assertArrayEquals(expected, actual);

        Calculator instance1 = calculator;
        Calculator instance2 = calculator;

        assertSame(instance1, instance2);

        List<String> expectedLines = List.of(
                "Line 1: Calculator Test",
                "Line 2: Division Test",
                "Line 3: Addition Test"
        );
        List<String> actualLines = List.of(
                "Line 1: Calculator Test",
                "Line 2: Division Test",
                "Line 3: Addition Test"
        );

        assertLinesMatch(expectedLines, actualLines);
    }

//
    //Question 1 Number 5
//
    @Test
    void testOfNumberFive() {
        assertTimeout(Duration.ofMillis(500), () -> {
            // Simulate method logic
            Integer result = calculator.add(1000, 2000);
            assertNotNull(result);
            assertEquals(3000, result);
        });
    }
//
    //Question 1 Number 6
//
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",      // Test case 1: 1 + 2 = 3
            "-1, -2, -3",   // Test case 2: -1 + -2 = -3
            "0, 0, 0",      // Test case 3: 0 + 0 = 0
            "100, 200, 300" // Test case 4: 100 + 200 = 300
    })
    void testOfNumberSix(int a, int b, int expected) {
        int result = calculator.add(a, b);
        assertEquals(expected, result, String.format("Expected %d + %d to equal %d", a, b, expected));
    }
//
    //Question 1 Number 7
//
    @RepeatedTest(5) // Repeat the test 5 times
    void testOfNumberSeven() {
        int min = 1;
        int max = 10;
        int randomNumber = calculator.generateRandomNumber(min, max);
        assertTrue(randomNumber >= min && randomNumber <= max,
                String.format("Random number %d is out of range [%d, %d]", randomNumber, min, max));
    }
}
