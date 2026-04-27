package Pieces;

import Board.Field;
import Pieces.Movements.StepMovement;

import java.util.ArrayList;

public class King extends Piece implements StepMovement {
    public King(Color color) {
        super(color);
        this.name = "king";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        // All 8 possible relative directions for the king
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Horizontal and vertical
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Diagonal
        };

        addStepMoves(possibleMoves, this, directions);

        return possibleMoves.toArray(new Field[0]);
    }
}
