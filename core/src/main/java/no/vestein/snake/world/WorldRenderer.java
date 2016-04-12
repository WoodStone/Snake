package no.vestein.snake.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import no.vestein.snake.Reference;

/**
 * Created by Vestein on 12.03.2016.
 */
public class WorldRenderer implements Disposable {

  private OrthographicCamera camera;
  private SpriteBatch batch;
  private WorldController worldController;

  public WorldRenderer(WorldController worldController) {
    this.worldController = worldController;
    init();
  }

  private void init() {
    batch = new SpriteBatch();
    camera = new OrthographicCamera(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    camera.position.set(0, 0, 0);
    camera.update();
  }

  public void render() {
    renderObjects();
  }

  public void resize(final int width, final int height) {
    camera.viewportWidth = (Reference.VIEWPORT_HEIGHT / height) * width;
  }

  @Override
  public void dispose() {
    batch.dispose();
  }

  private void renderObjects() {
    worldController.cameraHelper.applyTo(camera);
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    for (Sprite sprite : worldController.getSprites()) {
      sprite.draw(batch);
    }
    worldController.gridSprite.draw(batch);
    worldController.snakeSprite.draw(batch);
    batch.end();
  }

}
