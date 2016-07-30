package no.vestein.snake.eventhandler;

import no.vestein.snake.eventhandler.events.Event;

import java.lang.reflect.Method;
import java.util.Map;

public class EventBus {

  public EventBus() {

  }

  public void register(final Object object) {
    try {
      for (final Method method : object.getClass().getMethods()) {
        if (method.isAnnotationPresent(SubToEvent.class)) {
          final Class<?>[] params = method.getParameterTypes();
          if (params.length == 1) {
            final Class<?> argClass = params[0];
            if (Event.class.isAssignableFrom(argClass)) {
              Event.getListenerList(argClass.asSubclass(Event.class)).register(object, method);
            } else {
              throw new IllegalArgumentException("Argument is not a subclass of Event");
            }
          } else {
            throw new IllegalArgumentException("@SubToEvent only allows the method to have one argument.");
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void unregister(final Object object) {
    try {
      for (final Method method: object.getClass().getMethods()) {
        if (method.isAnnotationPresent(SubToEvent.class)) {
          final Class<?>[] params = method.getParameterTypes();
          if (params.length == 1) {
            final Class<?> argClass = params[0];
            if (Event.class.isAssignableFrom(argClass)) {
              Event.getListenerList(argClass.asSubclass(Event.class)).unregister(object);
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void post(final Event event) {
    final Map<Object, Method> listenerMap = event.getListenerList().getListeners();
    for (Map.Entry<Object, Method> entry : listenerMap.entrySet()) {
      final Object object = entry.getKey();
      final Method method = entry.getValue();
      try {
        method.invoke(object, event);
      } catch (Exception e) {
        e.printStackTrace();
        //TODO exception method invoke
      }
    }
  }

}
