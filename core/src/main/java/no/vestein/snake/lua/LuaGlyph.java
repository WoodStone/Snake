package no.vestein.snake.lua;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Vestein Dahl
 * Date: 03.10.2016
 * Time: 20.42
 */
public class LuaGlyph extends GlyphLayout {

  private BitmapFont font;
  private Vector2 pos;
//  private Vector2 realPos;

  public LuaGlyph(BitmapFont font) {
    this.font = font;
    pos = new Vector2();
//    realPos = new Vector2();
  }

  public void setText(final String text) {
    setText(font, text);
  }

  public Vector2 getPos() {
    return pos;
  }

  public void setPos(final float x, final float y) {
    pos.set(x, y);
  }

}
