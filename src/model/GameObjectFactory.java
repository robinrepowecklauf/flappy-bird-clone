package model;

/**
 * A class for creating objects used in the game
 */

class GameObjectFactory {

  static Bird createBird(int x, int y) {
    return new Bird(x, y);
  }

  static Pipe createPipe(int x, int y) {
    return new Pipe(x, y);
  }
}
