package no.vestein.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Vestein on 13.03.2016.
 */
public class GridSprite extends Sprite {

  private static final String TAG = Sprite.class.getName();

  public GridSprite() {
    super(texture());
    setSize(Reference.VIEWPORT_WIDTH, Reference.VIEWPORT_HEIGHT);
    setScale(0.8f);
    setOrigin(getWidth() / 2.0f, getHeight() / 2.0f);
//    setPosition(Reference.VIEWPORT_WIDTH / 2.0f, Reference.VIEWPORT_HEIGHT / 2.0f);
    setPosition(Reference.VIEWPORT_WIDTH - getWidth() / 2.0f, Reference.VIEWPORT_HEIGHT - getHeight() / 2.0f);
  }

  private static Texture texture() {
    Pixmap pixmap = createPixmap(544, 544);
    Texture texture = new Texture(pixmap, true);
    texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    return texture;
  }

  private static Pixmap createPixmap(final int width, final int height) {
    Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    pixmap.setColor(0.5f, 0.5f, 0.5f, 0.5f);
    pixmap.fill();

    pixmap.setColor(0, 0, 0, 1);
    for (int i = 1; i < width / 32; i++) {
      Gdx.app.debug(TAG, Integer.toString(i * 32));
      pixmap.drawLine(i * 32, 0, i * 32, height);
    }
    for (int i = 1; i < height / 32; i++) {
      Gdx.app.debug(TAG, Integer.toString(i * 32));
      pixmap.drawLine(0, i * 32, width, i * 32);
    }

    pixmap.drawRectangle(0, 0, width, height);

    pixmap.setColor(1.0f, 0f, 0f, 0.5f);
    pixmap.fillCircle(width / 2, height / 2, 16);

    return pixmap;
  }

}
