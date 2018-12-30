package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.GameModel;
import model.IPositionable;

/**
 * Class that binds an image to a game object and tells GameFrame to draw them
 */

public class GamePanel extends JPanel {

  private GameModel model;
  private Sprites sprite;

  public GamePanel(GameModel model, Sprites sprite) {

    this.model = model;
    this.sprite = sprite;

    imageToObject();
  }

  private void imageToObject() {

    sprite.bind(model.sprites.get(0), sprite.bird);
    sprite.bind(model.sprites.get(1), sprite.pipeUp);
    sprite.bind(model.sprites.get(2), sprite.pipeDown);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(sprite.background, 0, 0, null);
    for (IPositionable p : model.sprites) {
      g.drawImage(sprite.get(p), (int) p.getX(), (int) p.getY(), null);
    }
  }
}
