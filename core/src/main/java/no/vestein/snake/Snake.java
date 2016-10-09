package no.vestein.snake;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import no.vestein.snake.assets.Assets;
import no.vestein.snake.screens.MenuScreen;

public class Snake extends Game {

  @Override
  public void create() {
    Gdx.app.setLogLevel(Application.LOG_DEBUG);

    Assets.instance.init(new AssetManager());

    setScreen(new MenuScreen(this));
  }

}
