package no.vestein.snake.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import no.vestein.snake.Reference;
import no.vestein.snake.Snake;

public class HtmlLauncher extends GwtApplication {

  @Override
  public GwtApplicationConfiguration getConfig () {
    return new GwtApplicationConfiguration(Reference.WIDTH, Reference.HEIGHT);
  }

  @Override
  public ApplicationListener getApplicationListener () {
          return new Snake();
  }

}