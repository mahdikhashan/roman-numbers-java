package org.example;

import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class RomanNumbers {
    public static String digitToRoman(int digit) {
        Map<String, Integer> d = getStringIntegerDictionary(digit);
        ArrayList<String> result = new ArrayList<>();
        for (String key : d.keySet()) {
            switch (key) {
                case "thousands" -> IntStream.range(0, d.get(key)).forEach(
                        _ -> result.add("M")
                );
                case "hundreds" -> {
                    ArrayList<String> hundreds = new ArrayList<>();
                    int v = d.get(key);
                    if (v >= 1 && v < 4) {
                        IntStream.range(0, d.get(key)).forEach(
                                _ -> hundreds.add("C")
                        );
                    } else if (v == 4) {
                        hundreds.add("CD");
                    } else if (v == 5) {
                        hundreds.add("D");
                    } else if (v > 5 && v < 9) {
                        hundreds.add("D");
                        IntStream.range(0, v - 5).forEach(
                                _ -> hundreds.add("C")
                        );
                    } else if (v == 9) {
                        hundreds.add("CM");
                    }
                    result.addAll(hundreds);
                }
                case "tens" -> {
                    ArrayList<String> tens = new ArrayList<>();
                    int v = d.get(key);
                    if (v >= 1 && v < 4) {
                        IntStream.range(0, d.get(key)).forEach(
                                _ -> tens.add("X")
                        );
                    } else if (v == 4) {
                        tens.add("XL");
                    } else if (v == 5) {
                        tens.add("L");
                    } else if (v > 5 && v < 9) {
                        tens.add("L");
                        IntStream.range(0, v - 5).forEach(
                                _ -> tens.add("X")
                        );
                    } else if (v == 9) {
                        tens.add("XC");
                    }
                    result.addAll(tens);
                }
                case "digit" -> {
                    ArrayList<String> digits = new ArrayList<>();
                    int v = d.get(key);
                    if (v >= 1 && v < 4) {
                        IntStream.range(0, d.get(key)).forEach(
                                _ -> digits.add("I")
                        );
                    } else if (v == 4) {
                        digits.add("IV");
                    } else if (v == 5) {
                        digits.add("V");
                    } else if (v > 5 && v < 9) {
                        digits.add("V");
                        IntStream.range(0, v - 5).forEach(
                                _ -> digits.add("I")
                        );
                    } else if (v == 9) {
                        digits.add("IX");
                    }
                    result.addAll(digits);
                }
                default -> {
                    throw new RuntimeException("Unreachable");
                }
            }
        }
        return String.join("", result);
    }

    private static Map<String, Integer> getStringIntegerDictionary(int digit) {
        Map<String, Integer> d = new LinkedHashMap<>();
        int div_1000 = Math.floorDiv(digit, 1000);
        int rem_1000 = digit % 1000;
        int div_100 = Math.floorDiv(rem_1000, 100);
        int rem_100 = rem_1000 % 100;
        int div_10 = Math.floorDiv(rem_100, 10);
        int rem_10 = rem_100 % 10;
        d.put("thousands", div_1000);
        d.put("hundreds", div_100);
        d.put("tens", div_10);
        d.put("digit", rem_10);
        return d;
    }
}