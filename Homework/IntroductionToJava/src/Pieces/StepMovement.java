package Pieces;

import Board.Chessboard;
import Board.Field;
import java.util.List;

public interface StepMovement {
    default void addStepMoves(List<Field> moves, Piece piece, int[][] offsets) {
        Field currentField = piece.getField();
        if (currentField == null) return;

        int x = currentField.getCoordinates()[0];
        int y = currentField.getCoordinates()[1];

        for (int[] offset : offsets) {
            int nextX = x + offset[0];
            int nextY = y + offset[1];

            Field targetField = Chessboard.getField(nextX, nextY);
            if (targetField != null) {
                if (targetField.getPiece() == null || targetField.getPiece().getColor() != piece.getColor()) {
                    moves.add(targetField);
                }
            }
        }
    }
}
