package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
        this.name = "knight";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        // Define all possible moves for the knight
        int[][] possibleMovesCoordinates = new int[][]{
                {
                    getField().getCoordinates()[0] + 2,
                    getField().getCoordinates()[1] + 1
                },

                {
                    getField().getCoordinates()[0] + 2,
                    getField().getCoordinates()[1] - 1
                },

                {
                    getField().getCoordinates()[0] + 1,
                    getField().getCoordinates()[1] + 2
                },

                {
                    getField().getCoordinates()[0] - 1,
                    getField().getCoordinates()[1] + 2
                },

                {
                    getField().getCoordinates()[0] - 2,
                    getField().getCoordinates()[1] + 1
                },

                {
                    getField().getCoordinates()[0] - 2,
                    getField().getCoordinates()[1] - 1
                },

                {
                    getField().getCoordinates()[0] + 1,
                    getField().getCoordinates()[1] - 2
                },

                {
                    getField().getCoordinates()[0] - 1,
                    getField().getCoordinates()[1] - 2
                },
        };

        for (int[] coordinates : possibleMovesCoordinates) {
            Field field = Chessboard.getField(coordinates);
            // Check if the field exists
            if (field == null) {
                continue;
            }

            // Check if the field is not empty and contains an ally
            if (field.getPiece() != null && field.getPiece().getColor() == getColor()) {
                continue;
            }

            possibleMoves.add(field);
        }

        return possibleMoves.toArray(new Field[0]);
    }
}
