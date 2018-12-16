package model;

class Bird {
  double x;
  double y;

  Bird(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void up(double x) {
    x += 10;
  }
}

