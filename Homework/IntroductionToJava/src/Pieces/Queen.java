package Pieces;

import Board.Field;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
        this.name = "queen";
    }

    @Override
    public boolean move(Field field) {
        return false;
    }

    @Override
    public Field[] getMoves() {
        return new Field[0];
    }
}
