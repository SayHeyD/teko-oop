package Pieces;

import Board.Chessboard;
import Board.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
        this.name = "pawn";
    }

    @Override
    public Field[] getMoves() {
        ArrayList<Field> possibleMoves = new ArrayList<>();

        boolean oneForwardIsAllowed = checkMoveForwardOnce(possibleMoves);

        // Only check if the pawn can move twice if it is the first move and
        // the moving forward once is not blocked
        if (oneForwardIsAllowed && ! hasMoved()) {
            checkMoveForwardTwice(possibleMoves);
        }

        // Check if the pawn can capture any pieces
        checkCapture(possibleMoves, "left");
        checkCapture(possibleMoves, "right");

        return possibleMoves.toArray(new Field[0]);
    }

    private boolean checkMoveForwardOnce(ArrayList<Field> possibleMoves) {
        // Define the field the pawn moving forward to
        Field oneForward = Chessboard.getField(
                getField().getCoordinates()[0],
                isMovingInPositiveDirection() ? getField().getCoordinates()[1] + 1 : getField().getCoordinates()[1] - 1
        );

        // Check if the field exists and is empty. If not empty, the pawn cannot move forward
        if (oneForward != null && oneForward.getPiece() == null) {
            possibleMoves.add(oneForward);
            return true;
        }

        return false;
    }

    private boolean checkMoveForwardTwice(ArrayList<Field> possibleMoves) {
        // Define the field the pawn moving forward to
        Field twoForward = Chessboard.getField(
                getField().getCoordinates()[0],
                isMovingInPositiveDirection() ? getField().getCoordinates()[1] + 2 : getField().getCoordinates()[1] - 2
        );

        // Check if the field exists and is empty. If not empty, the pawn cannot move forward
        if (twoForward != null && twoForward.getPiece() == null) {
            possibleMoves.add(twoForward);
            return true;
        }

        return false;
    }

    private boolean checkCapture(ArrayList<Field> possibleMoves, String direction) {
        // Define in which direction the capture would occur
        int captureCoordX;

        if (Objects.equals(direction, "left")) {
            captureCoordX = getField().getCoordinates()[0] - 1;
        } else if (Objects.equals(direction, "right")) {
            captureCoordX = getField().getCoordinates()[0] + 1;
        } else {
            throw new IllegalArgumentException("Direction must be either 'left' or 'right'");
        }

        // Define the field the pawn moving to
        Field captureMove = Chessboard.getField(
                captureCoordX,
                isMovingInPositiveDirection() ? getField().getCoordinates()[1] + 1 : getField().getCoordinates()[1] - 1
        );

        // Check if the field exists and is occupied by a piece
        if (captureMove == null || captureMove.getPiece() == null) {
            return false;
        }

        // Check if the piece is the same color as the pawn
        if (captureMove.getPiece().getColor() == getColor()) {
            return false;
        }

        // If field is occupied by an enemy piece, add it to the possible moves
        possibleMoves.add(captureMove);
        return true;
    }
}
