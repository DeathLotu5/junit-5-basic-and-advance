package com.appsdeveloperblog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @AfterEach
    void afterEachTestMethod() {

        System.out.println("Executing @AfterEach method.");
    }

    /*Convention khi đặt tên test method
        test<System Under Test>_<Condition or State Change>_<Expected Result>
    */
    @Test
    @DisplayName("Test 4/2 = 2")
    void testIntegerDivision_WhenFourIsDividedByTo_ShouldReturnTwo() {
//        Calculator calculator = new Calculator();
        System.out.println("Running test 4/2 = 2");
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

        int actualResult = calculator.integerDivision(dividend, divisor);

        assertEquals(expectedResult,
                actualResult,
                () -> "4/2 did not produce 2");
    }

    @Test
//    @Disabled("TODO: Still need to work on it ")
    @DisplayName("Division by Zero")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeicException() {
//        Calculator calculator = new Calculator();
//        int result = calculator.integerDivision(4, 2);
//        assertEquals(2,
//                result,
//                () -> "4/2 did not produce 2");
        System.out.println("Running Division by Zero");
//        fail("Not implement yet");

        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");

        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"John", "Mike", "Kate"}) // tương tự như @CsvSource
    void valueSourceDemonstration(String firstName) {
        System.out.println(firstName);
        assertNotNull(firstName);
    }

//    @Test
    @ParameterizedTest // Dùng để sử dụng input qua 1 hàm, và thường được dùng để test nhiều lần với param khác nhau
//    @MethodSource //Khai báo hàm mà ta truyền input vào. Đi cùng với @ParameterizedTest
//    @CsvSource({
//            "33, 1, 32",
//            "22, 10, 12",
//            "54, 23, 31"
//    }) // khai báo các input truyền vào, tương tự như @MethodSource nhưng không cần khai báo hàm
//    @CsvSource({
//            "apple, orange",
//            "apple, ''", // nếu để '' sẽ là kí tự rỗng
//            "apple," //Nếu không để rỗng như này sẽ là null
//    })
    @CsvFileSource(resources = "/integerSubtraction.csv")
    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
//        Calculator calculator = new Calculator();
        System.out.println("Running Test " + minuend + " - " + subtrahend + " = " + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult,
                actualResult,
                () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
        //Việc sử dụng lamda trong này giúp cho ta tối ưu hiệu năng
        // Khi chạy câu assert, message sẽ luôn được executed. Vì thế việc thêm lamda vào sẽ chỉ executed msg khi test fail.
    }

//    private static Stream<Arguments> integerSubtraction() {
//        return Stream.of(
//                Arguments.of(33, 1, 32),
//                Arguments.of(100, 23, 77),
//                Arguments.of(33, 12, 21)
//        );
//    }
}