package view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.GameModel;
import model.GameObjectFactory;
import model.IPositionable;

public class GamePanel extends JPanel {

  private GameModel model;
  private GameSprites sprite = new GameSprites();

  private ArrayList<IPositionable> sprites = new ArrayList<>();

  public GamePanel() {
    sprites.add(GameObjectFactory.createBird(0, 0));
    sprites.add(GameObjectFactory.createPipe(0, 150));

    sprite.bind(sprites.get(0), sprite.bird);
    sprite.bind(sprites.get(1), sprite.pipe);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(IPositionable o : sprites) {
      g.drawImage(sprite.get(o), (int)o.getX(), (int)o.getY(), null);
    }
  }
}
