package org.mowitnow.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MowerServiceTest {

    @Test
    void shouldExecuteCommands() {
        List<String> inputLines = List.of(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );
        MowerService mowerService = new MowerService();

        String result = mowerService.executeCommands(inputLines);

        assertEquals("1 3 N 5 1 E ", result);
    }

}