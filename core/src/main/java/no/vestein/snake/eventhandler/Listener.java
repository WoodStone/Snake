package no.vestein.snake.eventhandler;

import java.lang.reflect.Method;

public class Listener {

  public final Object OBJECT;
  public final Method METHOD;

  public Listener(final Object listener, final Method method) {
    this.OBJECT = listener;
    this.METHOD = method;
  }

  @Override
  public boolean equals(final Object listener) {
    return listener instanceof Listener && this.hashCode() == listener.hashCode();
  }

  @Override
  public int hashCode() {
    return OBJECT.hashCode() + METHOD.hashCode();
  }

}
