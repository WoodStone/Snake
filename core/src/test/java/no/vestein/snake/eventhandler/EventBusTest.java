package no.vestein.snake.eventhandler;

import no.vestein.snake.eventhandler.events.Event;
import no.vestein.snake.eventhandler.events.PositionEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class EventBusTest {

  private EventBus EVENT_BUS;
  private boolean EVENT_POSTED;

  @Before
  public void setUp() throws Exception {
    EVENT_BUS = new EventBus();
    EVENT_POSTED = false;
  }

  @After
  public void tearDown() throws Exception {
    EVENT_BUS.dispose();
    EVENT_BUS = null;
  }

  @Test
  public void register() throws Exception {
    final TestListenerClass tl1 = new TestListenerClass();

    EVENT_BUS.register(tl1);

    Collection<Listener> lc = Event.getListenerList(PositionEvent.class).getListeners();
    assertEquals(lc.size(), 1);
    final Listener listener = lc.iterator().next();
    assertEquals(listener.OBJECT, tl1);
  }

  @Test
  public void unregister() throws Exception {
    final TestListenerClass tl1 = new TestListenerClass();
    Collection<Listener> lc;

    EVENT_BUS.register(tl1);
    lc = Event.getListenerList(PositionEvent.class).getListeners();
    assertEquals(lc.size(), 1);

    EVENT_BUS.unregister(tl1);
    lc = Event.getListenerList(PositionEvent.class).getListeners();
    assertEquals(lc.size(), 0);
  }

  @Test
  public void post() throws Exception {

    final ListenerClass lc = new ListenerClass() {
      @Override
      @SubToEvent
      public void onNewPosistion(PositionEvent event) {
        EVENT_POSTED = true;
      }
    };

    EVENT_BUS.register(lc);

    EVENT_BUS.post(new PositionEvent(1, 2));
    assertTrue(checkPost());

    EVENT_BUS.unregister(lc);
    EVENT_BUS.post(new PositionEvent(2, 1));
    assertFalse(checkPost());

  }

  private boolean checkPost() {
    if (EVENT_POSTED) {
      EVENT_POSTED = false;
      return true;
    }
    return false;
  }

  private interface ListenerClass {
    @SubToEvent
    void onNewPosistion(PositionEvent event);
  }

  private class TestListenerClass {

    @SubToEvent
    public void onNewPosistion(PositionEvent event) {

    }

  }

}