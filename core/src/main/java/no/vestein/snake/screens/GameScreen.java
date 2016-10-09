package no.vestein.snake.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import no.vestein.snake.eventhandler.EventBus;
import no.vestein.snake.world.WorldController;
import no.vestein.snake.world.WorldRenderer;

/**
 * Created by Vestein Dahl
 * Date: 09.10.2016
 * Time: 20.32
 */
public class GameScreen extends AbstractScreen {
  private static final String TAG = GameScreen.class.getName();

  private WorldController worldController;
  private WorldRenderer worldRenderer;
  private boolean paused;

  public static final EventBus EVENT_BUS = new EventBus();


  public GameScreen(Game game) {
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if (!paused) {
      worldController.update(deltaTime);
    }

    Gdx.gl.glClearColor(0xff/255.0f, 0xff/255.0f, 0xff/255.0f, 0xff/255.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    worldRenderer.render();

  }

  @Override
  public void resize(int width, int height) {
    worldRenderer.resize(width, height);
  }

  @Override
  public void show() {
    worldController = new WorldController(game);
    worldRenderer = new WorldRenderer(worldController);
  }

  @Override
  public void hide() {
    worldRenderer.dispose();
  }

  @Override
  public void pause() {
    paused = true;
  }

  @Override
  public void resume() {
    super.resume();
    paused = false;
  }

}
