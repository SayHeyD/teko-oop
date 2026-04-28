package Board;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static Direction fromString(String direction) {
        return Direction.valueOf(direction.toUpperCase());
    }
}
