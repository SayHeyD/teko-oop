package Pieces;

import Board.Field;
import Pieces.Movements.StepMovement;

import java.util.ArrayList;

public class Knight extends Piece implements StepMovement {
    public Knight(Color color) {
        super(color);
        this.name = "knight";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        // Define all possible moves for the knight
        int[][] offsets = {
                {2, 1}, {2, -1}, {1, 2}, {-1, 2},
                {-2, 1}, {-2, -1}, {1, -2}, {-1, -2}
        };

        addStepMoves(possibleMoves, this, offsets);

        return possibleMoves.toArray(new Field[0]);
    }
}
