package model;

class GameModel {

  GameModel() {
    GameObjectFactory.createBird(20, 20);
    GameObjectFactory.createPipe(0, 50);
  }
}
