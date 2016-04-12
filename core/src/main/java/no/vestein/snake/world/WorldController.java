package no.vestein.snake.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import no.vestein.snake.*;
import no.vestein.snake.graphics.GridSprite;
import no.vestein.snake.graphics.SnakeSprite;

/**
 * Created by Vestein on 12.03.2016.
 */
public class WorldController extends InputAdapter implements Updatable {

  private static final String TAG = WorldController.class.getName();
  private Sprite[] sprites;
  private int selectedSprite;
  public CameraHelper cameraHelper;
  public GridSprite gridSprite;
  public SnakeSprite snakeSprite;
  public Grid grid;

  public WorldController() {
    init();
  }

  private void init() {
    Gdx.input.setInputProcessor(this);
    cameraHelper = new CameraHelper();
    cameraHelper.setPosition(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    cameraHelper.setZoom(1.2f);
    gridSprite = new GridSprite();
    snakeSprite = new SnakeSprite();
    grid = new Grid(17, gridSprite);

    grid.addSprite("snake", snakeSprite);
    grid.moveSpriteToOrigin("snake");

//    snakeSprite.setPosition(Reference.VIEWPORT_WIDTH - snakeSprite.getWidth() / 2.0f, Reference.VIEWPORT_HEIGHT - snakeSprite.getHeight() / 2.0f);
    initObjects();
  }

  public void update(float deltatime) {
    handleInput(deltatime);
    updateObjects(deltatime);
    cameraHelper.update(deltatime);
  }

  @Override
  public boolean keyDown(int keycode) {
    if (keycode == Input.Keys.R) {
      init();
      Gdx.app.debug(TAG, "Game world resetted.");
    } else if (keycode == Input.Keys.SPACE) {
//      selectedSprite = (selectedSprite + 1) % sprites.length;
//
//      if (cameraHelper.hastarget()) {
//        cameraHelper.setTarget(sprites[selectedSprite]);
//      }
//
//      Gdx.app.debug(TAG, "Sprite #" + selectedSprite + " selected");
      Gdx.app.debug(TAG, snakeSprite.getX() + ":" + snakeSprite.getY());
    } else if (keycode == Input.Keys.ENTER) {
//      cameraHelper.setTarget(cameraHelper.hastarget() ? null : sprites[selectedSprite]);
//      Gdx.app.debug(TAG, "Camera follow enabled: " + cameraHelper.hastarget());
      Gdx.app.debug(TAG, snakeSprite.getWidth() + ".." + snakeSprite.getHeight());
    } else if (keycode == Input.Keys.A) {
//      snakeSprite.translateX(-snakeSprite.getWidth());
//      snakeSprite.setX(snakeSprite.getX() - 32.0f / 17.0f);
      grid.moveSpriteLeft("snake");
    } else if (keycode == Input.Keys.D) {
      grid.moveSpriteRight("snake");
    } else if (keycode == Input.Keys.W) {
      grid.moveSpriteUp("snake");
    } else if (keycode == Input.Keys.S) {
      grid.moveSpriteDown("snake");
    }
    return false;
  }

  private void handleInput(final float deltaTime) {
//    final float moveSpeed = 5 * deltaTime;
//    if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//      moveSelectedSprite(-moveSpeed, 0);
//    }
//    if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//      moveSelectedSprite(moveSpeed, 0);
//    }
//    if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//      moveSelectedSprite(0, moveSpeed);
//    }
//    if (Gdx.input.isKeyPressed(Input.Keys.S)) {
//      moveSelectedSprite(0, -moveSpeed);
//    }
  }

  private void moveSelectedSprite(final float x, final float y) {
    sprites[selectedSprite].translate(x, y);
  }

  private void initObjects() {
    sprites = new Sprite[5];

    final int width = 64;
    final int height = 64;
    Pixmap pixmap = createProceduralPixmap(width, height);
    Texture texture = new Texture(pixmap, true);
    texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
    //texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.MipMapLinearLinear);

    for (int i = 0; i < sprites.length; i++) {
      Sprite sprite = new Sprite(texture);
      sprite.setSize(1.0f, 1.0f);
      sprite.setOrigin(sprite.getWidth() / 2.0f, sprite.getHeight() / 2.0f);

      final float randomX = MathUtils.random(-2.0f, 2.0f);
      final float randomY = MathUtils.random(-2.0f, 2.0f);
      sprite.setPosition(randomX, randomY);

      sprites[i] = sprite;
    }

    selectedSprite = 0;
  }

  private void updateObjects(final float deltaTime) {
    float rotation = sprites[selectedSprite].getRotation();
    rotation += 90 * deltaTime;
    rotation %= 360;
    sprites[selectedSprite].setRotation(rotation);
  }

  private Pixmap createProceduralPixmap(final int width, final int height) {
    Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    pixmap.setColor(1, 0, 0, 0.5f);
    pixmap.fill();

    pixmap.setColor(1, 1, 0, 1);
    pixmap.drawLine(0, 0, width, height);
    pixmap.drawLine(width, 0, 0, height);

    pixmap.setColor(0, 1, 1, 1);
    pixmap.drawRectangle(0, 0, width, height);
    return pixmap;
  }

  public Sprite[] getSprites() {
    return sprites;
  }

}
