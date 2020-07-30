package com.study.interview.tasks;

public class Multiply {

    public static void main(String[] args) {
        //System.out.println(new Multiply().multiply("16", "20"));
        System.out.println(new Multiply().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {

        /*

        1. Loop through first string's numbers
        2. Loop inside through second string's numbers
        3. Multiply all numbers from second string on number of first string
        4. Collect result in string array
        5. Add all results from string array with 1 number indentation for each string
        6.
         */

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String[] stringsToAdd = new String[num1.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder currentMultiplication = new StringBuilder();
            int carry = 0;

            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';

                int multiplicationResult = n1 * n2 + carry;
                int remainder = multiplicationResult % 10;
                carry = multiplicationResult / 10;

                currentMultiplication.insert(0, remainder);
            }

            if (carry > 0) {
                currentMultiplication.insert(0, carry);
            }

            for (int j = 0; j < num1.length() - i - 1; j++) {
                currentMultiplication.append("0");
            }

            stringsToAdd[i] = currentMultiplication.reverse().toString();
        }

        String currentString = stringsToAdd[0];

        for (int i = 0; i < stringsToAdd.length - 1; i++) {
            int carry = 0;

            String s1 = currentString;
            String s2 = stringsToAdd[i + 1];

            StringBuilder sumResult = new StringBuilder();

            for (int j = 0; j < s1.length(); j++) {
                int digit1 = s1.charAt(j) - '0';

                int digit2 = j < s2.length() ? s2.charAt(j) - '0' : 0;

                int sum = digit1 + digit2 + carry;
                int remainder = sum % 10;
                carry = sum / 10;

                sumResult.append(remainder);
            }

            if (carry > 0) {
                sumResult.append(carry);
            }

            currentString = sumResult.toString();
        }

        return new StringBuilder(currentString).reverse().toString();
    }

}
