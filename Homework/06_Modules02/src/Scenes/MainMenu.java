package Scenes;

import Scenes.UI.ExitGameButton;
import Scenes.UI.StartGameButton;

import javax.swing.*;

public class MainMenu extends Scene {
    public MainMenu(JFrame frame) {
        super(frame);
        initialize();
    }

    private void initialize() {
        setLayout(null);
        StartGameButton startGameButton = new StartGameButton(this.frame, "Start Game");
        ExitGameButton exitGameButton = new ExitGameButton("Exit Game");
        startGameButton.setLocation(200, 100);
        exitGameButton.setLocation(200, 250);
        add(startGameButton);
        add(exitGameButton);
    }
}
