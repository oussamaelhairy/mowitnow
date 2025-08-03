package org.mowitnow.model;

public record Position(int x, int y) {

    public Position {
        if(x < 0 || y < 0)
            throw new IllegalArgumentException("Les coordonnées doivent être positives");
    }

    public Position moveNorth() {
        return new Position(x, y + 1);
    }

    public Position moveEast() {
        return new Position(x + 1, y);
    }

    public Position moveSouth() {
        return new Position(x, y - 1);
    }

    public Position moveWest() {
        return new Position(x - 1, y);
    }

    public boolean isInitialPosition() {
        return x == 0 && y == 0;
    }

    public boolean isWithinBounds(Position upperRight) {
        return x >= 0 && y >= 0 &&
                x <= upperRight.x() && y <= upperRight.y();
    }

    public static Position fromString(String input) {
        String[] coordinates = input.split(" ");
        try {
            return new Position(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format de données invalides");
        }
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
