package Board;

import Pieces.Piece;

public class Field {
    private final int[] coordinates;
    private Piece piece;

    public Field(int x_coord, int y_coord) {
        this.coordinates = new int[]{x_coord, y_coord};
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;

        if (this.piece != null) {
            this.piece.setField(this);
        }
    }

    @Override
    public String toString() {
        if (piece == null) {
            return String.format("(%d, %d) has no piece", coordinates[0], coordinates[1]);
        }

        return String.format("(%d, %d) has piece %s %s", coordinates[0], coordinates[1], piece.getColor(), piece.getName());
    }
}
