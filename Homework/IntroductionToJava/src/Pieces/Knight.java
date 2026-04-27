package Pieces;

import Board.Field;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
        this.name = "knight";
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
