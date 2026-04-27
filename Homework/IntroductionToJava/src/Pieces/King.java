package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public class King extends Piece {
    public King(Color color) {
        super(color);
        this.name = "king";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        Field currentField = getField();
        int x = currentField.getCoordinates()[0];
        int y = currentField.getCoordinates()[1];

        // All 8 possible relative directions for the king
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Horizontal and vertical
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Diagonal
        };

        for (int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            Field targetField = Chessboard.getField(nextX, nextY);

            // Do not allow the king to move out of bounds
            if (targetField == null) {
                continue;
            }

            if (targetField.getPiece() == null || targetField.getPiece().getColor() != getColor()) {
                possibleMoves.add(targetField);
            }
        }

        return possibleMoves.toArray(new Field[0]);
    }
}
