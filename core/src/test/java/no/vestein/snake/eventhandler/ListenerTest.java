package no.vestein.snake.eventhandler;

import no.vestein.snake.eventhandler.events.PositionEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ListenerTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void hashCodeTest() throws Exception {

    final Object o1 = new Object();
    final Object o2 = new Object();
    final Method m11 = o1.getClass().getMethods()[0];
    final Method m12 = o1.getClass().getMethods()[3];
    final Method m21 = o2.getClass().getMethods()[0];
    final Method m22 = o2.getClass().getMethods()[3];

    final Listener l11_0 = new Listener(o1, m11);
    final Listener l11_1 = new Listener(o1, m11);
    final Listener l12_0 = new Listener(o1, m12);
    final Listener l12_1 = new Listener(o1, m12);

    assertEquals(l11_0.hashCode(), l11_0.hashCode());
    assertEquals(l11_0.hashCode(), l11_1.hashCode());
    assertEquals(l11_1.hashCode(), l11_1.hashCode());

    assertEquals(l12_0.hashCode(), l12_0.hashCode());
    assertEquals(l12_0.hashCode(), l12_1.hashCode());
    assertEquals(l12_1.hashCode(), l12_1.hashCode());

    assertNotEquals(l11_0.hashCode(), l12_0.hashCode());
    assertNotEquals(l11_0.hashCode(), l12_1.hashCode());


  }

  private class ListenerClass {

    @SubToEvent
    public void onNewPosistion(PositionEvent event) {

    }

  }

}