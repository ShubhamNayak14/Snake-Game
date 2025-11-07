package snakegame;

import javax.swing.*;

public class SnakeGame extends JFrame {

    SnakeGame() {
        super("🐍 Snake Game");
        add(new Board());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SnakeGame().setVisible(true);
        });
    }
}
