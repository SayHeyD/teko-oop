package Pieces.Movements;

import Board.Chessboard;
import Board.Field;
import Pieces.Piece;

import java.util.List;

public interface SlidingMovement {
    default void addSlidingMoves(List<Field> moves, Piece piece, int[][] directions) {
        Field currentField = piece.getField();
        if (currentField == null) return;

        int x = currentField.getCoordinates()[0];
        int y = currentField.getCoordinates()[1];

        for (int[] dir : directions) {
            for (int i = 1; i < 8; i++) {
                int nextX = x + dir[0] * i;
                int nextY = y + dir[1] * i;

                Field targetField = Chessboard.getField(nextX, nextY);
                if (targetField == null) break;

                if (targetField.getPiece() == null) {
                    moves.add(targetField);
                } else {
                    if (targetField.getPiece().getColor() != piece.getColor()) {
                        moves.add(targetField);
                    }
                    break; // Blocked by piece (friendly or enemy)
                }
            }
        }
    }
}
