package model;

import java.util.ArrayList;

public class GameModel {

  public ArrayList<IPositionable> sprites = new ArrayList<>();

  public GameModel() {
    sprites.add(GameObjectFactory.createBird(0, 0));
    sprites.add(GameObjectFactory.createPipe(200, 450));

  }
}
