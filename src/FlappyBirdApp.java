import view.*;
import controller.GameController;

public class FlappyBirdApp {

  public static void main(String[] args){

    GamePanel view = new GamePanel();
    GameFrame game = new GameFrame(view);
    GameController controller = new GameController();

    //controller.timer.start();

  }
}
