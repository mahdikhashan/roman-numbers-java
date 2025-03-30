package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RomanNumbersTest {

    @Test
    void testConvertNumbersToRomanNumerals() {
        assertEquals("MMM", RomanNumbers.digitToRoman(3000));
        assertEquals("MM", RomanNumbers.digitToRoman(2000));
        assertEquals("M", RomanNumbers.digitToRoman(1000));
        assertEquals("MMMCCXXIII", RomanNumbers.digitToRoman(3223));
    }

    @Test
    void testConvertThousandOneToRoman() {
        assertEquals("MI", RomanNumbers.digitToRoman(1001));
        assertEquals("MIII", RomanNumbers.digitToRoman(1003));
    }

    @Test
    void testConvertThousandElevenToRoman() {
        assertEquals("MXI", RomanNumbers.digitToRoman(1011));
    }

    @Test
    void testConvertThousandHundredTensOneToRoman() {
        assertEquals("MCXI", RomanNumbers.digitToRoman(1111));
        assertEquals("MMCXI", RomanNumbers.digitToRoman(2111));
        assertEquals("MMCCXXII", RomanNumbers.digitToRoman(2222));
    }

    @Test
    void testConvertFiftyToRoman() {
        assertEquals("L", RomanNumbers.digitToRoman(50));
    }

    @Test
    void testConvertSixtyToRoman() {
        assertEquals("LX", RomanNumbers.digitToRoman(60));
    }

    @Test
    void testConvertSeventyToRoman() {
        assertEquals("LXX", RomanNumbers.digitToRoman(70));
        assertEquals("LXXV", RomanNumbers.digitToRoman(75));
        assertEquals("LXXIX", RomanNumbers.digitToRoman(79));
    }

    @Test
    void testConvertSeventhySevenToRoman() {
        assertEquals("LXXVII", RomanNumbers.digitToRoman(77));
    }

    @Test
    void testConvertFourHundredsToRomanNumerals() {
        assertEquals("CD", RomanNumbers.digitToRoman(400));
        assertEquals("D", RomanNumbers.digitToRoman(500));
    }

    @Test
    void testConvertEightHunderdsAndEightyEightToRoman() {
        assertEquals("DCCCLXXXVIII", RomanNumbers.digitToRoman(888));
    }

    // ChatGPT generated
    @Test
    void testConvertHarderCasesToRoman() {
        assertEquals("MMMCMXCIX", RomanNumbers.digitToRoman(3999)); // Largest valid Roman numeral
        assertEquals("CDXLIV", RomanNumbers.digitToRoman(444)); // Combination of subtraction cases
        assertEquals("CMXC", RomanNumbers.digitToRoman(990)); // Edge case near 1000
        assertEquals("XCIX", RomanNumbers.digitToRoman(99)); // Edge case near 100
        assertEquals("XLIX", RomanNumbers.digitToRoman(49)); // Edge case near 50
        assertEquals("CDXC", RomanNumbers.digitToRoman(490)); // Edge case near 500
        assertEquals("DCCC", RomanNumbers.digitToRoman(800)); // High hundreds
        assertEquals("MCMXCIV", RomanNumbers.digitToRoman(1994)); // Complex mixture of rules
        assertEquals("MMCDXLV", RomanNumbers.digitToRoman(2445)); // Mid-range test case
        assertEquals("CCCLXXXIX", RomanNumbers.digitToRoman(389)); // Edge case near 400
    }
}
