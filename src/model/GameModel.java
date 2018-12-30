package model;

import java.util.ArrayList;

/**
 * Class that handles the logic and creates the objects used in the game
 */

public class GameModel {

  public ArrayList<IPositionable> sprites = new ArrayList<>();
  int x = 250;

  public GameModel() {
    sprites.add(GameObjectFactory.createBird(50, 250));
    sprites.add(GameObjectFactory.createPipe(x, 300));
    sprites.add(GameObjectFactory.createPipe(x, 0));
  }

  public void movePipes() {
    for (IPositionable p : sprites) {
      if(p instanceof Pipe) {
        p.setX(x -= 1);
        System.out.println(p.getX());
      }
    }
  }
}
