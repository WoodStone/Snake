package no.vestein.snake.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import no.vestein.snake.Reference;

/**
 * Created by Vestein on 11.04.2016.
 */
public class SnakeSprite extends Sprite {

  private static final String TAG = Sprite.class.getName();

  public SnakeSprite(final float sizeModifier) {
    super(texture());
    setSize(Reference.VIEWPORT_WIDTH / sizeModifier, Reference.VIEWPORT_HEIGHT / sizeModifier);
  }

  private static Texture texture() {
    Pixmap pixmap = createPixmap(1024, 1024);
    Texture texture = new Texture(pixmap, true);
//    texture.setFilter(Texture.TextureFilter.MipMap, Texture.TextureFilter.Linear);

    return texture;
  }

  private static Pixmap createPixmap(final int width, final int height) {
    Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    pixmap.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
    pixmap.setColor(0.0f, 1.0f, 0.0f, 0.8f);
    pixmap.fillCircle(width / 2, height / 2, 512);

    return pixmap;
  }

}
