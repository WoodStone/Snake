package no.vestein.snake.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import no.vestein.snake.Reference;

/**
 * Created by Vestein on 13.03.2016.
 */
public class GridSprite extends Sprite {

  private static final String TAG = Sprite.class.getName();

  public GridSprite() {
    super(texture());
    setSize(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    setOrigin(getWidth() / 2.0f, getHeight() / 2.0f);
    setPosition(Reference.VIEWPORT_WIDTH - getWidth() / 2.0f, Reference.VIEWPORT_HEIGHT - getHeight() / 2.0f);
  }

  private static Texture texture() {
    Pixmap pixmap = createPixmap(544 * 4, 544 * 4);
    Texture texture = new Texture(pixmap, true);
//    texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    return texture;
  }

  private static Pixmap createPixmap(final int width, final int height) {
    Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    pixmap.setColor(0.5f, 0.5f, 0.5f, 0.5f);
    pixmap.fill();

    final int iVal = 128;

    pixmap.setColor(0, 0, 0, 1);
    for (int i = 1; i < width / iVal; i++) {
      pixmap.drawLine(i * iVal, 0, i * iVal, height, 2);
    }
    for (int i = 1; i < height / iVal; i++) {
      pixmap.drawLine(0, i * iVal, width, i * iVal, 2);
    }

    pixmap.drawRectangle(0, 0, width, height, 4);

    pixmap.setColor(1.0f, 0f, 0f, 0.5f);
    pixmap.fillCircle(width / 2, height / 2, 16);

    return pixmap;
  }

}
