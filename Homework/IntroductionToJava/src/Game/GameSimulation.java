package Game;

import Board.Chessboard;
import Board.Field;
import Pieces.Color;
import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSimulation {
    private Color currentTurn = Color.WHITE;
    private final Random random = new Random();
    private boolean verbose = false;

    public GameSimulation(boolean verbose) {
        this.verbose = verbose;
    }

    public void play() {
        System.out.println("Starting Chess Game Simulation...");
        if (verbose) {
            System.out.println(Chessboard.output());
        }
        System.out.println("--------------------------------");

        int moveCount = 0;
        while (true) {
            moveCount++;
            System.out.println("Move " + moveCount + ": " + currentTurn + "'s turn");

            boolean moveMade = makeRandomMove();

            if (!moveMade) {
                System.out.println("No valid moves for " + currentTurn + ". Game over!");
                break;
            }

            if (verbose) {
                System.out.println(Chessboard.output());
            }
            System.out.println("--------------------------------");

            // Turn switching is implicitly handled or needs explicit handling if makeRandomMove doesn't do it
            currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;

            if (verbose) {
                try {
                    Thread.sleep(100); // Slow down for readability
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private boolean makeRandomMove() {
        List<PieceMove> allPossibleMoves = getAllPossibleMoves(currentTurn);

        if (allPossibleMoves.isEmpty()) {
            return false;
        }

        PieceMove selectedMove = allPossibleMoves.get(random.nextInt(allPossibleMoves.size()));
        System.out.println("Selected move: " + selectedMove.piece.getName() + " to " + 
                           selectedMove.targetField.getCoordinates()[0] + "," + selectedMove.targetField.getCoordinates()[1]);
        
        return selectedMove.piece.move(selectedMove.targetField);
    }

    private List<PieceMove> getAllPossibleMoves(Color color) {
        List<PieceMove> moves = new ArrayList<>();
        Field[][] fields = Chessboard.getFields();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = fields[x][y].getPiece();
                if (piece != null && piece.getColor() == color) {
                    Field[] possibleFields = piece.getMoves();
                    for (Field target : possibleFields) {
                        moves.add(new PieceMove(piece, target));
                    }
                }
            }
        }
        return moves;
    }

    private static class PieceMove {
        Piece piece;
        Field targetField;

        PieceMove(Piece piece, Field targetField) {
            this.piece = piece;
            this.targetField = targetField;
        }
    }

    public static void main(String[] args) {
        boolean verbose = false;
        for (String arg : args) {
            if ("--verbose".equals(arg)) {
                verbose = true;
                break;
            }
        }
        new GameSimulation(verbose).play();
    }
}
