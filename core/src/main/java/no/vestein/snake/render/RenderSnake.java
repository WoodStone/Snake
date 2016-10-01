package no.vestein.snake.render;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import no.vestein.snake.entities.player.SnakeCore;
import no.vestein.snake.graphics.SnakeSprite;

/**
 * Created by Vestein on 25.04.2016.
 */
public class RenderSnake extends EntityRenderer<SnakeCore> {

  private final SnakeSprite sprite = new SnakeSprite(18f);

  public RenderSnake() {
    super(SnakeCore.class);
  }

  @Override
  public void renderEntity(SnakeCore entity, Camera camera, Batch batch) {
    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    sprite.setCenter(entity.getPos().x, entity.getPos().y);
    sprite.draw(batch);
    batch.end();
  }

}
