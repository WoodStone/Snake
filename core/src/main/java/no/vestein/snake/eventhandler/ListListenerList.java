package no.vestein.snake.eventhandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListListenerList implements ListenerList<List<Listener>> {

  private List<Listener> listeners = new ArrayList<>();

  @Override
  public void register(final Listener listener) {
    listeners.add(listener);
  }

  @Override
  public void unregister(final Listener listener) {
    listeners.remove(listener);
  }

  @Override
  public List<Listener> getListeners() {
    return listeners;
  }

  @Override
  public Iterator<Listener> iterator() {
    return listeners.iterator();
  }

}
