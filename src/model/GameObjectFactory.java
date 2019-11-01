package model;

/**
 * A class for creating objects used in the game
 */

class GameObjectFactory {

  static Bird createBird(float x, float y) {
    return new Bird(x, y);
  }

  static Pipe createPipe(float x, float y) {
    return new Pipe(x, y);
  }
}
