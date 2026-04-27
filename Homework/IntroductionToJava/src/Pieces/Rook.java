package Pieces;

import Board.Field;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        this.name = "rook";
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
