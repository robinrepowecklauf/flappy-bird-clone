package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;


/**
 * Class that defines the sprites used in the game
 */

public class GameSprites {

  private final String filePath = (System.getProperty("os.name").startsWith("Windows")) ? "src\\images\\" : "src/images/";
  private Map<Object, Image> objectImage = new HashMap<>();

  {
    try {
      final Image bird = ImageIO.read(new File(filePath + "bird.png"));
      final Image background = ImageIO.read(new File(filePath + "background.png"));
      final Image pipe = ImageIO.read(new File(filePath + "pipe.png"));
    } catch (IOException e) {
      System.out.println("Couldn't load images correctly!");
      e.printStackTrace();
    }
  }

  private <T> void bind(T object, Image image) {
    objectImage.put(object, image);
  }

  private <T> Image get(T object) {
    Image i = objectImage.get(object);
    if (i == null) {
      return get(object.getClass());
    }
    return i;
  }


}

