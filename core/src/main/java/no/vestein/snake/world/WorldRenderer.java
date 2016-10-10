package no.vestein.snake.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import no.vestein.snake.Reference;
import no.vestein.snake.render.RenderGrid;
import no.vestein.snake.render.RenderSnake;
import no.vestein.snake.render.RenderTextBox;
import no.vestein.snake.render.RenderingRegistry;

/**
 * Created by Vestein on 12.03.2016.
 */
public class WorldRenderer implements Disposable {

  private OrthographicCamera camera;
  private OrthographicCamera camera_ui;
  private SpriteBatch batch;
  private WorldController worldController;
  private ShapeRenderer shapeRenderer;

  private RenderingRegistry renderingRegistry;

  public WorldRenderer(WorldController worldController) {
    this.worldController = worldController;
    init();
  }

  private void init() {
    batch = new SpriteBatch();
    camera = new OrthographicCamera(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    camera.position.set(0, 0, 0);
    camera.update();

    {
      camera_ui = new OrthographicCamera(Reference.VIEWPORT_UI_WIDTH, Reference.VIEWPORT_UI_HEIGHT);
      camera_ui.position.set(0, 0, 0);
      camera_ui.update();
    }

    renderingRegistry = new RenderingRegistry();
    shapeRenderer = new ShapeRenderer();

    renderingRegistry.registerRenderer(new RenderGrid());
    renderingRegistry.registerRenderer(new RenderSnake());
    renderingRegistry.registerRenderer(new RenderTextBox());
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

//    renderingRegistry.renderEntity(worldController.grid, camera, batch);
//    renderingRegistry.renderEntity(worldController.circleEntity, camera, batch);
    renderingRegistry.renderEntity(worldController.textBox, camera_ui, batch);

  }

}
