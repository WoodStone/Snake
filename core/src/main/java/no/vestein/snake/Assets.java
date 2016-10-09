package no.vestein.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Vestein Dahl
 * Date: 09.10.2016
 * Time: 22.07
 */
public class Assets implements Disposable, AssetErrorListener {

  public static final String TAG = Assets.class.getName();
  public static final Assets instance = new Assets();

  private AssetManager assetManager;

  private Assets() {}

  public void init(AssetManager assetManager) {
    this.assetManager = assetManager;
    assetManager.setErrorListener(this);
    //assetManager.load(Reference.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);

    assetManager.finishLoading();
    Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
    for (String asset : assetManager.getAssetNames()) {
      Gdx.app.debug(TAG, "asset: " + asset);
    }
  }

  @Override
  public void error(AssetDescriptor asset, Throwable throwable) {
    Gdx.app.error(TAG, "Could not load asset '" + asset.fileName + "'", throwable);
  }

  @Override
  public void dispose() {
    assetManager.dispose();
  }
}
