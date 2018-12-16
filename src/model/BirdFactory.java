package model;

class BirdFactory {

  public static Bird createBird(int x, int y) {
    return new Bird(x, y);
  }
}
