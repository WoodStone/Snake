package no.vestein.snake;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import no.vestein.snake.graphics.GridSprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 12.04.2016.
 */
public class Grid implements Updatable {

  public final int SIZE;

  private Map<String, Sprite> sprites = new HashMap<>();
  private Map<String, Vector2> spritesPos = new HashMap<>();
  private GridSprite gridSprite;
  private Vector2 origin;
  private int max;
  private int min;
  private final float step;

  public Grid(final int SIZE, GridSprite gridSprite) {
    this.SIZE = SIZE;
    this.gridSprite = gridSprite;

    origin = new Vector2(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    max = (int) Math.floor(SIZE / 2);
    min = -max;

    step = Reference.VIEWPORT_WIDTH / SIZE;
  }

  public void addSprite(String key, Sprite sprite) {
    sprites.put(key, sprite);
    spritesPos.put(key, new Vector2(0.0f, 0.0f));
  }

  public void moveSprite(String key, int modX, int modY) {
    Vector2 pos = spritesPos.get(key);
    Vector2 newPos = new Vector2(pos.x + modX, pos.y + modY);
    Sprite sprite = sprites.get(key);

    if (newPos.x >= min && newPos.x <= max && newPos.y >= min && newPos.y <= max) {
      sprite.setX(origin.x + step * newPos.x - sprite.getWidth() / 2);
      sprite.setY(origin.y + step * newPos.y - sprite.getHeight() / 2);
      spritesPos.put(key, newPos);
    }

  }

  public void moveSpriteToOrigin(String key) {
    Sprite sprite = sprites.get(key);
    sprite.setPosition(origin.x - sprite.getWidth() / 2, origin.y - sprite.getHeight() / 2);
  }

  public boolean moveSpriteLeft(String key) {
    moveSprite(key, -1, 0);
    return true;
  }

  public boolean moveSpriteRight(String key) {
    moveSprite(key, 1, 0);
    return true;
  }

  public boolean moveSpriteUp(String key) {
    moveSprite(key, 0, 1);
    return true;
  }

  public boolean moveSpriteDown(String key) {
    moveSprite(key, 0, -1);
    return true;
  }

  @Override
  public void update(float deltaTime) {

  }

  public boolean keyDown(int keycode) {

    return false;
  }

}
