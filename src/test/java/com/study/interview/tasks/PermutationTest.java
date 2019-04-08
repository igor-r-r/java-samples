package com.study.interview.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationTest {

    private Permutation permutation;

    @Before
    public void setup() {
        permutation = new Permutation();
    }

    @Test
    public void shouldReturnTrueForOneCharacterString() {
        String oneCharStringSource = "a";
        String oneCharStringTarget = "a";

        boolean actualResult = permutation.isPermutation(oneCharStringSource, oneCharStringTarget);

        assertTrue(actualResult);

    }

    @Test
    public void shouldReturnTrueForMoreThanOneCharacterStrings() {
        String source = "abcde";
        String target = "bcaed";

        boolean actualResult = permutation.isPermutation(source, target);

        assertTrue(actualResult);

    }

    @Test
    public void shouldReturnFalseForNonPermutationStrings() {
        String source = "abcde";
        String target = "bcaea";

        boolean actualResult = permutation.isPermutation(source, target);

        assertFalse(actualResult);

    }

    @Test
    public void shouldReturnFalseForStringsWithDifferentLength() {
        String source = "abcde";
        String target = "bcaedjk";

        boolean actualResult = permutation.isPermutation(source, target);

        assertFalse(actualResult);

    }


}