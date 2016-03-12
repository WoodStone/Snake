package no.vestein.snake;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Snake extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	private OrthographicCamera camera;

	private float rot;

  private WorldController worldController;
  private WorldRenderer worldRenderer;
  private boolean paused;

	@Override
	public void create () {
    Gdx.app.setLogLevel(Application.LOG_DEBUG);

    worldController = new WorldController();
    worldRenderer = new WorldRenderer(worldController);
    paused = false;
//		batch = new SpriteBatch();
//    camera = new OrthographicCamera(100f, 100f);
//
//		img = new Texture("badlogic.jpg");
//
//		TextureRegion region = new TextureRegion(img, img.getWidth(), img.getHeight());
//
//		sprite = new Sprite(region);


	}

	@Override
	public void render () {
    if (!paused) {
      worldController.update(Gdx.graphics.getDeltaTime());
    }
    Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    worldRenderer.render();

//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//    batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//
//		final float degreesPerSecond = 180.0f;
//		rot = (rot + Gdx.graphics.getDeltaTime() * degreesPerSecond) % 360;
//
//		final float shakeAmplitudeInDegrees = 5.0f;
//		float shake = MathUtils.sin(rot) * shakeAmplitudeInDegrees;
//
//		sprite.setRotation(shake);
//		sprite.draw(batch);
//		batch.end();
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
