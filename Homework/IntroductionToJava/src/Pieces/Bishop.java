package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
        this.name = "bishop";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();
        Field currentField = getField();

        int x = currentField.getCoordinates()[0];
        int y = currentField.getCoordinates()[1];

        // Diagonal directions: (1,1), (1,-1), (-1,1), (-1,-1)
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int[] dir : directions) {
            for (int i = 1; i < 8; i++) {
                int nextX = x + dir[0] * i;
                int nextY = y + dir[1] * i;

                Field targetField = Chessboard.getField(nextX, nextY);

                // Check if the next move is out of bounds
                if (targetField == null) {
                    break;
                }

                // If the target field is empty, allow the move
                if (targetField.getPiece() == null) {
                    possibleMoves.add(Chessboard.getField(nextX, nextY));
                    continue;
                }

                // If the target field is occupied by an enemy piece
                // allow the move but no further movements
                if (targetField.getPiece() != null && targetField.getPiece().getColor() != getColor()) {
                    possibleMoves.add(Chessboard.getField(nextX, nextY));
                    break;
                }

                // If the target field is occupied by the same color as the bishop,
                // do not allow the move or further movements
                if (targetField.getPiece() != null && targetField.getPiece().getColor() == getColor()) {
                    break;
                }
            }
        }

        return possibleMoves.toArray(new Field[0]);
    }
}
