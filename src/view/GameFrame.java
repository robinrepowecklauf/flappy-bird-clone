package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;
  private static final Dimension WINDOW_DIMENSION = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
  private static final Dimension SCREEN_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

  public GameFrame() {
    super("Flappy Bird");
    setPreferredSize(WINDOW_DIMENSION);
    setSize(WINDOW_DIMENSION);
    setLocation(calculateCenterOffsetX(), calculateCenterOffsetY());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
    setFocusable(true);
    setResizable(false);

    requestFocus();
    pack();
  }

  private int calculateCenterOffsetX() {
    return SCREEN_DIMENSION.width / 2 - this.getSize().width / 2;
  }

  private int calculateCenterOffsetY() {
    return SCREEN_DIMENSION.height / 2 - this.getSize().height / 2;
  }
}

