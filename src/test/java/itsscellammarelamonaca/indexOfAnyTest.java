package itsscellammarelamonaca;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class indexOfAnyTest {


    private final String st = "He l l o W orl d";
    private final char[] emptyCharArray = new char[0];

    @Nested
    @DisplayName("Specification-Based Test (Homework 1)")
    class indexOfAnyTestSpecificationBasedTest {
        @Test
        @Disabled
        @DisplayName("Example Test")
        public void exampleTest() {

            assertEquals(1, indexOfAnyClass.indexOfAny(" i iiIIIiii i I I ", 'i'));
            assertEquals(2, indexOfAnyClass.indexOfAny("ciao", 'a'));
            assertEquals(-1, indexOfAnyClass.indexOfAny(null, 'a'));
            assertEquals(-1, indexOfAnyClass.indexOfAny("ciao", null));
            assertEquals(-1, indexOfAnyClass.indexOfAny("ciao", 'z'));
            assertEquals(0, indexOfAnyClass.indexOfAny("zzabyycdx", 'x', 'z'));


            assertEquals(0, indexOfAnyClass.indexOfAny("za", 'z', 'a'));

            assertEquals(3, indexOfAnyClass.indexOfAny("a\uD800zm", '\uD800', 'm', 'b'));

            //https://stackoverflow.com/questions/5903008/what-is-a-surrogate-pair-in-java Surrogate

        }

        @Nested
        @DisplayName("Exceptional cases tests")
        class exceptionalCases {

            @ParameterizedTest
            @DisplayName("T1 & T2 Test (CharSequence Null or Empty)")
            @NullSource
            @EmptySource
            void charSequenceIsNullOrEmpty(String value) {

                assertEquals(-1, indexOfAnyClass.indexOfAny(value, 'a'));
            }


            @ParameterizedTest
            @ValueSource(chars = {'\u0000', '\0'})
            @DisplayName("T3 & T4 Test (searchChars Null or Empty)")
            void searchCharsIsNullOrEmpty(char value) {

                assertEquals(-1, indexOfAnyClass.indexOfAny("a", value));
            }
        }

        @Nested
        @DisplayName("CharSequence lenght >=1 & searchChars lenght=1")
        class charSequenceOfLenght1OrMoreSearchCharsOfLenght1 {


            @Test
            @DisplayName("T5 Test (CharSequenceLenght>1 doesn't contains the char in searchChars ")
            void charSequenceOfLenghtMore1NotContainsTheChar() {
                assertEquals(-1, indexOfAnyClass.indexOfAny(st, 'h'));
            }

            @Test
            @DisplayName("T6 Test [Boundary Case] (CharSequenceLenght=1 contains the char in searchChars ")
            void charSequenceOfLenght1ContainsTheChar() {
                assertEquals(0, indexOfAnyClass.indexOfAny("H", 'H'));
            }

            @Test
            @DisplayName("T7 Test (CharSequenceLenght=1 doesn't contains the char in searchChars ")
            void charSequenceOfLenght1NotContainsTheChar() {
                assertEquals(-1, indexOfAnyClass.indexOfAny("H", 'h'));
            }

            @Test
            @DisplayName("T8 Test (CharSequenceLenght>1 contains the char in searchChars ")
            void charSequenceOfLenghtMore1ContainsTheChar() {
                assertEquals(3, indexOfAnyClass.indexOfAny(st, 'l'));
            }


        }

        @Nested
        @DisplayName("CharSequence lenght >1 & searchChars lenght>1")
        class charSequenceSearchCharsLenghtMore1 {
            @Test
            @DisplayName("T9 Test (CharSequence doesn't contain any chars in searchChars ")
            void charSequenceOfLenghtMore1NotContainsAnyChar() {
                assertEquals(-1, indexOfAnyClass.indexOfAny(st, 'a', 'z', 'b'));
            }

            @Test
            @DisplayName("T10 Test (CharSequence contains all chars in searchChars")
            void charSequenceOfLenghtMore1ContainsAllChar() {
                assertEquals(0, indexOfAnyClass.indexOfAny(st, 'H', 'e', 'l', 'o'));
            }

            @Test
            @DisplayName("T11 Test (CharSequence contains only one char in searchChars")
            void charSequenceOfLenghtMore1Contains1Char() {
                assertEquals(1, indexOfAnyClass.indexOfAny(st, 'e', 'z', 'b'));
            }

            @Test
            @DisplayName("T12 Test (CharSequence contains at least one char in searchChars")
            void charSequenceOfLenghtMore1ContainsAtLeastOneChar() {
                assertEquals(3, indexOfAnyClass.indexOfAny(st, 'l', 'o', 'b'));
            }


        }

        @Nested
        @DisplayName("Additional Cases")
        class additionalCases {
            @Test
            @DisplayName("T13 Test (Special chars)")
            void specialChars() {
                assertAll(
                        () -> assertEquals(0, indexOfAnyClass.indexOfAny("\u03A0hELol World", '\u03A0')), //Π char tested
                        () -> assertEquals(0, indexOfAnyClass.indexOfAny("\u0D90hELol World", '\u0D90')), // ඐ char tested
                        () -> assertEquals(0, indexOfAnyClass.indexOfAny("\u4E0FhELol World", '\u4E0F')), // 丏 char tested
                        () -> assertEquals(0, indexOfAnyClass.indexOfAny("\u103AhELol World", '\u103A')), // ် char tested
                        () -> assertEquals(0, indexOfAnyClass.indexOfAny("\u00E8heLol World", '\u00E8'))//è char tested
                );
            }

            @Test
            @DisplayName("T14 Test (Concatenation String)")
            void concatenationString() {
                assertAll(
                        () -> assertEquals(1, indexOfAnyClass.indexOfAny("'a'" + "prova", 'a')),
                        () -> assertEquals(3, indexOfAnyClass.indexOfAny("'a'" + "prova", 'p')),
                        () -> assertEquals(3, indexOfAnyClass.indexOfAny("'a'+" + "'prova", '+'))
                );
            }

            @Test
            @DisplayName("T15 Test (Char from Method)")
            void charFromMethod() {
                assertEquals(st.length() - 1, indexOfAnyClass.indexOfAny(st, st.charAt(st.length() - 1)));
            }

            @Test
            @DisplayName("T16 Test (Char from ASCII)")
            void charFromAscii() {
                assertEquals(1, indexOfAnyClass.indexOfAny(st, (char) 101));
            }

            @Test
            @DisplayName("T17 Test (Char from Hex)")
            void charFromHex() {
                assertEquals(1, indexOfAnyClass.indexOfAny(st, (char) 0x65));
            }


        }
    }

    @Nested
    @DisplayName("Structural Testing (Homework 2)")
    class indexOfAnyTestStructuralTesting {


        @Test
        @DisplayName("T18 isEmpty(cs)||ArrayUtils.isEmpty(searchChars)MCDCTest")
        void isEmptycsORArrayUtilsisEmptysearchCharsMCDCTest() {
            //1 = isEmpty(cs) [False] || ArrayUtils.isEmpty(searchChars) [False] già implementato


            assertAll(
                    //2 = isEmpty(cs) [False] || ArrayUtils.isEmpty(searchChars) [True]
                    () -> assertEquals(-1, indexOfAnyClass.indexOfAny(st, emptyCharArray)),


                    //3 = isEmpty(cs) [True] || ArrayUtils.isEmpty(searchChars) [False]
                    () -> assertEquals(-1, indexOfAnyClass.indexOfAny("", 'c'))

            );


        }

        @Test
        @DisplayName("T19 i < csLast && j < searchLast && Character.isHighSurrogate(ch)MCDCTest")
        void iminorcsLastANDjminorlsearchLastANDCharacterisHighSurrogatechMCDCTest() {

            assertEquals(0, indexOfAnyClass.indexOfAny(
                    "\uD83D\uDE01a\uD83D\uDE01b", '\uD83D', '\uDE01', 'b'));
        }

        @Test
        @DisplayName("T20 searchChars[j + 1] == cs.charAt(i + 1)MCDCTest")
        void searchCharsj1EQUALTOcscharAtiplusOneMCDCTestMCDCTest() {
            assertEquals(-1, indexOfAnyClass.indexOfAny("Hello\uD83D\uDE00world!", 'a', 'b', '\uD83D', '\uDE01'));
        }

        @Test
        @DisplayName("T21 searchChars[j + 1] == cs.charAt(i + 1) PIT Extra test")
        void PitExtraTest() {
            assertEquals(5, indexOfAnyClass.indexOfAny(
                    "Hello\uD83D\uDE00world!", 'a', 'b', '\uD83D', '\uDE00'));
        }

        @Test
        @Disabled
        @DisplayName("Boundary Test [Max lenght of String]")
        void MaxStringLenghtNewBoundaryStructuralTest() {

            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 603979775; i++) {
                char randomChar = (char) (random.nextInt(Integer.MAX_VALUE) + 'a');
                sb.append(randomChar);
            }


        /*     for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    char randomChar = (char) (random.nextInt(Integer.MAX_VALUE) + 'a');
                    sb.append(randomChar);
                } catch (Throwable e) {
                    System.out.println(i);
                    break;
                }
            }
            System.out.println(sb.toString().length());
        */

            assertEquals(-1, indexOfAnyClass.indexOfAny(
                    sb, '0'));

        }

    }


}




