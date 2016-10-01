package no.vestein.snake.entities;

import com.badlogic.gdx.math.Vector2;
import no.vestein.snake.Reference;
import no.vestein.snake.Updatable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 26.04.2016.
 */
public class GridNew extends Entity implements Updatable {

  public final int SIZE;

  private final Vector2 ORIGIN;
  private final float STEP;
  private final int MAX;
  private final int MIN;

  private Map<String, Entity> entities = new HashMap<>();
  private Entity[][] grid;

  public GridNew(final int SIZE) {
    this.SIZE = SIZE;
    grid = new Entity[SIZE][SIZE];

    ORIGIN = new Vector2((float) Math.ceil(Reference.VIEWPORT_WIDTH / 2), (float) Math.ceil(Reference.VIEWPORT_HEIGHT / 2));
    MAX = (int) Math.floor(SIZE / 2);
    MIN = -MAX;
    STEP = Reference.VIEWPORT_WIDTH / SIZE;
  }

  public void addEntity(String key, Entity entity) {
    entities.put(key, entity);
  }

  public void setEntityPos(String key, int x, int y) {
    if (x >= MIN && x <= MAX && y >= MIN && y <= MAX) {
      Entity entity = entities.get(key);
      grid[x-1][y-1] = entity;

      Vector2 pos = new Vector2(
              (Reference.VIEWPORT_WIDTH + STEP) / 2 + (x-1) * STEP,
              (Reference.VIEWPORT_HEIGHT + STEP) / 2 + (y-1) * STEP
      );
      entities.get(key).setPos(pos);
    }
  }

  public void translateEntity(String key, int modX, int modY) {
    if (entities.containsKey(key)) {
      Entity entity = entities.get(key);

      Vector2 oldPos = entity.getPos();
      Vector2 newPos = new Vector2(oldPos.x + modX, oldPos.y + modY);

      //TODO Fix entity movement (?)
      if (newPos.x >= MIN && newPos.x <= MAX && newPos.y >= MIN && newPos.y <= MAX) {
//        setEntityPos(key, newPos.x, newPos.y);
      }
    }
  }

  public void moveEntityToOrigin(String key) {
    Entity entity = entities.get(key);
    //TODO Set position to center.
    float c = (float) Math.ceil(SIZE / 2);
    Vector2 center = new Vector2(
            (Reference.VIEWPORT_WIDTH + STEP) / 2 + c * STEP,
            (Reference.VIEWPORT_HEIGHT + STEP) / 2 + c * STEP
    );
    entities.get(key).setPos(center);
  }

  public void moveEntityNorth(String key) {
    translateEntity(key, 0, 1);
  }

  public void moveEntitySouth(String key) {
    translateEntity(key, 0, -1);
  }

  public void moveEntityWest(String key) {
    translateEntity(key, 1, 0);
  }

  public void moveEntityEast(String key) {
    translateEntity(key, -1, 0);
  }

  @Override
  public void update(float deltaTime) {
    //TODO Do the update stuff.
  }

}
