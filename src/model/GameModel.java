package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import view.GameFrame;
import view.Sprites;

/**
 * Class that handles the logic and creates the objects used in the game
 */

public class GameModel {

  public List<IPositionable> sprites = new ArrayList<>();
  private int startXPipe = GameFrame.WINDOW_WIDTH / 3;
  private double backgroundSpeed = 2.5;
  private int startYPipeDown = -30;
  private int startYPipeUp = 300;
  public boolean started = false;
  private Rectangle birdBounds, topPipeBounds, botPipeBounds;

  // TODO DO THIS MORE FLEXIBLE I.E COPY AN EXISTING PIPE??
  public GameModel() {

    sprites.add(GameObjectFactory.createBird(50, 330));

    sprites.add(GameObjectFactory.createPipe(startXPipe, startYPipeUp));
    sprites.add(GameObjectFactory.createPipe(startXPipe * 2, startYPipeUp));
    sprites.add(GameObjectFactory.createPipe(startXPipe * 3, startYPipeUp));

    sprites.add(GameObjectFactory.createPipe(startXPipe, startYPipeDown));
    sprites.add(GameObjectFactory.createPipe(startXPipe * 2, startYPipeDown));
    sprites.add(GameObjectFactory.createPipe(startXPipe * 3, startYPipeDown));
  }

  public void handlePipes() {
    for (IPositionable pipe : sprites) {
      movePipes(pipe);
    }
  }

  public void handleBird() {
    for (IPositionable bird : sprites) {
      checkCollision(bird);
      if (bird instanceof Bird) {
        ((Bird) bird).updatePhysics();
      }
    }
  }

  // TODO REPLACE SOUT
  public void checkCollision(IPositionable s) {
    if (s instanceof Bird) {
      birdBounds = new Rectangle(Math.round(s.getX()), Math.round(s.getY()), Sprites.BIRD_WIDTH, Sprites.BIRD_HEIGHT);
    }
    if (s instanceof Pipe){
      topPipeBounds = new Rectangle(Math.round(s.getX()), Math.round(s.getY()), Sprites.PIPE_WIDTH, Sprites.PIPE_HEIGHT);
      botPipeBounds = new Rectangle(Math.round(s.getX()), Math.round(s.getY()), Sprites.PIPE_WIDTH, Sprites.PIPE_HEIGHT);
    }
  }

  private void movePipes(IPositionable pipe) {
    if (pipe instanceof Pipe) {
      float temp = pipe.getX();
      pipe.setX(temp -= backgroundSpeed);
      checkCollision(pipe);
    }
    if (pipe.getX() + Sprites.PIPE_WIDTH <= 0) {
      pipe.setX(GameFrame.WINDOW_WIDTH + Sprites.PIPE_WIDTH);
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

  private boolean intersects(IPositionable pipe, int i) {
    return sameXPosition(pipe) && (leftOfPipeDown(i) || leftOfPipeUp(i));
  }

  private boolean sameXPosition(IPositionable pipe) {
    return sprites.get(0).getX() == sprites.get(sprites.indexOf(pipe)).getX() - Sprites.BIRD_WIDTH;
  }

  private boolean leftOfPipeDown(int i) {
    return sprites.get(0).getY() < sprites.get(i).getY() + Sprites.PIPE_HEIGHT && sprites.get(0).getY() > startYPipeDown;
  }

  private boolean leftOfPipeUp(int i) {
    return sprites.get(0).getY() < sprites.get(i).getY() + Sprites.PIPE_HEIGHT && sprites.get(0).getY() > startYPipeUp;
  }

}
