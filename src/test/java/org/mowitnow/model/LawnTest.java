package org.mowitnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnTest {

    @Test
    void shouldCreateLawn() {

        Position upperRight = new Position(5, 5);
        Lawn lawn = new Lawn(upperRight);

        assertEquals(5, lawn.upperRight().x());
        assertEquals(5, lawn.upperRight().y());
    }

    @Test
    void shouldThrowExceptionIfPositionNull() {
        Position upperRight = null;

        assertThrows(IllegalArgumentException.class, () -> {
            Lawn lawn = new Lawn(upperRight);
        });
    }

    @Test
    void shouldThrowExceptionIfInitialPosition() {
        Position upperRight = new Position(0, 0);

        assertThrows(IllegalArgumentException.class, () -> {
            Lawn lawn = new Lawn(upperRight);
        });
    }

    @Test
    void shouldPositionBeWithinBounds() {
        Position upperRight = new Position(5, 5);
        Lawn lawn = new Lawn(upperRight);
        Position position = new Position(3, 3);

        assertTrue(lawn.isPositionWithinBounds(position));
    }

    @Test
    void shouldNotPositionBeWithinBounds() {
        Position upperRight = new Position(5, 5);
        Lawn lawn = new Lawn(upperRight);
        Position position = new Position(7, 3);

        assertFalse(lawn.isPositionWithinBounds(position));
    }
}