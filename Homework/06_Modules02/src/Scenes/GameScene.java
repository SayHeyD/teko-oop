package Scenes;

import Scenes.UI.StartGameButton;

import javax.swing.*;

public class GameScene extends Scene {
    public GameScene(JFrame frame) {
        super(frame);
        initialize();
    }

    private void initialize() {
        setLayout(null);
        JLabel label = new JLabel("Game Scene");
         label.setBounds(100, 100, 200, 200);
         add(label);
    }
}
