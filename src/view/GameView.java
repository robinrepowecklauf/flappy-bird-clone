package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameView extends JPanel {

  private List<Image> images = new ArrayList<>();

  public GameView() {
    try {
      images.add(ImageIO.read(new File("src/images/background.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT));
      images.add(ImageIO.read(new File("src/images/bird.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Image i : images)
      g.drawImage(i, 0, 0, null);
  }
}
