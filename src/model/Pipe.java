package model;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Class that defines the fundamentals of a pipe
 */

class Pipe implements IPositionable {

  private Point2D position;

  int gap = new Random().nextInt(100) + 100;

  Pipe(float x, float y) {
    this.position = new Point2D.Float(x, y);
  }

  public float getX() {
    return (float) position.getX();
  }

  public float getY() {
    return (float) position.getY();
  }

  public void setX(float x) {
    this.position = new Point2D.Float(x, this.getY());
  }

  public void setY(float y) {
    this.position = new Point2D.Float(this.getX(), y);
  }

  @Override
  public String toString() {
    return "Pipe";
  }
}
