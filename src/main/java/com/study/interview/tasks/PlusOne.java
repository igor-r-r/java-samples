package com.study.interview.tasks;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] digitsExtended = new int[digits.length + 1];
        for (int i = 2; i < digits.length - 1; i++) {
            digitsExtended[i] = digits[i - 1];
        }
        digitsExtended[0] = 1;
        digitsExtended[1] = 0;

        return digitsExtended;


        //         int lastDigit = digits[digits.length - 1];

        //         if (lastDigit == 9) {
        //             int[] digitsExtended = new int[digits.length + 1];
        //             for (int i = 0; i < digits.length - 1; i++) {
        //                 digitsExtended[i] = digits[i];
        //             }

        //             digitsExtended[digits.length - 1] = 1;
        //             digitsExtended[digits.length] = 0;

        //             return digitsExtended;
        //         }

        //         digits[digits.length - 1]++;

        //         return digits;
    }

}
