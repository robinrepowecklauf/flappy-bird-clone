import java.io.IOException;

import view.*;

public class FlappyBirdApp {

  public static void main(String[] args) throws IOException {
    GameView view = new GameView();
    GameFrame game = new GameFrame(view);
  }
}
