package Pieces;

public enum Color {
    WHITE, BLACK;

    @Override
    public String toString() {
        return this == WHITE ? "white" : "black";
    }
}
