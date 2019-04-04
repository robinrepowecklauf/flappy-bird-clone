package model;

import java.awt.geom.Point2D;

/**
 * Class that defines the fundamentals of a bird
 */

class Bird implements IPositionable {

  private Point2D position;
  private double x, y, dx, dy;


  Bird(double x, double y) {
    this.x = x;
    this.y = y;
    this.position = new Point2D.Double(x, y);
  }

  public double getX() {
    return position.getX();
  }

  public double getY() {
    return position.getY();
  }

  public void setX(double x) {
    this.position = new Point2D.Double(x, this.getY());
  }

  public void setY(double y) {
    this.position = new Point2D.Double(this.getX(), y);
  }

  public void updatePhysics() {
    this.position.setLocation(this.x += dx, this.y += dy);
    this.dy = 0.5;
  }

  @Override
  public String toString() {
    return "Bird";
  }
}

