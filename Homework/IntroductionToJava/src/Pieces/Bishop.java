package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;

public class Bishop extends Piece implements SlidingMovement {
    public Bishop(Color color) {
        super(color);
        this.name = "bishop";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();
        
        // Diagonal directions: (1,1), (1,-1), (-1,1), (-1,-1)
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        addSlidingMoves(possibleMoves, this, directions);

        return possibleMoves.toArray(new Field[0]);
    }
}
