package org.mowitnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void shouldCreateMower() {
        Position position = new Position(1, 2);
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        Mower mower = new Mower(position, Orientation.N, lawn);

        assertNotNull(mower);

    }

    @Test
    void shouldThrowExceptionIfPositionIsNull() {
        Position position = null;
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        assertThrows(IllegalArgumentException.class, () -> new Mower(position, Orientation.N, lawn));
    }

    @Test
    void shouldThrowExceptionIfLawnIsNull() {
        Position position = new Position(1, 2);;
        Lawn lawn = null;

        assertThrows(IllegalArgumentException.class, () -> new Mower(position, Orientation.N, lawn));
    }

    @Test
    void shouldThrowExceptionIfOrientationIsNull() {
        Position position = new Position(1, 2);
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        assertThrows(IllegalArgumentException.class, () -> new Mower(position, null, lawn));
    }

    @Test
    void shouldMowerTurnRight() {
        Position position = new Position(1, 2);
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        Mower mower = new Mower(position, Orientation.N, lawn);
        mower.turnRight();
        assertEquals(Orientation.E, mower.getOrientation());
    }

    @Test
    void shouldMowerTurnLeft() {
        Position position = new Position(1, 2);
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        Mower mower = new Mower(position, Orientation.N, lawn);
        mower.turnLeft();
        assertEquals(Orientation.W, mower.getOrientation());
    }

    @Test
    void shouldMowerMove() {
        Position position = new Position(1, 2);
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        Mower mower = new Mower(position, Orientation.N, lawn);
        mower.move();

        Position newPosition = new Position(1, 3);
        assertEquals(newPosition.y(), mower.getPosition().y());
        assertEquals(newPosition.x(), mower.getPosition().x());
    }

    @Test
    void shouldNotMowerMove() {
        Position position = new Position(1, 4);
        Position upperRight = new Position(4, 4);
        Lawn lawn = new Lawn(upperRight);

        Mower mower = new Mower(position, Orientation.N, lawn);
        mower.move();

        Position newPosition = new Position(1, 4);
        assertEquals(newPosition.y(), mower.getPosition().y());
        assertEquals(newPosition.x(), mower.getPosition().x());
    }

    @Test
    void shouldExecuteCommand() {
        Position position = new Position(1, 2);
        Position upperRight = new Position(5, 5);
        Lawn lawn = new Lawn(upperRight);
        String command = "GAGAGAGAA";
        Mower mower = new Mower(position, Orientation.N, lawn);

        mower.executeCommand(command);

        assertEquals(1, mower.getPosition().x());
        assertEquals(3, mower.getPosition().y());
        assertEquals(Orientation.N, mower.getOrientation());
    }

    @Test
    void shouldCreateMowerFromStringAndLawn() {

        Position upperRight = new Position(5, 5);
        Lawn lawn = new Lawn(upperRight);
        String input = "1 2 N";

        Mower mower = Mower.fromStringAndLawn(input, lawn);

        assertEquals(1, mower.getPosition().x());
        assertEquals(2, mower.getPosition().y());
        assertEquals(Orientation.N, mower.getOrientation());
    }
}