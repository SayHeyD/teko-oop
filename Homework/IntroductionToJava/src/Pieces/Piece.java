package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.Arrays;

public abstract class Piece {
    protected String name;
    private final Color color;
    private Field field;
    private boolean isFirstMove = true;

    public Piece(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean hasMoved() {
        return !isFirstMove;
    }

    protected boolean isMovingInPositiveDirection() {
        return getColor() == Color.BLACK;
    }

    public Field getField() {
        return field;
    }

    protected void capture() {
        Chessboard.getCapturedPieces().add(this);
    }

    public boolean move(Field field) {
        Field[] allowedMoves = getMoves();

        if (Arrays.asList(allowedMoves).contains(field)) {

            if (field.getPiece() != null) {
                field.getPiece().capture();
            }

            getField().setPiece(null);
            field.setPiece(this);
            isFirstMove = false;
            return true;
        }

        return false;
    }

    public abstract Field[] getMoves();

    @Override
    public String toString() {
        return String.format("{%s, %s, [%d, %d]}", color, name, field.getCoordinates()[0], field.getCoordinates()[1]);
    }
}
