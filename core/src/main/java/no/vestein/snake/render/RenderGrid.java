package no.vestein.snake.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import no.vestein.snake.entities.GridNew;

import static no.vestein.snake.Reference.VIEWPORT_HEIGHT;
import static no.vestein.snake.Reference.VIEWPORT_WIDTH;

/**
 * Created by Vestein on 25.04.2016.
 */
public class RenderGrid extends EntityRenderer<GridNew> {

  private ShapeRenderer shape = new ShapeRenderer();

  public RenderGrid() {
    super(GridNew.class);
  }

  @Override
  public void renderEntity(GridNew grid, Camera camera, Batch batch) {

    shape.setProjectionMatrix(camera.combined);

    Gdx.gl.glEnable(GL20.GL_BLEND);
    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    shape.begin(ShapeRenderer.ShapeType.Filled);
    shape.setColor(0.5f, 0.5f, 0.5f, 0.5f);
    shape.rect(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    shape.end();

    shape.begin(ShapeRenderer.ShapeType.Line);
    shape.setColor(0.0f, 0.0f, 0.0f, 1.0f);
    for (int i = 0; i < grid.SIZE + 1; i++) {
      final float x = VIEWPORT_WIDTH / 2 + VIEWPORT_WIDTH / grid.SIZE * i;
      shape.line(x, VIEWPORT_HEIGHT / 2, x, VIEWPORT_HEIGHT / 2 + VIEWPORT_HEIGHT);
    }
    for (int i = 0; i < grid.SIZE + 1; i++) {
      final float y = VIEWPORT_HEIGHT / 2 + VIEWPORT_HEIGHT / grid.SIZE * i;
      shape.line(VIEWPORT_HEIGHT / 2, y, VIEWPORT_HEIGHT / 2 + VIEWPORT_HEIGHT, y);
    }
    shape.setColor(1.0f, 0.0f, 0.0f, 1.0f);
    shape.line(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2 );
    shape.end();
    Gdx.gl.glDisable(GL20.GL_BLEND);
  }

}
