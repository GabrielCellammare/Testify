package itsscellammarelamonaca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("greatest common divisor Test (Homework 2) ")
public class greatestCommonDivisorTest {


    @Nested
    @DisplayName("Homework 2 (Happy Path)")
    class greatestCommonDivisorTestHappyPath {

        @Test
        @DisplayName("T1 Test (bothOneAndPositiveTest) ")
        void bothOneAndPositiveTest() {
            assertEquals(1, greatestCommonDivisorClass.greatestCommonDivisor(1, 1));
        }

        @Test
        @DisplayName("T2 Test (EvenOneTest)")
        void EvenOneTest() {
            assertEquals(1, greatestCommonDivisorClass.greatestCommonDivisor(10, 1));
        }

        @Test
        @DisplayName("T3 Test (EvenOddTest)")
        void EvenOddTest() {
            assertEquals(1, greatestCommonDivisorClass.greatestCommonDivisor(2, 5));

        }

        @Test
        @DisplayName("T4 Test (BothEvenTest)")
        void BothEvenTest() {
            assertEquals(10, greatestCommonDivisorClass.greatestCommonDivisor(10, 20));
        }

        @Test
        @DisplayName("T5 (ZeroOneNegativeTest) ")
        void ZeroOneNegativeTest() {
            assertEquals(1, greatestCommonDivisorClass.greatestCommonDivisor(0, -1));
        }

    }

    @Nested
    @DisplayName("Homework 2 (Unhappy Path)")
    class greatestCommonDivisorTestUnhappyPath {
        @Test
        @DisplayName("T6 (ZeroIntegerMinValueTest)")
        void ZeroIntegerMinValueTest() {
            Assertions.assertThrows(ArithmeticException.class,
                    () -> {
                        greatestCommonDivisorClass.greatestCommonDivisor(0, Integer.MIN_VALUE);
                    });
        }

        @Test
        @DisplayName("T7 (bothIntegerMinValueTest)")
        void bothIntegerMinValueTest() {
            Assertions.assertThrows(ArithmeticException.class,
                    () -> {
                        greatestCommonDivisorClass.greatestCommonDivisor(Integer.MIN_VALUE, Integer.MIN_VALUE);
                    });
        }

        @Test
        @DisplayName("T8 (IntegerMinValueZeroTest)")
        void IntegerMinValueZeroTest() {
            Assertions.assertThrows(ArithmeticException.class,
                    () -> {
                        greatestCommonDivisorClass.greatestCommonDivisor(Integer.MIN_VALUE, 0);
                    });


        }
    }


}
