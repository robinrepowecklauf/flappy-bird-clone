import view.*;
import controller.GameController;

/**
 * Class that combines all necessary classes and runs the game
 */

public class FlappyBirdApp {

  public static void main(String[] args) {

    GamePanel view = new GamePanel();
    GameFrame game = new GameFrame(view);
    GameController controller = new GameController();

    //controller.timer.start();

  }
}
