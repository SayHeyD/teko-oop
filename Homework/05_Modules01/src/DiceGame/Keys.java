package DiceGame;

import java.awt.event.KeyEvent;

public class Keys extends SimplifiedListener {
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Rolling dice...");
            DiceGame.frame.getDice().rollDice();
            DiceGame.frame.getDice().drawDice(DiceGame.frame.getGraphics());
            DiceGame.frame.repaint();
        }
    }
}
