package no.vestein.snake.render;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import no.vestein.snake.entities.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 25.04.2016.
 */
public class RenderingRegistry {

  private Map<Class<? extends Entity>, EntityRenderer> entityRenders = new HashMap<>();

  public void registerRenderer(EntityRenderer<? extends Entity> renderer) {
    entityRenders.put(renderer.getEntityClass(), renderer);
  }

  public void renderEntity(Entity entity, Camera camera, Batch batch) {
    if (entityRenders.containsKey(entity.getClass())) {
      //TODO Render.
      //TODO Fix unchecked assignment warning.
      EntityRenderer<Entity> renderer = entityRenders.get(entity.getClass());
      renderer.renderEntity(entity, camera, batch);
    }
  }


}
