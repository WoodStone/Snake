package no.vestein.snake.eventhandler.events;

import no.vestein.snake.eventhandler.ListenerList;

import java.util.HashMap;
import java.util.Map;

public abstract class Event {

  private static Map<Class<? extends Event>, ListenerList> classListenerMap = new HashMap<>();

  public Event() {

  }

  public ListenerList getListenerList() {
    return getListenerList(this.getClass());
  }

  public static ListenerList getListenerList(final Class<? extends Event> c) {
    if (!classListenerMap.containsKey(c)) {
      classListenerMap.put(c, new ListenerList());
    }
    return classListenerMap.get(c);
  }

  public String getEventName() {
    return getClass().getSimpleName();
  }

}
