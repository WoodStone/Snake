package no.vestein.snake.world;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import no.vestein.snake.*;
import no.vestein.snake.entities.CircleEntity;
import no.vestein.snake.entities.GridNew;
import no.vestein.snake.entities.TextBox;
import no.vestein.snake.input.InputController;
import no.vestein.snake.lua.Script;
import no.vestein.snake.lua.ScriptManager;
import no.vestein.snake.screens.GameScreen;
import no.vestein.snake.screens.MenuScreen;

/**
 * Created by Vestein on 12.03.2016.
 */
public class WorldController implements Updatable {

  private static final String TAG = WorldController.class.getName();
  private InputController inputController;
  private ScriptManager scriptManager;
  private Game game;

  public CameraHelper cameraHelper;
  public CircleEntity circleEntity;
  public GridNew grid;
  public TextBox textBox;

  public WorldController(Game game) {
    this.game = game;
    init();
  }

  private void backToMenu() {
    game.setScreen(new MenuScreen(game));
  }

  private void init() {
    inputController = new InputController(this);
    Gdx.input.setInputProcessor(inputController);

    {
      scriptManager = new ScriptManager("scripts/debug.lua");
      scriptManager.executeInit(this);
    }


    cameraHelper = new CameraHelper();
    cameraHelper.setPosition(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    cameraHelper.setZoom(1.2f);

    textBox = new TextBox(20, 30);
    GameScreen.EVENT_BUS.register(textBox);

    circleEntity = new CircleEntity();
    grid = new GridNew(11);
    grid.addEntity("circle", circleEntity);
    grid.moveEntityToOrigin("circle");
    initInput();
  }

  public Script getScriptManager() {
    return scriptManager;
  }

  public void update(float deltatime) {
//    updateObjects(deltatime);
    cameraHelper.update(deltatime);
  }

  private void initInput() {
    //Controlls
    //todo input

    //Debug
    //inputController.registerInput(Input.Keys.R, this::init);
  }

}
