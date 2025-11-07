//package snakegame;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class Board extends JPanel implements ActionListener {
//    
//    private Image apple;
//    private Image dot;
//    private Image head;
//    
//    private final int ALL_DOTS = 1600;
//    private final int DOT_SIZE = 10;
//    private final int RANDOM_POSITION = 29;
//    
//    private int apple_x;
//    private int apple_y;
//    
//    private final int x[] = new int[ALL_DOTS];
//    private final int y[] = new int[ALL_DOTS];
//    
//    private boolean leftDirection = false;
//    private boolean rightDirection = true;
//    private boolean upDirection = false;
//    private boolean downDirection = false;
//    
//    private boolean inGame = true;
//    
//    private int dots;
//    private Timer timer;
//    
//    Board() {
//        addKeyListener(new TAdapter());
//        
//        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension(500, 500));
//        setFocusable(true);
//        
//        loadImages();
//        initGame();
//    }
//    
//    public void loadImages() {
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
//        apple = i1.getImage();
//        
//        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
//        dot = i2.getImage();
//        
//        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
//        head = i3.getImage();
//    }
//    
//    public void initGame() {
//        dots = 3;
//        
//        for (int i = 0; i < dots; i++) {
//            y[i] = 50;
//            x[i] = 50 - i * DOT_SIZE;
//        }
//        
//        locateApple();
//        
//        timer = new Timer(140, this);
//        timer.start();
//    }
//    
//    public void locateApple() {
//        int r = (int)(Math.random() * RANDOM_POSITION);
//        apple_x = r * DOT_SIZE;
//                
//        r = (int)(Math.random() * RANDOM_POSITION);
//        apple_y = r * DOT_SIZE;
//    }
//    
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        
//        draw(g);
//    }
//    
//    public void draw(Graphics g) {
//        if (inGame) {
//            g.drawImage(apple, apple_x, apple_y, this);
//
//            for (int i = 0 ; i < dots; i++) {
//                if (i == 0) {
//                    g.drawImage(head, x[i], y[i], this);
//                } else {
//                    g.drawImage(dot, x[i], y[i], this);
//                }
//            }
//
//            Toolkit.getDefaultToolkit().sync();
//        } else {
//            gameOver(g);
//        }
//    }
//    
//    public void gameOver(Graphics g) {
//        String msg = "Game Over!";
//        Font font = new Font("SAN_SERIF", Font.BOLD, 14);
//        FontMetrics metrices = getFontMetrics(font);
//        
//        g.setColor(Color.WHITE);
//        g.setFont(font);
//        g.drawString(msg, (500 - metrices.stringWidth(msg)) / 2, 500/2);
//    }
//    
//    public void move() {
//        for (int i = dots ; i > 0 ; i--) {
//            x[i] = x[i - 1];
//            y[i] = y[i - 1];
//        }
//        
//        if (leftDirection) {
//            x[0] = x[0] - DOT_SIZE;
//        }
//        if (rightDirection) {
//            x[0] = x[0] + DOT_SIZE;
//        }
//        if (upDirection) {
//            y[0] = y[0] - DOT_SIZE;
//        }
//        if (downDirection) {
//            y[0] = y[0] + DOT_SIZE;
//        }
//    }
//    
//    public void checkApple() {
//        if ((x[0] == apple_x) && (y[0] == apple_y)) {
//            dots++;
//            locateApple();
//        }
//    }
//    
//    public void checkCollision() {
//        for(int i = dots; i > 0; i--) {
//            if (( i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
//                inGame = false;
//            }
//        }
//        
//        if (y[0] >= 300) {
//            inGame = false;
//        }
//        if (x[0] >= 300) {
//            inGame = false;
//        }
//        if (y[0] < 0) {
//            inGame = false;
//        }
//        if (x[0] < 0) {
//            inGame = false;
//        }
//        
//        if (!inGame) {
//            timer.stop();
//        }
//    }
//    
//    public void actionPerformed(ActionEvent ae) {
//        if (inGame) {
//            checkApple();
//            checkCollision();
//            move();
//        }
//        
//        repaint();
//    }
//    
//    public class TAdapter extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent e) {
//            int key = e.getKeyCode();
//            
//            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
//                leftDirection = true;
//                upDirection = false;
//                downDirection = false;
//            }
//            
//            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
//                rightDirection = true;
//                upDirection = false;
//                downDirection = false;
//            }
//            
//            if (key == KeyEvent.VK_UP && (!downDirection)) {
//                upDirection = true;
//                leftDirection = false;
//                rightDirection = false;
//            }
//            
//            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
//                downDirection = true;
//                leftDirection = false;
//                rightDirection = false;
//            }
//        }
//    }
//    
//}

//
//package snakegame;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import javax.sound.sampled.*;
//import java.io.IOException;
//import java.net.URL;
//
//public class Board extends JPanel implements ActionListener {
//    
//    private Image apple;
//    private Image dot;
//    private Image head;
//    private Image grass; // 🌿 background
//
//    private final int ALL_DOTS = 1600;
//    private final int DOT_SIZE = 10;
//    private final int RANDOM_POSITION = 49; // adjusted for 500x500
//    private final int BOARD_SIZE = 500;
//
//    private int apple_x;
//    private int apple_y;
//
//    private final int x[] = new int[ALL_DOTS];
//    private final int y[] = new int[ALL_DOTS];
//
//    private boolean leftDirection = false;
//    private boolean rightDirection = true;
//    private boolean upDirection = false;
//    private boolean downDirection = false;
//
//    private boolean inGame = true;
//    private int dots;
//    private Timer timer;
//
//    Board() {
//        addKeyListener(new TAdapter());
//        setBackground(Color.BLACK);
//        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
//        setFocusable(true);
//        loadImages();
//        initGame();
//    }
//
//    public void loadImages() {
//        apple = new ImageIcon(getClass().getResource("/snakegame/icons/apple.png")).getImage();
//        dot = new ImageIcon(getClass().getResource("/snakegame/icons/dot.png")).getImage();
//        head = new ImageIcon(getClass().getResource("/snakegame/icons/head.png")).getImage();
//        grass = new ImageIcon(getClass().getResource("/snakegame/icons/grass.png")).getImage(); // 🌿
//    }
//
//    public void initGame() {
//        dots = 3;
//
//        for (int i = 0; i < dots; i++) {
//            y[i] = 50;
//            x[i] = 50 - i * DOT_SIZE;
//        }
//
//        locateApple();
//        timer = new Timer(140, this);
//        timer.start();
//    }
//
//    public void locateApple() {
//        int r = (int)(Math.random() * RANDOM_POSITION);
//        apple_x = r * DOT_SIZE;
//        r = (int)(Math.random() * RANDOM_POSITION);
//        apple_y = r * DOT_SIZE;
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        draw(g);
//    }
//
//    public void draw(Graphics g) {
//        if (inGame) {
//            // Draw grass background
//            g.drawImage(grass, 0, 0, BOARD_SIZE, BOARD_SIZE, this);
//
//            g.drawImage(apple, apple_x, apple_y, this);
//
//            for (int i = 0; i < dots; i++) {
//                if (i == 0) {
//                    g.drawImage(head, x[i], y[i], this);
//                } else {
//                    g.drawImage(dot, x[i], y[i], this);
//                }
//            }
//            Toolkit.getDefaultToolkit().sync();
//        } else {
//            gameOver(g);
//        }
//    }
//
//    public void gameOver(Graphics g) {
//        playCrashSound(); // 💥 play sound on crash
//        String msg = "Game Over!";
//        Font font = new Font("SAN_SERIF", Font.BOLD, 20);
//        FontMetrics metrics = getFontMetrics(font);
//
//        g.setColor(Color.WHITE);
//        g.setFont(font);
//        g.drawString(msg, (BOARD_SIZE - metrics.stringWidth(msg)) / 2, BOARD_SIZE / 2);
//    }
//
//    public void move() {
//        for (int i = dots; i > 0; i--) {
//            x[i] = x[i - 1];
//            y[i] = y[i - 1];
//        }
//
//        if (leftDirection) x[0] -= DOT_SIZE;
//        if (rightDirection) x[0] += DOT_SIZE;
//        if (upDirection) y[0] -= DOT_SIZE;
//        if (downDirection) y[0] += DOT_SIZE;
//    }
//
//    public void checkApple() {
//        if ((x[0] == apple_x) && (y[0] == apple_y)) {
//            dots++;
//            locateApple();
//        }
//    }
//
//    public void checkCollision() {
//        for (int i = dots; i > 0; i--) {
//            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
//                inGame = false;
//            }
//        }
//
//        if (y[0] >= BOARD_SIZE || x[0] >= BOARD_SIZE || y[0] < 0 || x[0] < 0) {
//            inGame = false;
//        }
//
//        if (!inGame) {
//            timer.stop();
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (inGame) {
//            checkApple();
//            checkCollision();
//            move();
//        }
//        repaint();
//    }
//
//    public class TAdapter extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent e) {
//            int key = e.getKeyCode();
//
//            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
//                leftDirection = true;
//                upDirection = false;
//                downDirection = false;
//            }
//            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
//                rightDirection = true;
//                upDirection = false;
//                downDirection = false;
//            }
//            if (key == KeyEvent.VK_UP && (!downDirection)) {
//                upDirection = true;
//                leftDirection = false;
//                rightDirection = false;
//            }
//            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
//                downDirection = true;
//                leftDirection = false;
//                rightDirection = false;
//            }
//        }
//    }
//
//    // 🎵 Sound Effect Function
//    private void playCrashSound() {
//        try {
//            URL url = getClass().getResource("/snakegame/sounds/crash.mp3");
//            if (url == null) return;
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioIn);
//            clip.start();
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            System.err.println("Error playing sound: " + e.getMessage());
//        }
//    }
//}


package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Board extends JPanel implements ActionListener {

    private Image apple;
    private Image dot;
    private Image head;
    private Image grass;

    private final int ALL_DOTS = 1600;
    private final int DOT_SIZE = 10;
    private final int RANDOM_POSITION = 49;
    private final int BOARD_SIZE = 500;

    private int apple_x;
    private int apple_y;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

    private boolean inGame = true;
    private boolean crashSoundPlayed = false; //  prevent repeated crash sound
    private int dots;
    private Timer timer;

    private JButton playAgainButton;
    private JButton quitButton;

    Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setFocusable(true);
        loadImages();
        initGame();
    }

    public void loadImages() {
        apple = new ImageIcon(getClass().getResource("/snakegame/icons/dot.png")).getImage();
        dot = new ImageIcon(getClass().getResource("/snakegame/icons/dot.png")).getImage();
        head = new ImageIcon(getClass().getResource("/snakegame/icons/head.png")).getImage();
        grass = new ImageIcon(getClass().getResource("/snakegame/icons/grass.png")).getImage();
    }

    public void initGame() {
        inGame = true;
        crashSoundPlayed = false; //  reset crash sound flag
        dots = 3;

        // remove buttons when restarting
        removeGameOverButtons();

        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;
        }

        locateApple();

        if (timer != null) timer.stop();
        timer = new Timer(140, this);
        timer.start();

        requestFocusInWindow();
    }

    public void locateApple() {
        int r = (int) (Math.random() * RANDOM_POSITION);
        apple_x = r * DOT_SIZE;
        r = (int) (Math.random() * RANDOM_POSITION);
        apple_y = r * DOT_SIZE;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (inGame) {
            g.drawImage(grass, 0, 0, BOARD_SIZE, BOARD_SIZE, this);
            g.drawImage(apple, apple_x, apple_y, this);

            for (int i = 0; i < dots; i++) {
                if (i == 0)
                    g.drawImage(head, x[i], y[i], this);
                else
                    g.drawImage(dot, x[i], y[i], this);
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    public void gameOver(Graphics g) {
        //  Play sound only once
        if (!crashSoundPlayed) {
            playCrashSound();
            crashSoundPlayed = true;
        }

        String msg = "Game Over!";
        Font font = new Font("SAN_SERIF", Font.BOLD, 24);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (BOARD_SIZE - metrics.stringWidth(msg)) / 2, BOARD_SIZE / 2 - 40);

        // ✅ Only show buttons once
        if (playAgainButton == null && quitButton == null) {
            showGameOverButtons();
        }
    }

    private void showGameOverButtons() {
        setLayout(null);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(BOARD_SIZE / 2 - 90, BOARD_SIZE / 2, 180, 35);
        playAgainButton.addActionListener(e -> {
            initGame();
            repaint();
        });
        add(playAgainButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(BOARD_SIZE / 2 - 90, BOARD_SIZE / 2+50, 180, 35);
        quitButton.addActionListener(e -> {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) window.dispose();
            System.exit(0);
        });
        add(quitButton);

        playAgainButton.setVisible(true);
        quitButton.setVisible(true);

        revalidate();
        repaint();
    }

    private void removeGameOverButtons() {
        if (playAgainButton != null) {
            remove(playAgainButton);
            playAgainButton = null;
        }
        if (quitButton != null) {
            remove(quitButton);
            quitButton = null;
        }
        revalidate();
        repaint();
    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (leftDirection) x[0] -= DOT_SIZE;
        if (rightDirection) x[0] += DOT_SIZE;
        if (upDirection) y[0] -= DOT_SIZE;
        if (downDirection) y[0] += DOT_SIZE;
    }

    public void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            locateApple();
            playEatSound();
        }
    }

    public void checkCollision() {
        for (int i = dots; i > 0; i--) {
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }

        if (y[0] >= BOARD_SIZE || x[0] >= BOARD_SIZE || y[0] < 0 || x[0] < 0) {
            inGame = false;
        }

        if (!inGame) timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    public class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if (key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }
    }

    // Crash sound
    private void playCrashSound() {
        playSound("/snakegame/sounds/crash.wav");
    }

    // Eat sound
    private void playEatSound() {
        playSound("/snakegame/sounds/eat.wav");
    }

    // Generic sound method
    private void playSound(String path) {
        try {
            URL url = getClass().getResource(path);
            if (url == null) {
                System.err.println("Sound not found: " + path);
                return;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}
