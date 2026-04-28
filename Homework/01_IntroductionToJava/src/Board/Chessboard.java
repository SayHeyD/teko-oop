package Board;

import Pieces.*;

import java.util.ArrayList;

// Board coordinate system is drawn from top left (0, 0) to bottom right (7, 7)
public class Chessboard {
    private static final Field[][] fields;
    private static final ArrayList<Piece> capturedPieces = new ArrayList<>();

    static {
        // Generate the chessboard
        fields = new Field[8][8];
        for (int x_coord = 0; x_coord < 8; x_coord++) {
            for (int y_coord = 0; y_coord < 8; y_coord++) {
                fields[x_coord][y_coord] = new Field(x_coord, y_coord);
            }
        }

        // Set the pieces on the board

        // Black side
        fields[0][0].setPiece(new Rook(Color.BLACK));
        fields[1][0].setPiece(new Knight(Color.BLACK));
        fields[2][0].setPiece(new Bishop(Color.BLACK));
        fields[3][0].setPiece(new Queen(Color.BLACK));
        fields[4][0].setPiece(new King(Color.BLACK));
        fields[5][0].setPiece(new Bishop(Color.BLACK));
        fields[6][0].setPiece(new Knight(Color.BLACK));
        fields[7][0].setPiece(new Rook(Color.BLACK));

        for (int x_coord = 0; x_coord < 8; x_coord++) {
            fields[x_coord][1].setPiece(new Pawn(Color.BLACK));
        }

        // White side
        fields[0][7].setPiece(new Rook(Color.WHITE));
        fields[1][7].setPiece(new Knight(Color.WHITE));
        fields[2][7].setPiece(new Bishop(Color.WHITE));
        fields[3][7].setPiece(new Queen(Color.WHITE));
        fields[4][7].setPiece(new King(Color.WHITE));
        fields[5][7].setPiece(new Bishop(Color.WHITE));
        fields[6][7].setPiece(new Knight(Color.WHITE));
        fields[7][7].setPiece(new Rook(Color.WHITE));

        for (int x_coord = 0; x_coord < 8; x_coord++) {
            fields[x_coord][6].setPiece(new Pawn(Color.WHITE));
        }
    }

    public static Field[][] getFields() {
        return fields;
    }

    public static ArrayList<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public static Field getField(int x_coord, int y_coord) {
        if (x_coord < 0 || x_coord > 7 || y_coord < 0 || y_coord > 7) {
            return null;
        }

        return fields[x_coord][y_coord];
    }

    public static Field getField(int[] coordinates) {
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Coordinates must be of length 2");
        }

        if (coordinates[0] < 0 || coordinates[0] > 7 || coordinates[1] < 0 || coordinates[1] > 7) {
            return null;
        }

        return fields[coordinates[0]][coordinates[1]];
    }

    public static String output() {
        String[] rows = new String[8];

        for (Field[] fieldColumn : fields) {
            for (Field field : fieldColumn) {
                if (rows[field.getCoordinates()[1]] == null) {
                    rows[field.getCoordinates()[1]] = String.format("[%s]", field);
                    continue;
                }

                rows[field.getCoordinates()[1]] =
                        String.join(", ", rows[field.getCoordinates()[1]], String.format("[%s]", field));
            }
        }

        return String.join("\n", rows);
    }

    public static void finishGame(Color winner) {
        System.out.println(output());
        System.out.println();
        System.out.printf("Game over! %s won!%n", winner);
        System.exit(0);
    }
}
