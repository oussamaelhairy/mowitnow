package org.mowitnow.model;

import java.util.List;


//Classe qui représente une tondeuse avec sa position, orientation et pelouse
public class Mower {
    private Position position;
    private Orientation orientation;
    private final Lawn lawn;

    public Mower(Position position, Orientation orientation, Lawn lawn) {
        if (position == null || orientation == null || lawn == null) {
            throw new IllegalArgumentException("Les attributs ne peuvent pas être null");
        }
        if (!lawn.isPositionWithinBounds(position)) {
            throw new IllegalArgumentException("Position de départ hors pelouse");
        }
        this.position = position;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void turnLeft() {
        this.orientation = orientation.turnLeft();
    }

    public void turnRight() {
        this.orientation = orientation.turnRight();
    }

    //déplacement de la tondeuse dependemment de l'orientation
    public void move() {
        Position newPosition = switch (orientation) {
            case N -> position.moveNorth();
            case E -> position.moveEast();
            case S -> position.moveSouth();
            case W -> position.moveWest();
        };

        if(lawn.isPositionWithinBounds(newPosition)) {
            this.position = newPosition;
        }
    }

    //Execution d'une chaine de commande
    public void executeCommand(String command) {
        List<Character> commands = command.chars()
                .mapToObj(i -> (char) i)
                .toList();
        for (Character commandChar : commands) {
            switch (commandChar) {
                case 'D' -> this.turnRight();
                case 'G' -> this.turnLeft();
                case 'A' -> this.move();
                default -> throw new IllegalArgumentException("Lettre Invalide: " + commandChar);
            }
        }
    }

    public static Mower fromStringAndLawn(String input, Lawn lawn) {
        String[] coordinates = input.split(" ");
        Position position = new Position(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        Orientation orientation = Orientation.valueOf(coordinates[2]);
        return new Mower(position, orientation, lawn);
    }

    @Override
    public String toString() {
        return position.toString() + " " + orientation;
    }
}
