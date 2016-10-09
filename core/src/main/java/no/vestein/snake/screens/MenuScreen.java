package no.vestein.snake.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import no.vestein.snake.Reference;
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

    stage.clear();
    Stack stack = new Stack();
    stage.addActor(stack);
    stack.setSize(Reference.VIEWPORT_UI_WIDTH, Reference.VIEWPORT_UI_HEIGHT);
    stack.add(layerLogos);

  }

  private Table buildLogosLayer() {
    Table layer = new Table();
    btnPlay = new TextButton("Start", createBasicSkin());
    btnPlay.setPosition(200, 200);
    layer.addActor(btnPlay);
    return layer;
  }

  private Skin createBasicSkin() {
    BitmapFont font = new BitmapFont(Gdx.files.internal("sourcecode.fnt"));
    Skin skin = new Skin();
    skin.add("default", font);

    Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
    pixmap.setColor(Color.WHITE);
    pixmap.fill();
    skin.add("background", new Texture(pixmap));

    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
    textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
    textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
    textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
    textButtonStyle.font = skin.getFont("default");
    skin.add("default", textButtonStyle);

    return skin;
  }

  @Override
  public void render(float deltaTime) {
    Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    if (Gdx.input.isTouched()) {
      game.setScreen(new GameScreen(game));
    }

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
