package no.vestein.snake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import no.vestein.snake.Reference;
import no.vestein.snake.Snake;

public class DesktopLauncher {

  public static void main (String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.width = Reference.WIDTH;
    config.height = Reference.HEIGHT;
    new LwjglApplication(new Snake(), config);
  }

}
