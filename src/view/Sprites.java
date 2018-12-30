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

  private final String filePath = (System.getProperty("os.name").startsWith("Windows")) ? "src\\assets\\" : "src/assets/";
  private Map<IPositionable, Image> objectImage = new HashMap<>();

  Image bird;
  Image background;
  Image pipe;
  Image pipeHead;

  {
    try {
      bird = ImageIO.read(new File(filePath + "yellow-bird.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
      background = ImageIO.read(new File(filePath + "background.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
      pipe = ImageIO.read(new File(filePath + "green-pipe.png")).getScaledInstance(75, 200, Image.SCALE_DEFAULT);
      pipeHead = ImageIO.read(new File(filePath + "green-pipe-head.png")).getScaledInstance(80, 50, Image.SCALE_DEFAULT);
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

