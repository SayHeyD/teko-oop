package Pieces;

import Board.Chessboard;
import Board.Direction;
import Board.Field;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        this.name = "rook";
    }

    @Override
    public boolean move(Field field) {
        return false;
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        // Get the maximum distances the rook could travel if the board is empty
        int distanceToLeftBorder = getField().getCoordinates()[0];
        int distanceToRightBorder = 8 - getField().getCoordinates()[0] - 1;
        int distanceToTopBorder = getField().getCoordinates()[1];
        int distanceToBottomBorder = 8 - getField().getCoordinates()[1] - 1;

        getValidMovesByDirection(possibleMoves, Direction.LEFT, distanceToLeftBorder);
        getValidMovesByDirection(possibleMoves, Direction.RIGHT, distanceToRightBorder);
        getValidMovesByDirection(possibleMoves, Direction.UP, distanceToTopBorder);
        getValidMovesByDirection(possibleMoves, Direction.DOWN, distanceToBottomBorder);

        return possibleMoves.toArray(new Field[0]);
    }

    private boolean getValidMovesByDirection(ArrayList<Field> possibleMoves, Direction direction, int borderDistance) {
        // Start iteration at 1 because the field "0" is the current field
        for (int i = 1; i <= borderDistance; i++) {
            Field targetField = switch (direction) {
                case LEFT -> Chessboard.getField(getField().getCoordinates()[0] - i, getField().getCoordinates()[1]);
                case RIGHT -> Chessboard.getField(getField().getCoordinates()[0] + i, getField().getCoordinates()[1]);
                case UP -> Chessboard.getField(getField().getCoordinates()[0], getField().getCoordinates()[1] - i);
                case DOWN -> Chessboard.getField(getField().getCoordinates()[0], getField().getCoordinates()[1] + i);
            };

            // Allow the rook to move to empty fields
            if (targetField.getPiece() == null) {
                possibleMoves.add(targetField);
                continue;
            }

            // Allow the rook to capture enemy pieces but do not extend
            // the movement range beyond the first enemy piece
            if (targetField.getPiece().getColor() != getColor()) {
                possibleMoves.add(targetField);
                return true;
            }

            // Prevent the rook from moving through its own pieces
            if (targetField.getPiece() != null && targetField.getPiece().getColor() == getColor()) {
                return true;
            }
        }

        return false;
    }
}
