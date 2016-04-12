package no.vestein.snake.graphics;

/**
 * Created by Vestein on 12.04.2016.
 */
public class Pixmap extends com.badlogic.gdx.graphics.Pixmap {

  public Pixmap(int width, int height, Format format) {
    super(width, height, format);
  }

  public void drawLine(int x, int y, int x2, int y2, int size) {
    for (int i = 1; i < size; i++) {
      drawLine(x - i, y - i, x2 - i, y2 - i);
      drawLine(x + i, y + i, x2 + i, y2 + i);
    }
    drawLine(x, y, x2, y2);
  }

  public void drawRectangle(int x, int y, int width, int height, int size) {
    for (int i = 1; i < size; i++) {
      drawRectangle(x + i, y + i, width - i * 2, height - i * 2);
      drawRectangle(x - i, y - i, width + i * 2, height + i * 2);
    }
    drawRectangle(x, y, width, height);
  }

}
