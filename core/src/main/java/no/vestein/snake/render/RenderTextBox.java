package no.vestein.snake.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import no.vestein.snake.Reference;
import no.vestein.snake.assets.AssetFonts;
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

  public RenderTextBox() {
    super(TextBox.class);
  }

  @Override
  public void renderEntity(TextBox entity, Camera camera, Batch batch) {
    shape.setProjectionMatrix(camera.combined);

    Gdx.gl.glEnable(GL20.GL_BLEND);
    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    shape.begin(ShapeRenderer.ShapeType.Filled);
    shape.setColor(0.0f, 0.5f, 0.5f, 0.5f);
    shape.rect(-200.0f, -200.0f, 400.0f, 400.0f);
    shape.end();

    Gdx.gl.glDisable(GL20.GL_BLEND);

    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    BitmapFont font = Assets.instance.fonts.sourceCodeRegular;
    font.getData().setScale(0.5f);
    font.setColor(Color.BLACK);

    List<String> lines = entity.getText();
    for (int i = 0; i<lines.size(); i++) {
      LuaGlyph glyph = new LuaGlyph(Assets.instance.fonts.sourceCodeRegular);
      glyph.setText(lines.get(i));
      glyph.setPos(-190.0f, 190.0f - i * 20.0f);
      font.draw(batch, glyph, glyph.getPos().x, glyph.getPos().y);
    }

    batch.end();
  }

}
