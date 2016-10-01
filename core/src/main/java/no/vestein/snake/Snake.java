package no.vestein.snake;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import no.vestein.snake.world.WorldController;
import no.vestein.snake.world.WorldRenderer;

public class Snake extends ApplicationAdapter {
  private WorldController worldController;
  private WorldRenderer worldRenderer;
  private boolean paused;

	@Override
	public void create () {
    Gdx.app.setLogLevel(Application.LOG_DEBUG);

    worldController = new WorldController();
    worldRenderer = new WorldRenderer(worldController);
    paused = false;

	}

	@Override
	public void render () {
    if (!paused) {
      worldController.update(Gdx.graphics.getDeltaTime());
    }
    Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    worldRenderer.render();
	}

  @Override
  public void dispose() {
    worldRenderer.dispose();
  }

  @Override
  public void resize(final int width, final int height){
    worldRenderer.resize(width, height);
  }

  @Override
  public void pause() {
    paused = true;
  }

  @Override
  public void resume() {
    paused = false;
  }

}
