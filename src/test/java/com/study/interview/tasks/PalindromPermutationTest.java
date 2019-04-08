package com.study.interview.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromPermutationTest {

    private PalindromPermutation palindromPermutation;

    @Before
    public void setUp() throws Exception {
        palindromPermutation = new PalindromPermutation();
    }

    @Test
    public void shouldReturnTrueForValidString3Chars() {
        String input = "aba";

        assertTrue(palindromPermutation.isPalindromPermutationFast(input));
    }

    @Test
    public void shouldReturnTrueForValidString4Chars() {
        String input = "abab";

        assertTrue(palindromPermutation.isPalindromPermutationFast(input));
    }

    @Test
    public void shouldReturnTrueForValidString9Chars() {
        String input = "adbdabdad";

        assertTrue(palindromPermutation.isPalindromPermutationFast(input));
    }

    @Test
    public void shouldReturnTrueForValidString10Chars() {
        String input = "adbdabdada";

        assertTrue(palindromPermutation.isPalindromPermutationFast(input));
    }

    @Test
    public void shouldReturnFalseForInvalidString10Chars() {
        String input = "acbdabdada";

        assertFalse(palindromPermutation.isPalindromPermutationFast(input));
    }
}