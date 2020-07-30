package com.study.interview.tasks;

import java.util.Arrays;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String aString, String bString) {

        int aLen = aString.length();
        int bLen = bString.length();

        if (aLen < bLen) {
            return addBinary(bString, aString);
        }

        int lenDiff = aLen - bLen;

        char[] digits = new char[aLen + 1];

        char carry = '0';

        for (int i = aString.length() - 1; i >= 0; i--) {
            char aChar = aString.charAt(i);
            char bChar = i - lenDiff < 0 ? '0' : bString.charAt(i - lenDiff);

            char resultDigit;

            if (carry == '1') {
                if (aChar == '1' && bChar == '1') {
                    resultDigit = '1';
                } else if (aChar == '0' && bChar == '0') {
                    resultDigit = '1';
                    carry = '0';
                } else {
                    resultDigit = '0';
                }
            } else {
                if (aChar == '1' && bChar == '1') {
                    resultDigit = '0';
                    carry = '1';
                } else if (aChar == '0' && bChar == '0') {
                    resultDigit = '0';
                    carry = '0';
                } else {
                    resultDigit = '1';
                    carry = '0';
                }
            }
            digits[i + 1] = resultDigit;

        }

        if (carry == '1') {
            digits[0] = '1';
            return String.copyValueOf(digits);
        }

        return String.copyValueOf(Arrays.copyOfRange(digits, 1, digits.length));
    }

}
