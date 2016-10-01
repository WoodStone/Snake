package no.vestein.snake.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import no.vestein.snake.*;
import no.vestein.snake.entities.CircleEntity;
import no.vestein.snake.entities.GridNew;
import no.vestein.snake.input.InputController;

/**
 * Created by Vestein on 12.03.2016.
 */
public class WorldController implements Updatable {

  private static final String TAG = WorldController.class.getName();
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
    grid = new GridNew(11);
    grid.addEntity("circle", circleEntity);
    grid.moveEntityToOrigin("circle");
    initInput();
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

}
