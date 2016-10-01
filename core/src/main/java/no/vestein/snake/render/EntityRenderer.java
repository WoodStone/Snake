package no.vestein.snake.render;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import no.vestein.snake.entities.Entity;

/**
 * Created by Vestein on 25.04.2016.
 */
public abstract class EntityRenderer<E extends Entity> {

  private final Class<? extends Entity> entityClass;

  public EntityRenderer(Class<? extends Entity> entityClass) {
    this.entityClass = entityClass;
  }

  public Class<? extends Entity> getEntityClass() {
    return entityClass;
  }

  public abstract void renderEntity(E entity, Camera camera, Batch batch);



}
