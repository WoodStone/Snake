package no.vestein.snake.render;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import no.vestein.snake.entities.CircleEntity;
import no.vestein.snake.graphics.SnakeSprite;

/**
 * Created by Vestein on 25.04.2016.
 */
public class RenderSnake extends EntityRenderer<CircleEntity> {

  private final SnakeSprite sprite = new SnakeSprite(18f);

  public RenderSnake() {
    super(CircleEntity.class);
  }

  @Override
  public void renderEntity(CircleEntity entity, Camera camera, Batch batch) {
    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    sprite.setCenter(entity.getPos().x, entity.getPos().y);
    sprite.draw(batch);
    batch.end();
  }

}
