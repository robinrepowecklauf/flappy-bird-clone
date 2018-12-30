package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles the logic and creates the objects used in the game
 */

public class GameModel {

  public List<IPositionable> sprites = new ArrayList<>();
  private int startXPosition = 200;

  public GameModel() {
    sprites.add(GameObjectFactory.createBird(50, 280));
    sprites.add(GameObjectFactory.createPipe(startXPosition, 300));
    sprites.add(GameObjectFactory.createPipe(startXPosition, -30));
  }

  // TODO Check collision
  public void movePipes() {
    for (IPositionable s : sprites) {
      if (s instanceof Pipe) {
        s.setX(startXPosition -= 0);
      }
    }
  }

  public void jump() {
   for(IPositionable s : sprites) {
     if (s instanceof Bird) {
       ((Bird) s).setY(s.getY() - 20);
     }
   }
  }
}
