package no.vestein.snake.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import no.vestein.snake.Reference;
import no.vestein.snake.assets.Assets;
import no.vestein.snake.graphics.Pixmap;

/**
 * Created by Vestein Dahl
 * Date: 09.10.2016
 * Time: 20.28
 */
public class MenuScreen extends AbstractScreen {

  private Stage stage;
  private Image imgLogo;
  private TextButton btnPlay;


  public MenuScreen(Game game) {
    super(game);
  }

  private void rebuildStage() {

    Table layerLogos = buildLogosLayer();
    Table layerButtons = buildButtonsLayer();

    stage.clear();
    Stack stack = new Stack();
    stage.addActor(stack);
    stack.setSize(Reference.VIEWPORT_UI_WIDTH, Reference.VIEWPORT_UI_HEIGHT);
    stack.add(layerLogos);
    stack.add(layerButtons);

  }

  private Table buildLogosLayer() {
    Table layer = new Table();
    return layer;
  }

  private Table buildButtonsLayer() {
    Table layer = new Table();
    layer.right().top();
    btnPlay = new TextButton("Start", createBasicSkin());
    btnPlay.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , Gdx.graphics.getHeight()/2);
    btnPlay.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        game.setScreen(new GameScreen(game));
      }
    });
    layer.addActor(btnPlay);

    layer.debug();
    return layer;
  }

  private Skin createBasicSkin() {
    BitmapFont font = Assets.instance.fonts.sourceCodeRegular;
    Skin skin = new Skin();
    skin.add("default", font);

    Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
    pixmap.setColor(Color.WHITE);
    pixmap.fill();
    skin.add("background", new Texture(pixmap));

    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.up = skin.newDrawable("background", new Color(0xe0e0e050));
    textButtonStyle.down = skin.newDrawable("background", Color.WHITE);
    textButtonStyle.checked = skin.newDrawable("background", Color.WHITE);
    textButtonStyle.over = skin.newDrawable("background", new Color(0xd0d0d050));
    textButtonStyle.font = skin.getFont("default");
    textButtonStyle.fontColor = Color.PINK;
    skin.add("default", textButtonStyle);

    return skin;
  }

  @Override
  public void render(float deltaTime) {
    Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//    if (Gdx.input.isTouched()) {
//      game.setScreen(new GameScreen(game));
//    }

    stage.act(deltaTime);
    stage.draw();
  }

  @Override
  public void resize(int width, int height) {
    stage.getViewport().update(width, height, true);
  }

  @Override
  public void show() {
    stage = new Stage(new StretchViewport(Reference.VIEWPORT_UI_WIDTH, Reference.VIEWPORT_UI_HEIGHT));
    Gdx.input.setInputProcessor(stage);
    rebuildStage();
  }

  @Override
  public void hide() {
    stage.dispose();
  }

  @Override
  public void pause() {

  }

}
