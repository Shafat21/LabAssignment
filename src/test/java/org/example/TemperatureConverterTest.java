package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

//
//    Question 2 Number 2
    @ParameterizedTest
    @CsvSource({
            "0, 32",
            "25, 77",
            "-40, -40"
    })
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.001);
    }

    @Test
    void testCelsiusToFahrenheitThrowsExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            TemperatureConverter.celsiusToFahrenheit(-274);
        });
    }
}
