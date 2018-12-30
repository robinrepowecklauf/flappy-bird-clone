import model.GameModel;
import view.*;
import controller.GameController;

/**
 * Class that combines all necessary classes and runs the game
 */

public class FlappyBirdApp {

  public static void main(String[] args) {

    Sprites sprites = new Sprites();
    GameModel model = new GameModel();
    GamePanel view = new GamePanel(model, sprites);
    GameController controller = new GameController(model, view);
    GameFrame game = new GameFrame(view, controller);

    controller.timer.start();

  }
}
