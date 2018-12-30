package model;

import java.awt.geom.Point2D;

/**
 * Class that defines the fundamentals of a bird
 */

class Bird implements IPositionable {

  private Point2D position;


  Bird(double x, double y) {
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


  @Override
  public String toString() {
    return "Bird";
  }
}

