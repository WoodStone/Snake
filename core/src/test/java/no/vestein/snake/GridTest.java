package no.vestein.snake;

import no.vestein.snake.graphics.GridSprite;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * Created by Vestein on 10.04.2016.
 */
public class GridTest {

  private GridSprite grid;

  @Before
  public void setUp() throws Exception {
//    final HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
//    config.renderInterval = 1f/60;
//    new HeadlessApplication(new Snake(), config);
//    Gdx.app.postRunnable(new Runnable() {
//      @Override
//      public void run() {
//        grid = new GridSprite();
//      }
//    });
//    while (grid == null) {
//
//    }
  }

  @After
  public void tearDown() throws Exception {
    grid = null;
  }

  @Test
  public void testSomeMethod() {
//    assertFalse(grid.someMethod());
  }

}
