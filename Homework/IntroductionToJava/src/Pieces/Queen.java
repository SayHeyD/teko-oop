package Pieces;

import Board.Field;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
        this.name = "queen";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        // TODO: Implement queen's move logic

        return possibleMoves.toArray(new Field[0]);
    }
}
