package DiceGame;

import java.awt.*;

public class Dice {
    private final int x_coord;
    private final int y_coord;

    private int rolledValue;

    private static final int SIZE = 60;
    private static final int DOT_SIZE = 10;

    public Dice(int x_coord, int y_coord) {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        rollDice();
    }

    public int getX() {
        return x_coord;
    }

    public int getY() {
        return y_coord;
    }

    public int getRolledValue() {
        return rolledValue;
    }

    protected void drawDice(Graphics graphics) {
        drawBody(graphics);
        drawDots(graphics, rolledValue);
    }

    private void drawBody(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRoundRect(x_coord, y_coord, SIZE, SIZE, 15, 15);
        graphics.setColor(Color.BLACK);
        graphics.drawRoundRect(x_coord, y_coord, SIZE, SIZE, 15, 15);
    }

    private void drawDots(Graphics graphics, int dots) {
        graphics.setColor(Color.BLACK);

        int left = x_coord + SIZE / 4 - DOT_SIZE / 2;
        int center = x_coord + SIZE / 2 - DOT_SIZE / 2;
        int right = x_coord + 3 * SIZE / 4 - DOT_SIZE / 2;
        int top = y_coord + SIZE / 4 - DOT_SIZE / 2;
        int mid = y_coord + SIZE / 2 - DOT_SIZE / 2;
        int bottom = y_coord + 3 * SIZE / 4 - DOT_SIZE / 2;

        if (dots == 1 || dots == 3 || dots == 5) {
            graphics.fillOval(center, mid, DOT_SIZE, DOT_SIZE); // Center
        }
        if (dots >= 2) {
            graphics.fillOval(left, top, DOT_SIZE, DOT_SIZE); // Top-left
            graphics.fillOval(right, bottom, DOT_SIZE, DOT_SIZE); // Bottom-right
        }
        if (dots >= 4) {
            graphics.fillOval(right, top, DOT_SIZE, DOT_SIZE); // Top-right
            graphics.fillOval(left, bottom, DOT_SIZE, DOT_SIZE); // Bottom-left
        }
        if (dots == 6) {
            graphics.fillOval(left, mid, DOT_SIZE, DOT_SIZE); // Middle-left
            graphics.fillOval(right, mid, DOT_SIZE, DOT_SIZE); // Middle-right
        }
    }

    protected void rollDice() {
        rolledValue = 1 + (int)(Math.random() * 6);
    }
}
