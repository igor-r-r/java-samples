package com.study.interview.tasks;

import java.util.HashSet;
import java.util.Set;

public class NonRepeatable {

    public boolean isNonRepeatable(String string) {
        if (string == null || string.length() < 2) {
            return true;
        }

        string = string.toLowerCase();

        Set<Character> existingChars = new HashSet<>(40);

        for (Character c : string.toCharArray()) { // O(N)
            if (existingChars.contains(c)) { // O(1)
                return false;
            } else {
                existingChars.add(c); // O(1)
            }
        }

        return true;
    }

    public boolean isNonRepeatableN2(String string) {
        if (string == null || string.length() < 2) {
            return true;
        }

        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
