package no.vestein.snake.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import no.vestein.snake.assets.Assets;
import no.vestein.snake.entities.TextBox;
import no.vestein.snake.lua.LuaGlyph;

import java.util.List;

/**
 * Created by Vestein Dahl
 * Date: 10.10.2016
 * Time: 19.03
 */
public class RenderTextBox extends EntityRenderer<TextBox> {

  private ShapeRenderer shape = new ShapeRenderer();
  private boolean tick = false;
  private int tickInterval = 500;
  private long lastTick;
  private boolean debug = false;
  private final float width;
  private final float height;

  public RenderTextBox() {
    super(TextBox.class);
    lastTick = System.currentTimeMillis();

    final Vector2 vec = Assets.instance.fonts.getDim();
    width = vec.x;
    height = vec.y;
  }

  @Override
  public void renderEntity(TextBox entity, Camera camera, Batch batch) {
    shape.setProjectionMatrix(camera.combined);

    Gdx.gl.glEnable(GL20.GL_BLEND);
    //Background
    {
      Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
      shape.begin(ShapeRenderer.ShapeType.Filled);
      shape.setColor(0.0f, 0.5f, 0.5f, 0.5f);
      shape.rect(-200.0f, -200.0f, 400.0f, 400.0f);
      shape.end();
    }
    //Debug lines
    {
      if (debug) {
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(1.0f, 0.0f, 0.0f, 0.6f);
        for (int i = 0; i < 20; i++) {
          shape.line(-190.0f, 190.0f - i * height, 200.0f, 190.0f - i * height);
        }
        for (int i = 0; i < 30; i++) {
          shape.line(-190.0f + i * width, 190.0f, -190.0f + i * width, -200.0f);
        }
        shape.end();
      }
    }
    //Blinking box
    {
      if (tick) {
        int x = entity.getText().getActivePos();
        int y = entity.getText().getActiveLine();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(0.0f, 0.0f, 0.0f, 0.4f);
        shape.rect(-190.0f + x * width, 190.0f - y * height + 2.0f, width, -height -2.0f);
        shape.end();
        if (System.currentTimeMillis() - lastTick > tickInterval) {
          lastTick = System.currentTimeMillis();
          tick = false;
        }
      } else {
        if (System.currentTimeMillis() - lastTick > tickInterval) {
          lastTick = System.currentTimeMillis();
          tick = true;
        }
      }
    }
    Gdx.gl.glDisable(GL20.GL_BLEND);

    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    BitmapFont font = Assets.instance.fonts.sourceCodeRegularScale;
//    font.getData().setScale(0.5f);
    font.setColor(Color.BLACK);

    List<String> lines = entity.getTextAsList();
    for (int i = 0; i<lines.size(); i++) {
      LuaGlyph glyph = new LuaGlyph(font);
      glyph.setText(lines.get(i));
      glyph.setPos(-190.0f, 190.0f - i * height);
      font.draw(batch, glyph, glyph.getPos().x, glyph.getPos().y);
    }

    batch.end();
  }

}
