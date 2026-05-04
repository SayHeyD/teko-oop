package Scenes.UI;

import Scenes.GameScene;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartGameButton extends JButton {
    private final JFrame frame;

    public StartGameButton(JFrame frame, String text) {
        super(text);
        this.frame = frame;
        this.setSize(400,100);
        this.setVisible(true);
        this.addActionListener(this::handleActionEvent);
    }

    private void handleActionEvent(ActionEvent e) {
        frame.setContentPane(new GameScene(frame));
        frame.revalidate();
        System.out.println("Start Game");
    }
}
