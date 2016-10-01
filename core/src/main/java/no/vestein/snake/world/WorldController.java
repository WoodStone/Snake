package no.vestein.snake.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import no.vestein.snake.*;
import no.vestein.snake.entities.CircleEntity;
import no.vestein.snake.entities.Grid;
import no.vestein.snake.entities.GridNew;
import no.vestein.snake.graphics.SnakeSprite;
import no.vestein.snake.input.InputController;

/**
 * Created by Vestein on 12.03.2016.
 */
public class WorldController implements Updatable {

  private static final String TAG = WorldController.class.getName();
  private Sprite[] sprites;
  private int selectedSprite;
  private InputController inputController;
  public CameraHelper cameraHelper;
  public CircleEntity circleEntity;
  public GridNew grid;

  public WorldController() {
    init();
  }

  private void init() {
    inputController = new InputController();
    Gdx.input.setInputProcessor(inputController);
    cameraHelper = new CameraHelper();
    cameraHelper.setPosition(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    cameraHelper.setZoom(1.2f);
    circleEntity = new CircleEntity();
//    grid = new Grid(17);
//    grid.addSprite("snake", circleEntity);
//    grid.moveSpriteToOrigin("snake");
    grid = new GridNew(11);
    grid.addEntity("circle", circleEntity);
    grid.moveEntityToOrigin("circle");
    initInput();
//    initObjects();
  }

  public void update(float deltatime) {
//    updateObjects(deltatime);
    cameraHelper.update(deltatime);
  }

  private void initInput() {
    //Snake
    /*inputController.registerInput(Input.Keys.A, () -> grid.moveSpriteLeft("snake"));
    inputController.registerInput(Input.Keys.D, () -> grid.moveSpriteRight("snake"));
    inputController.registerInput(Input.Keys.W, () -> grid.moveSpriteUp("snake"));
    inputController.registerInput(Input.Keys.S, () -> grid.moveSpriteDown("snake"));*/

    //Debug
    inputController.registerInput(Input.Keys.R, this::init);
//    inputController.registerInput(Input.Keys.SPACE, () ->
//            Gdx.app.debug(TAG, circleEntity.getX() + ":" + circleEntity.getY()));
  }

  private void moveSelectedSprite(final float x, final float y) {
    sprites[selectedSprite].translate(x, y);
  }

//  private void initObjects() {
//    sprites = new Sprite[5];
//
//    final int width = 64;
//    final int height = 64;
//    Pixmap pixmap = createProceduralPixmap(width, height);
//    Texture texture = new Texture(pixmap, true);
//    texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
//    //texture.setFilter(Texture.TextureFilter.MipMapLinearLinear, Texture.TextureFilter.MipMapLinearLinear);
//
//    for (int i = 0; i < sprites.length; i++) {
//      Sprite sprite = new Sprite(texture);
//      sprite.setSize(1.0f, 1.0f);
//      sprite.setOrigin(sprite.getWidth() / 2.0f, sprite.getHeight() / 2.0f);
//
//      final float randomX = MathUtils.random(-2.0f, 2.0f);
//      final float randomY = MathUtils.random(-2.0f, 2.0f);
//      sprite.setPosition(randomX, randomY);
//
//      sprites[i] = sprite;
//    }
//
//    selectedSprite = 0;
//  }

  private void updateObjects(final float deltaTime) {
    float rotation = sprites[selectedSprite].getRotation();
    rotation += 90 * deltaTime;
    rotation %= 360;
    sprites[selectedSprite].setRotation(rotation);
  }

//  private Pixmap createProceduralPixmap(final int width, final int height) {
//    Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
//    pixmap.setColor(1, 0, 0, 0.5f);
//    pixmap.fill();
//
//    pixmap.setColor(1, 1, 0, 1);
//    pixmap.drawLine(0, 0, width, height);
//    pixmap.drawLine(width, 0, 0, height);
//
//    pixmap.setColor(0, 1, 1, 1);
//    pixmap.drawRectangle(0, 0, width, height);
//    return pixmap;
//  }
//
//  public Sprite[] getSprites() {
//    return sprites;
//  }
//
}
