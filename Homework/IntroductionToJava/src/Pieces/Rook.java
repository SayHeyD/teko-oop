package Pieces;

import Board.Field;
import Pieces.Movements.SlidingMovement;

import java.util.ArrayList;

public class Rook extends Piece implements SlidingMovement {

    public Rook(Color color) {
        super(color);
        this.name = "rook";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        addSlidingMoves(possibleMoves, this, directions);

        return possibleMoves.toArray(new Field[0]);
    }
}
