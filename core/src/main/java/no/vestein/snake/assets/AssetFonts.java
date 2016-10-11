package no.vestein.snake.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import no.vestein.snake.Reference;

/**
 * Created by Vestein Dahl
 * Date: 10.10.2016
 * Time: 00.16
 */
public class AssetFonts {

  public final BitmapFont sourceCodeRegular;
  public final BitmapFont sourceCodeRegularHighRes;
  public final BitmapFont sourceCodeRegularScale;

  public AssetFonts() {
    sourceCodeRegular = new BitmapFont(Gdx.files.internal("sourcecode.fnt"));
    sourceCodeRegular.getData().setScale(1.0f);
    sourceCodeRegular.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    sourceCodeRegularHighRes = new BitmapFont(Gdx.files.internal("sourcecodehighres.fnt"));
    sourceCodeRegularHighRes.getData().setScale(0.125f);
    sourceCodeRegularHighRes.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    sourceCodeRegularScale = loadFont();
  }

  private BitmapFont loadFont() {
    final float SCALE = 1.0f * Gdx.graphics.getWidth() / Reference.VIEWPORT_UI_WIDTH;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("SourceCodePro-Regular.ttf"));

    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    parameter.size = (int) (16 * SCALE);
    BitmapFont font = generator.generateFont(parameter);
    font.getData().setScale(1.0f / SCALE);

    font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    return font;
  }

}
