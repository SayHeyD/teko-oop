package Introduction;

import Board.Chessboard;
import Pieces.Bishop;
import Pieces.King;

import java.util.Arrays;

public class IntroductionToJava {

    public static void main(String[] args) {
        IO.println(Chessboard.output());

        King king = (King) Chessboard.getFields()[4][4].getPiece();
        IO.println("Allowed moves:");
        IO.println(Arrays.toString(king.getMoves()));
    }
}