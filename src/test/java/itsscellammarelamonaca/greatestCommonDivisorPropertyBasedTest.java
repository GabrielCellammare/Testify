package itsscellammarelamonaca;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class greatestCommonDivisorPropertyBasedTest {

    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void T1TestMCDCalcolatoCorrettamente(
            @ForAll @IntRange(min = (Integer.MIN_VALUE + 1), max = 0) int u,
            @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE) int v) {
        int mcd = greatestCommonDivisorClass.greatestCommonDivisor(u, v);
        if (u == 0 && v == 0 && mcd == 0)
            Assume.that(true); //Per evitare divisioni per 0
        else
            Assertions.assertTrue(mcd >= 0 && ((u % mcd) == 0) && ((v % mcd) == 0));

        Statistics.label("\nNumeri in valore assoluto").collect(Math.abs(v) <= Math.abs(u) ? "U" : "V");

        //Per controllare che effetivamente i numeri non siano troppo grandi o troppo piccoli
    }

    @Property
    @Report(Reporting.GENERATED)
    void T2TestMCDCalcolatoCorrettamente(
            @ForAll @IntRange(min = (Integer.MIN_VALUE + 1), max = 0) int v,
            @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE) int u) {
        int mcd = greatestCommonDivisorClass.greatestCommonDivisor(u, v);
        if (u == 0 && v == 0 && mcd == 0)
            Assume.that(true);
        else
            Assertions.assertTrue(mcd >= 0 && ((u % mcd) == 0) && ((v % mcd) == 0));
    }

    @Property
    @Report(Reporting.GENERATED)
    void T3TestMCDCalcolatoCorrettamente(
            @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE) int v,
            @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE) int u) {
        int mcd = greatestCommonDivisorClass.greatestCommonDivisor(u, v);
        if (u == 0 && v == 0 && mcd == 0)
            Assume.that(true);
        else
            Assertions.assertTrue(mcd >= 0 && ((u % mcd) == 0) && ((v % mcd) == 0));
    }

    @Property
    @Report(Reporting.GENERATED)
    void T4TestMCDCalcolatoCorrettamente(
            @ForAll @IntRange(min = (Integer.MIN_VALUE + 1), max = 0) int v,
            @ForAll @IntRange(min = (Integer.MIN_VALUE + 1), max = 0) int u) {
        int mcd = greatestCommonDivisorClass.greatestCommonDivisor(u, v);
        if (u == 0 && v == 0 && mcd == 0)
            Assume.that(true);
        else
            Assertions.assertTrue(mcd >= 0 && ((u % mcd) == 0) && ((v % mcd) == 0));
    }

    @Property
    @Report(Reporting.GENERATED)
    void T5TestMCDCalcolatoCorrettamente(
            @ForAll("provideIntPositive") int c,
            @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE) int v,
            @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE) int u) {
        u = u + c;
        v = v + c;
        if (v == Integer.MAX_VALUE + 1 && u == Integer.MAX_VALUE + 1) {
            ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
                greatestCommonDivisorClass.greatestCommonDivisor(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
            });
            Assertions.assertEquals("overflow: gcd is 2^31", thrown.getMessage());
        } else {

            int mcd = greatestCommonDivisorClass.greatestCommonDivisor(u, v);
            if (u == 0 && v == 0 && mcd == 0)
                Assume.that(true);
            else
                Assertions.assertTrue(mcd >= 0 && ((u % mcd) == 0) && ((v % mcd) == 0));
        }
    }

    @Property
    @Report(Reporting.GENERATED)
    void T6TestMCDCalcolatoCorrettamente(
            @ForAll("provideIntNegative") int c,
            @ForAll @IntRange(min = Integer.MIN_VALUE + 1, max = 0) int u,
            @ForAll @IntRange(min = Integer.MIN_VALUE + 1, max = 0) int v) {
        u = u + c;
        v = v + c;
        if (v == Integer.MIN_VALUE && u == Integer.MIN_VALUE) {
            ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
                greatestCommonDivisorClass.greatestCommonDivisor(Integer.MIN_VALUE, Integer.MIN_VALUE);
            });
            Assertions.assertEquals("overflow: gcd is 2^31", thrown.getMessage());
        } else {

            int mcd = greatestCommonDivisorClass.greatestCommonDivisor(u, v);
            if (u == 0 && v == 0 && mcd == 0)
                Assume.that(true);
            else
                Assertions.assertTrue(mcd >= 0 && ((u % mcd) == 0) && ((v % mcd) == 0));
        }

    }


    @Provide
    Arbitrary<Integer> provideIntPositive() {
        return Arbitraries.integers().between(0, Integer.MAX_VALUE);
    }

    @Provide
    Arbitrary<Integer> provideIntNegative() {
        return Arbitraries.integers().between(Integer.MIN_VALUE + 1, 0);
    }

    @Property
    @Report(Reporting.GENERATED)
    public void T10TestParametriNonValidi(@ForAll @CharRange(from = Character.MIN_VALUE, to = Character.MAX_VALUE) char character) {
        int mcd = greatestCommonDivisorClass.greatestCommonDivisor(character, character);
        if (character == 0 && mcd == 0) //per evitare divisioni per 0
            Assume.that(true);
        else
            Assertions.assertTrue(mcd >= 0 && ((character % mcd) == 0));
    }

    @Property
    @Report(Reporting.GENERATED)
    public void T11TestParametriNonValidi(@ForAll @CharRange(from = Character.MIN_VALUE, to = Character.MAX_VALUE) char characterU,
                                          @ForAll @CharRange(from = Character.MIN_VALUE, to = Character.MAX_VALUE) char characterV) {
        int mcd = greatestCommonDivisorClass.greatestCommonDivisor(characterU, characterV);
        if (characterU == 0 && characterV == 0 && mcd == 0)
            Assume.that(true);
        else
            Assertions.assertTrue(mcd >= 0 && ((characterU % mcd) == 0) && ((characterV % mcd) == 0));

        Statistics.label("\nPunteggiatura U").collect((Character.getType(characterU) == Character.CONNECTOR_PUNCTUATION ||
                Character.getType(characterU) == Character.DASH_PUNCTUATION ||
                Character.getType(characterU) == Character.END_PUNCTUATION ||
                Character.getType(characterU) == Character.FINAL_QUOTE_PUNCTUATION ||
                Character.getType(characterU) == Character.INITIAL_QUOTE_PUNCTUATION ||
                Character.getType(characterU) == Character.OTHER_PUNCTUATION ||
                Character.getType(characterU) == Character.START_PUNCTUATION) ? "Punteggiatura U" : "Non punteggiatura U");


        Statistics.label("\nLettera U").collect((Character.isLetter(characterU)) ? "Lettera U" : "Non Lettera U");

        Statistics.label("\nNumero U").collect((Character.isDigit(characterU)) ? "Numero U" : "Non Numero U");

        Statistics.label("\nPunteggiatura V").collect(
                (Character.getType(
                        characterV) == Character.CONNECTOR_PUNCTUATION ||
                        Character.getType(characterV) == Character.DASH_PUNCTUATION ||
                        Character.getType(characterV) == Character.END_PUNCTUATION ||
                        Character.getType(characterV) == Character.FINAL_QUOTE_PUNCTUATION ||
                        Character.getType(characterV) == Character.INITIAL_QUOTE_PUNCTUATION ||
                        Character.getType(characterV) == Character.OTHER_PUNCTUATION ||
                        Character.getType(characterV) == Character.START_PUNCTUATION) ? "Punteggiatura V" : "Non punteggiatura V");


        Statistics.label("\nLettera V").collect((Character.isLetter(characterV)) ? "Lettera V" : "Non Lettera V");

        Statistics.label("\nNumero V").collect((Character.isDigit(characterV)) ? "Numero V" : "Non Numero V");
    }
}
