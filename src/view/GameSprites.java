package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import model.GameModel;

/**
 * Class that defines the sprites used in the game
 */

class GameSprites {

  private final String filePath = (System.getProperty("os.name").startsWith("Windows")) ? "src\\images\\" : "src/images/";
  private Map<Object, Image> objectImage = new HashMap<>();

  GameModel model;

  Image bird;
  Image background;
  Image pipe;

  {
    try {
      bird = ImageIO.read(new File(filePath + "bird.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
      background = ImageIO.read(new File(filePath + "background.png"));
      pipe = ImageIO.read(new File(filePath + "pipe.png"));
    } catch (IOException e) {
      System.out.println("Couldn't load images correctly!");
      e.printStackTrace();
    }
  }

  <T> void bind(T object, Image image) {
    objectImage.put(object, image);
  }

  <T> Image get(T object) {
    Image i = objectImage.get(object);
    if (i == null) {
      return get(object.getClass());
    }
    return i;
  }
}

