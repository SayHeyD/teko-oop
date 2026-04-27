package Pieces;

import Board.Field;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
        this.name = "bishop";
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
