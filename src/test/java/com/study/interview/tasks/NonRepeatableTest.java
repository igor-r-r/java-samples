package com.study.interview.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonRepeatableTest {

    private NonRepeatable nonRepeatable;

    @Before
    public void setup() {
        nonRepeatable = new NonRepeatable();
    }

    @Test
    public void shouldReturnTrueForAnEmptyString() {
        String emptyString = "";

        boolean expectedResult = true;
        boolean actualResult = nonRepeatable.isNonRepeatable(emptyString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnTrueSingleCharacterString() {
        String single = "a";

        boolean expectedResult = true;
        boolean actualResult = nonRepeatable.isNonRepeatable(single);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnTrueForNonRepeatableStringWithLengthMoreThenOne() {
        String single = "abc";

        boolean expectedResult = true;
        boolean actualResult = nonRepeatable.isNonRepeatable(single);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnFalseForRepeatableCharsInString() {
        String single = "aba";

        boolean expectedResult = false;
        boolean actualResult = nonRepeatable.isNonRepeatable(single);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnTrueForRepeatableCamelCase() {
        String single = "aBCA";

        boolean expectedResult = true;
        boolean actualResult = nonRepeatable.isNonRepeatable(single);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnTrueForRepeatableCamelCaseN2() {
        String single = "aBC";

        boolean expectedResult = true;
        boolean actualResult = nonRepeatable.isNonRepeatableN2(single);

        assertEquals(expectedResult, actualResult);
    }

}