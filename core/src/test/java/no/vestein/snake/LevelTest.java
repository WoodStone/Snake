package no.vestein.snake;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vestein on 10.04.2016.
 */
public class LevelTest {

  private Level level;

  @Before
  public void setUp() throws Exception {
    level = new Level();
  }

  @After
  public void tearDown() throws Exception {
    level = null;
  }

  @Test
  public void testBooleanTrue() throws Exception {
    assertTrue(level.booleanTrue());
  }

  @Test
  public void testBooleanFalse() throws Exception {
    assertFalse(level.booleanFalse());
  }

}