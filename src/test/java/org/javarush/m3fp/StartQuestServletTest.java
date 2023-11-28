package org.javarush.m3fp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartQuestServletTest {

    @Test
    void doGet() {
    }

    @Test
    void nickname() {
        String inputValueNickname = "Name";
        String expected = "Name";

        assertEquals(expected,inputValueNickname);
    }

    @Test
    void logicGame() {
    }
}