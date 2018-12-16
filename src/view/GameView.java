package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameView extends JPanel {

  private Image background;

  public GameView() throws IOException {
    background = ImageIO.read(new File("src/images/background.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null);
  }
}
