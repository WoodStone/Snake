package no.vestein.snake.input;

import com.badlogic.gdx.InputAdapter;

import java.util.HashMap;
import java.util.Map;

public class InputController extends InputAdapter {

  private Map<Integer, Action> inputMap = new HashMap<>();

  @Override
  public boolean keyDown(int keyCode) {
    if (inputMap.containsKey(keyCode)) {
      inputMap.get(keyCode).call();
    }
    return false;
  }

  public void registerInput(final int keyCode, Action action) {
    if (inputMap.containsKey(keyCode)) {
      throw new IllegalArgumentException(String.format("Key, %d, already registered.", keyCode));
    }
    inputMap.put(keyCode, action);
  }

}
