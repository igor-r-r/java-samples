package com.study.interview.tasks;

import java.util.HashMap;
import java.util.Map;

public class PalindromPermutation {

    public boolean isPalindromPermutationFast(String string) {
        if (string == null) {
            return false;
        }

        if (string.length() < 2) {
            return true;
        }

        string = string.toLowerCase();

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : string.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        if (string.length() % 2 == 1) {
            return charCountMap.values().stream().filter(c -> c % 2 == 1).count() == 1;
        } else {
            return charCountMap.values().stream().allMatch(c -> c % 2 == 0);
        }

    }

}
