package model;

class GameObjectFactory {

  public static Bird createBird(int x, int y) {
    return new Bird(x, y);
  }

  public static Pipe createPipe(int x, int y) {
    return new Pipe(x, y);
  }
}
