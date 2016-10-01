package no.vestein.snake.entities;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Vestein on 25.04.2016.
 */
public abstract class Entity {

  private Vector2 pos = new Vector2();

  public Entity() {

  }

  public void setPos(final float x, final float y) {
    pos.set(x, y);
  }

  public void setPos(final Vector2 newPos) {
    setPos(newPos.x, newPos.y);
  }

  public Vector2 getPos() {
    return pos;
  }

}
