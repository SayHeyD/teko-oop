package Pieces;

import Board.Field;

public class King extends Piece {
    public King(Color color) {
        super(color);
        this.name = "king";
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
