package com.study.interview.tasks;

import java.util.HashMap;

public class Permutation {


    public boolean isPermutation(String source, String target) {
        if (source == null || target == null) {
            return false;
        }

        if (source.length() != target.length()) {
            return false;
        }

        HashMap<Character, Integer> sourceSymbols = new HashMap<>();
        HashMap<Character, Integer> targetSymbols = new HashMap<>();

        for (int i = 0; i < source.length(); i++) {
            Character sourceChar = source.charAt(i);
            int sourceCount = sourceSymbols.getOrDefault(sourceChar, 0);

            sourceSymbols.put(sourceChar, sourceCount + 1);

            Character targetChar = target.charAt(i);
            int targetCount = targetSymbols.getOrDefault(targetChar, 0);

            targetSymbols.put(targetChar, targetCount + 1);
        }

        if (sourceSymbols.size() != targetSymbols.size()) {
            return false;
        }

        for (Character c : sourceSymbols.keySet()) {
            if (!sourceSymbols.get(c).equals(targetSymbols.get(c))) {
                return false;
            }
        }

        return true;
    }
}
