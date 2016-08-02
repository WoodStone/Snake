package no.vestein.snake.eventhandler.events;

import no.vestein.snake.eventhandler.ListListenerList;
import no.vestein.snake.eventhandler.Listener;
import no.vestein.snake.eventhandler.ListenerList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Event {

  private static Map<
          Class<? extends Event>,
          ListenerList<? extends Collection<Listener>>
          > classListenerMap = new HashMap<>();

  public Event() {

  }

  public ListenerList<? extends Collection<Listener>> getListenerList() {
    return getListenerList(this.getClass());
  }

  public static ListenerList<? extends Collection<Listener>> getListenerList(final Class<? extends Event> c) {
    if (!classListenerMap.containsKey(c)) {
      classListenerMap.put(c, new ListListenerList());
    }
    return classListenerMap.get(c);
  }

  public String getEventName() {
    return getClass().getSimpleName();
  }

}
