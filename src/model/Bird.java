package model;

import java.awt.geom.Point2D;

/**
 * Class that defines the fundamentals of a bird
 */

class Bird implements IPositionable {

  private Point2D position;
  private float dy;


  Bird(float x, float y) {

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

  public void updatePhysics() {
    setX(getX());
    setY(getY() + dy);
    this.position.setLocation(getX(), getY());
    this.dy += 0.8f;
  }

  public void jump() {
    this.dy = -10;
  }

  public void reset() {
    this.position = new Point2D.Double(50, 280);
  }

  @Override
  public String toString() {
    return "Bird";
  }
}

