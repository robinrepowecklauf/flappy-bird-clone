package model;

/**
 * Class that defines the fundamentals of a bird
 */

class Bird implements IPositionable {

  private double x;
  private double y;

  Bird(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getWidth() {
    return 0;
  }

  public double getHeight() {
    return 0;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  /*  public void up(double x) {
    x += 10;
  } */
}

