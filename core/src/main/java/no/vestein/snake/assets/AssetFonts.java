package no.vestein.snake.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Vestein Dahl
 * Date: 10.10.2016
 * Time: 00.16
 */
public class AssetFonts {

  public final BitmapFont sourceCodeRegular;

  public AssetFonts() {
    sourceCodeRegular = new BitmapFont(Gdx.files.internal("sourcecode.fnt"));
    sourceCodeRegular.getData().setScale(1.0f);
    sourceCodeRegular.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
  }

}
