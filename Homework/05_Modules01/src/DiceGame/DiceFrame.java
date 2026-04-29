package DiceGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class DiceFrame extends JFrame {
    private final Dice dice;

    public DiceFrame() {
        super("Dice Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dice = new Dice(100, 100);
        setVisible(true);
        addKeyListener(new Keys());
    }

    public void paint(Graphics graphics) {
         dice.drawDice(graphics);
    }

    protected Dice getDice() {
        return dice;
    }
}
