package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.GameModel;
import model.IPositionable;

/**
 * Class that binds an image to a game object and begs GameFrame to draw them
 */

public class GamePanel extends JPanel {

  private GameModel model = new GameModel();
  private GameSprites sprite = new GameSprites();

  GamePanel() {

    sprite.bind(model.sprites.get(0), sprite.bird);
    sprite.bind(model.sprites.get(1), sprite.pipe);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IPositionable p : model.sprites) {
      g.drawImage(sprite.get(p), (int) p.getX(), (int) p.getY(), null);
    }
  }
}
