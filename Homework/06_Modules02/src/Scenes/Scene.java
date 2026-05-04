package Scenes;

import javax.swing.*;

public abstract class Scene extends JPanel {
    protected final JFrame frame;

    public Scene(JFrame frame) {
       this.frame = frame;
    }
}
