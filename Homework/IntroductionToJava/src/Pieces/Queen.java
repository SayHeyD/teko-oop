package Pieces;

import Board.Field;

import java.util.ArrayList;

public class Queen extends Piece implements SlidingMovement {
    public Queen(Color color) {
        super(color);
        this.name = "queen";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Rook-like
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Bishop-like
        };

        addSlidingMoves(possibleMoves, this, directions);

        return possibleMoves.toArray(new Field[0]);
    }
}
