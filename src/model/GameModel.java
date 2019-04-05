package model;

import java.util.ArrayList;
import java.util.List;

import view.GameFrame;
import view.Sprites;

/**
 * Class that handles the logic and creates the objects used in the game
 */

public class GameModel {

  public List<IPositionable> sprites = new ArrayList<>();
  private int startXPosition = 200;
  private int backgroundSpeed = 1;

  // TODO DO THIS MORE FLEXIBLE I.E COPY AN EXISTING PIPE??
  public GameModel() {
    sprites.add(GameObjectFactory.createBird(50, 280));
    sprites.add(GameObjectFactory.createPipe(startXPosition, 300));
    sprites.add(GameObjectFactory.createPipe(startXPosition, -30));
  }

  // TODO Check collision with bird
  public void handlePipes() {
    for (IPositionable pipe : sprites) {
      movePipes(pipe);
      collissionWithBird(pipe);
    }
  }

  private void movePipes(IPositionable pipe) {
    if (pipe instanceof Pipe) {
      pipe.setX(startXPosition -= backgroundSpeed);
    } else if (pipe.getX() + Sprites.PIPE_WIDTH <= 0) {
      pipe.setX(Sprites.PIPE_WIDTH + GameFrame.WINDOW_WIDTH);
    }
  }

  // TODO SEE IT AS A RECTANGLE??????
  private void collissionWithBird(IPositionable pipe) {
    if (pipe instanceof Pipe) {
      //Rectangle rec = new Rectangle(Math.abs())
      if (pipe.getX() + Sprites.PIPE_WIDTH == sprites.get(0).getX() && pipe.getY() == sprites.get(0).getY()) {
        System.out.println("Hit");
      }
    }
  }

  // TODO rotate?????
  public void jump() {
    for (IPositionable s : sprites) {
      if (s instanceof Bird) {
        ((Bird) s).setY(s.getY() - 20);
      }
    }
  }
}
