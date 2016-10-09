package no.vestein.snake;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import no.vestein.snake.eventhandler.EventBus;
import no.vestein.snake.screens.MenuScreen;
import no.vestein.snake.world.WorldController;
import no.vestein.snake.world.WorldRenderer;

public class Snake extends Game {

  @Override
  public void create() {
    Gdx.app.setLogLevel(Application.LOG_DEBUG);

    Assets.instance.init(new AssetManager());

    setScreen(new MenuScreen(this));
  }

}
