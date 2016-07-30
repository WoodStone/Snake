package no.vestein.snake.eventhandler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ListenerList {

  private Map<Object, Method> map = new HashMap<>();

  public ListenerList() {

  }

  public void register(final Object o, final Method m) {
    map.put(o, m);
  }

  public void unregister(final Object o) {
    map.remove(o);
  }

  public Map<Object, Method> getListeners() {
    return map;
  }

}
