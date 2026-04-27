package Introduction;

import Board.Chessboard;
import Pieces.Pawn;

import java.util.Arrays;

public class IntroductionToJava {

    public static void main(String[] args) {
        IO.println(Chessboard.output());

        Pawn pawn = (Pawn) Chessboard.getFields()[0][1].getPiece();
        pawn.move(Chessboard.getFields()[0][3]);
        IO.println(Arrays.toString(pawn.getMoves()));

        IO.println(Chessboard.output());
    }
}