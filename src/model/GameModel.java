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
  private int startXPipe = 200;
  private int backgroundSpeed = 1;
  private int startYPipeDown = -30;
  private int startYPipeUp = 300;
  public boolean started = false;

  // TODO DO THIS MORE FLEXIBLE I.E COPY AN EXISTING PIPE??
  public GameModel() {
    sprites.add(GameObjectFactory.createBird(50, 330));
    sprites.add(GameObjectFactory.createPipe(startXPipe, startYPipeUp));
    sprites.add(GameObjectFactory.createPipe(startXPipe, startYPipeDown));
  }

  public void handlePipes() {
    for (IPositionable pipe : sprites) {
      movePipes(pipe);
    }
  }

  public void handleBird() {
    for (IPositionable bird : sprites) {
      if (bird instanceof Bird) {
        ((Bird) bird).updatePhysics();
        checkCollision(bird);
      }
    }
  }

  // TODO REPLACE SOUT
  private void checkCollision(IPositionable bird) {
    if (bird instanceof Bird && intersects()) {
      System.out.println("Hit");
    }
  }

  private void movePipes(IPositionable pipe) {
    if (pipe instanceof Pipe) {
      pipe.setX(startXPipe -= backgroundSpeed);
    }
    if (pipe.getX() + Sprites.PIPE_WIDTH <= 0) {
      startXPipe = GameFrame.WINDOW_WIDTH - 20;
    }
  }

  // TODO rotate?????
  public void jump() {
    for (IPositionable s : sprites) {
      if (s instanceof Bird) {
        ((Bird) s).jump();
      }
    }
  }

  private boolean intersects() {
    return sameXPosition() && (leftOfPipeDown() || leftOfPipeUp());
  }

  private boolean sameXPosition() {
    return sprites.get(0).getX() == sprites.get(1).getX() - Sprites.BIRD_WIDTH;
  }

  private boolean leftOfPipeDown() {
    return sprites.get(0).getY() < sprites.get(2).getY() + Sprites.PIPE_HEIGHT && sprites.get(0).getY() > startYPipeDown;
  }

  private boolean leftOfPipeUp() {
    return sprites.get(0).getY() < sprites.get(1).getY() + Sprites.PIPE_HEIGHT && sprites.get(0).getY() > startYPipeUp;
  }

}
