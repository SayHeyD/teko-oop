package MeteorGame;

import Scenes.MainMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = initializeFrame();
        MainMenu mainMenu = new MainMenu(frame);
        frame.setContentPane(mainMenu);
        frame.setVisible(true);
    }

    private static JFrame initializeFrame() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Meteor Game ☄️");
        return frame;
    }
}
