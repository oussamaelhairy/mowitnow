package org.mowitnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void shouldCreatePosition() {
        int x = 5;
        int y = 5;

        Position p = new Position(x, y);

        assertEquals(5, p.x());
        assertEquals(5, p.y());
    }

    @Test
    void shouldThrowExceptionForNegativeX() {
        int x = -5;
        int y = 5;
        
        assertThrows(IllegalArgumentException.class, () -> {
            Position p = new Position(x, y);
        });
    }

    @Test
    void shouldThrowExceptionForNegativeY() {
        int x = 5;
        int y = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            Position p = new Position(x, y);
        });
    }

    @Test
    void shouldMoveNorth() {
        Position position = new Position(2, 3);

        Position newPosition = position.moveNorth();

        assertEquals(2, newPosition.x());
        assertEquals(4, newPosition.y());
    }

    @Test
    void shouldMoveEast() {
        Position position = new Position(2, 3);

        Position newPosition = position.moveEast();

        assertEquals(3, newPosition.x());
        assertEquals(3, newPosition.y());
    }

    @Test
    void shouldMoveSouth() {
        Position position = new Position(2, 3);

        Position newPosition = position.moveSouth();

        assertEquals(2, newPosition.x());
        assertEquals(2, newPosition.y());
    }

    @Test
    void shouldMoveWest() {
        Position position = new Position(2, 3);

        Position newPosition = position.moveWest();

        assertEquals(1, newPosition.x());
        assertEquals(3, newPosition.y());
    }

    @Test
    void shouldBeInInitialPosition() {
        Position position = new Position(0, 0);

        assertTrue(position.isInitialPosition());
    }

    @Test
    void shouldNotBeInInitialPosition() {
        Position position = new Position(1, 1);

        assertFalse(position.isInitialPosition());
    }

    @Test
    void shouldBeWithinBounds() {
        Position position = new Position(2, 3);
        Position upperRight = new Position(5, 5);

        assertTrue(position.isWithinBounds(upperRight));
    }

    @Test
    void shouldNotBeWithinBounds() {
        Position position = new Position(6, 3);
        Position upperRight = new Position(5, 5);

        assertFalse(position.isWithinBounds(upperRight));
    }

    @Test
    void shouldCreatePositionFromString() {
        String coordinates = "2 3";


        Position newPosition = Position.fromString(coordinates);

        assertEquals(2, newPosition.x());
        assertEquals(3, newPosition.y());
    }

    @Test
    void shouldNotCreatePositionFromString() {
        String coordinates = "2 B";

        assertThrows(IllegalArgumentException.class, () -> {
            Position p = Position.fromString(coordinates);
        });
    }
}