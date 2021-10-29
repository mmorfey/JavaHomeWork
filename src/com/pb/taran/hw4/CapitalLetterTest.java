package com.pb.taran.hw4;

import org.junit.jupiter.api.Assertions;

class CapitalLetterTest {

    @org.junit.jupiter.api.Test
    void upperCaseFirstLetters() {
        String text = "Test Message";
        CapitalLetter upperCase = new CapitalLetter();
        upperCase.toUpperCase(text);
        Assertions.assertEquals("Test Message", text);
    }
}