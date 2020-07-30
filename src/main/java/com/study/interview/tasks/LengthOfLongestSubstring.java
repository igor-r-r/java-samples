package com.study.interview.tasks;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String input) {
        /*
        Options:
            1. Brute force through all chars
            2. ???
         */

        if (input == null )
            return 0;

        if (input.length() == 1) {
            return 1;
        }

        int max = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            Set<Character> foundChars = new HashSet<>();
            foundChars.add(input.charAt(i));

            for (int j = i + 1; j < input.length(); j++) {
                if (foundChars.contains(input.charAt(j))) {
                    if (max < j - i) {
                        max = j - i;
                    }
                    break;
                }
                else if (j == input.length() - 1) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                    }
                }
                foundChars.add(input.charAt(j));
            }
        }

        return max;
    }

}
