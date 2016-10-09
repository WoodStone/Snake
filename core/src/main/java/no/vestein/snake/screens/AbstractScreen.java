package no.vestein.snake.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by Vestein Dahl
 * Date: 09.10.2016
 * Time: 00.58
 */
public abstract class AbstractScreen implements Screen {

  protected Game game;

  public AbstractScreen(Game game) {
    this.game = game;
  }

  public abstract void render(final float deltaTime);
  public abstract void resize(final int width, final int height);
  public abstract void show();
  public abstract void hide();
  public abstract void pause();

  public void resume() {
    //todo Assets-class
//    Assets.instance.init(new AssetManager());
  }

  public void dispose() {
    //todo Assets-class
//    Assets.instance.dispose();
  }

}
