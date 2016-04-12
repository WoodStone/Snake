package no.vestein.snake.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import no.vestein.snake.Reference;

/**
 * Created by Vestein on 11.04.2016.
 */
public class SnakeSprite extends Sprite {

  private static final String TAG = Sprite.class.getName();

  public SnakeSprite() {
    super(texture());
    setSize(Reference.VIEWPORT_WIDTH / 18.0f, Reference.VIEWPORT_HEIGHT / 18.0f);
    setOrigin(getWidth() / 2.0f, getHeight() / 2.0f);
  }

  private static Texture texture() {
    Pixmap pixmap = createPixmap(64, 64);
    Texture texture = new Texture(pixmap, true);
    texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    return texture;
  }

  private static Pixmap createPixmap(final int width, final int height) {
    Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    pixmap.setColor(0.0f, 1.0f, 0.0f, 0.8f);
    pixmap.fillCircle(width / 2, height / 2, 32);

    return pixmap;
  }

}
