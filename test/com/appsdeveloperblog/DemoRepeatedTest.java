package com.appsdeveloperblog;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {
    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

//    @Test
//    @Disabled("TODO: Still need to work on it ")
    @DisplayName("Division by Zero")
    @RepeatedTest(value = 3, name = "{displayName}, Repetition {currentRepetition} of {totalRepetitions}")
    // Dùng để gọi lại method theo số lần mình muốn với param giống nhau.
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeicException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo) {

//        Calculator calculator = new Calculator();
//        int result = calculator.integerDivision(4, 2);
//        assertEquals(2,
//                result,
//                () -> "4/2 did not produce 2");
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
//        fail("Not implement yet");

        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");

        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message!");
    }
}
