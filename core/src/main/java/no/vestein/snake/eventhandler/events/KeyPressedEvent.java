package no.vestein.snake.eventhandler.events;

/**
 * Created by Vestein Dahl
 * Date: 10.10.2016
 * Time: 19.05
 */
public class KeyPressedEvent extends Event {

  public final int keyCode;

  public KeyPressedEvent(final int keyCode) {
    this.keyCode = keyCode;
  }

}
