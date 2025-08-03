package org.mowitnow.model;

public record Lawn(Position upperRight) {

    public Lawn {
        if(upperRight == null) {
            throw new IllegalArgumentException("Coin supérieur ne peut pas être null");
        }
        if(upperRight.isInitialPosition()) {
            throw new IllegalArgumentException("Coordonnées du coin inférieur gauche ne peuvent pas être celles du supérieur");
        }
    }

    public boolean isPositionWithinBounds(Position position) {
        return position.isWithinBounds(upperRight);
    }

    public static Lawn fromString(String input) {
        return new Lawn(Position.fromString(input));
    }
}
