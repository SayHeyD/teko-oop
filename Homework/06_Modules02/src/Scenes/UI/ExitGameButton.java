package Scenes.UI;

import Scenes.GameScene;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExitGameButton  extends JButton {
    public ExitGameButton(String text) {
        super(text);
        this.setSize(400,100);
        this.setVisible(true);
        this.addActionListener(this::handleActionEvent);
    }

    private void handleActionEvent(ActionEvent e) {
        System.exit(0);
    }
}
