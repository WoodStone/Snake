package no.vestein.snake.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import no.vestein.snake.Reference;
import no.vestein.snake.Updatable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 12.04.2016.
 */
public class Grid extends Entity implements Updatable {

  public final int SIZE;

  private Map<String, Sprite> sprites = new HashMap<>();
  private Map<String, Vector2> spritesPos = new HashMap<>();
//  private GridSprite gridSprite;
  private Vector2 origin;
  private int max;
  private int min;
  private final float step;
  private ShapeRenderer shape = new ShapeRenderer();

  public Grid(final int SIZE) {
    this.SIZE = SIZE;
//    this.gridSprite = gridSprite;

    origin = new Vector2(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    max = (int) Math.floor(SIZE / 2);
    min = -max;

    step = Reference.VIEWPORT_WIDTH / SIZE;
  }

//  public void render(Camera camera) {
//
//    shape.setProjectionMatrix(camera.combined);
//
//    Gdx.gl.glEnable(GL20.GL_BLEND);
//    shape.begin(ShapeRenderer.ShapeType.Filled);
//    shape.setColor(0.5f, 0.5f, 0.5f, 0.5f);
//    shape.rect(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
//    shape.end();
//
//    shape.begin(ShapeRenderer.ShapeType.Line);
//    shape.setColor(0.0f, 0.0f, 0.0f, 1.0f);
//    for (int i = 0; i < SIZE + 1; i++) {
//      final float x = VIEWPORT_WIDTH / 2 + VIEWPORT_WIDTH / SIZE * i;
//      shape.line(x, VIEWPORT_HEIGHT / 2, x, VIEWPORT_HEIGHT / 2 + VIEWPORT_HEIGHT);
//    }
//    for (int i = 0; i < SIZE + 1; i++) {
//      final float y = VIEWPORT_HEIGHT / 2 + VIEWPORT_HEIGHT / SIZE * i;
//      shape.line(VIEWPORT_HEIGHT / 2, y, VIEWPORT_HEIGHT / 2 + VIEWPORT_HEIGHT, y);
//    }
//    shape.setColor(1.0f, 0.0f, 0.0f, 1.0f);
//    shape.line(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2 );
//    shape.end();
//
////    Gdx.gl.glClearColor(0, 0, 0, 0);
////    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//  }

  public void addSprite(String key, Sprite sprite) {
    sprites.put(key, sprite);
    spritesPos.put(key, new Vector2(0.0f, 0.0f));
  }

  public void moveSprite(String key, int modX, int modY) {
    Vector2 pos = spritesPos.get(key);
    Vector2 newPos = new Vector2(pos.x + modX, pos.y + modY);
    Sprite sprite = sprites.get(key);

    if (newPos.x >= min && newPos.x <= max && newPos.y >= min && newPos.y <= max) {
      sprite.setCenter(origin.x + step * newPos.x, origin.y + step * newPos.y);
      spritesPos.put(key, newPos);
    }

  }

  public void moveSpriteToOrigin(String key) {
    Sprite sprite = sprites.get(key);
//    sprite.setPosition(origin.x - sprite.getWidth() / 2, origin.y - sprite.getHeight() / 2);
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
