package no.vestein.snake.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import no.vestein.snake.Updatable;
import no.vestein.snake.world.WorldController;

import java.util.HashMap;
import java.util.Map;

public class InputController extends InputAdapter implements Updatable {

  private final WorldController world;
  private Map<Integer, Action> inputMap = new HashMap<>();
  private Map<Integer, Boolean> continousInputList = new HashMap<>();

  public InputController(final WorldController world) {
    this.world = world;
  }

  @Override
  public boolean keyDown(int keyCode) {
    if (inputMap.containsKey(keyCode)) {
      inputMap.get(keyCode).call();
    }
    world.getScriptManager().executeKeyPressed(Input.Keys.toString(keyCode), world);

    continousInputList.remove(keyCode, true);
    return false;
  }

  @Override
  public boolean keyUp(int keyCode) {
    continousInputList.remove(keyCode, false);
    return false;
  }

  public void enableContinousInput(final int keyCode) {
    if (!continousInputList.containsKey(keyCode)) {
      continousInputList.put(keyCode, false);
    }
  }

  public void disableContinousInput(final int keyCode) {
    continousInputList.remove(keyCode);
  }

  public void registerInput(final int keyCode, Action action) {
    if (inputMap.containsKey(keyCode)) {
      throw new IllegalArgumentException(String.format("Key, %d, already registered.", keyCode));
    }
    inputMap.put(keyCode, action);
  }

  @Override
  public void update(float deltaTime) {
    for (int n : continousInputList.keySet()) {
      if (continousInputList.get(n)) {
        keyDown(n);
      }
    }
  }

}
