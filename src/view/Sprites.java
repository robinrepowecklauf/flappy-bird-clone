package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import model.IPositionable;

/**
 * Class that defines the sprites used in the game
 */

public class Sprites {

  public static final int BIRD_WIDTH = 47;
  public static final int BIRD_HEIGHT = 32;
  public static final int PIPE_WIDTH = 80;
  public static final int PIPE_HEIGHT = 200;

  private final String filePath = (System.getProperty("os.name").startsWith("Windows")) ? "src\\assets\\" : "src/assets/";
  private Map<IPositionable, Image> objectImage = new HashMap<>();

  Image bird;
  Image background;
  Image pipeUp;
  Image pipeDown;

  {
    try {
      bird = ImageIO.read(new File(filePath + "yellow-flappy-bird.png")).getScaledInstance(BIRD_WIDTH, BIRD_HEIGHT, Image.SCALE_DEFAULT);
      background = ImageIO.read(new File(filePath + "light-background.jpg")).getScaledInstance(GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT, Image.SCALE_DEFAULT);
      pipeUp = ImageIO.read(new File(filePath + "green-pipe-up.png")).getScaledInstance(PIPE_WIDTH, PIPE_HEIGHT, Image.SCALE_DEFAULT);
      pipeDown = ImageIO.read(new File(filePath + "green-pipe-down.png")).getScaledInstance(PIPE_WIDTH, PIPE_HEIGHT, Image.SCALE_DEFAULT);
    } catch (IOException e) {
      System.out.println("Could not load assets correctly!");
      e.printStackTrace();
    }
  }

  <T extends IPositionable> void bind(T object, Image image) {
    objectImage.put(object, image);
  }

  <T extends IPositionable> Image get(T object) {
    Image i = objectImage.get(object);
    if (i == null) {
      System.out.println("Image for " + object.toString() + " does not exist.");
    }
    return i;
  }
}

