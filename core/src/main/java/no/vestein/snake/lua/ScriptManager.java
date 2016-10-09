package no.vestein.snake.lua;

import com.badlogic.gdx.Gdx;
import no.vestein.snake.Snake;
import no.vestein.snake.eventhandler.SubToEvent;
import no.vestein.snake.eventhandler.events.Event;
import no.vestein.snake.screens.GameScreen;
import no.vestein.snake.world.WorldController;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Created by Vestein Dahl
 * Date: 03.10.2016
 * Time: 20.42
 */
public class ScriptManager implements Script {

  private Globals globals = JsePlatform.standardGlobals();
  private LuaValue chunk;
  private boolean scriptExists;

  public ScriptManager(final String scriptFilename) {
    scriptExists = Gdx.files.internal(scriptFilename).exists();
    if (!scriptExists) {
      return;
    }
    chunk = globals.loadfile(scriptFilename);
    chunk.call();

    GameScreen.EVENT_BUS.register(this);
  }

  @SubToEvent
  public void onSpriteMoved(Event event) {
    //todo implement method
  }

  @Override
  public boolean canExecute() {
    return scriptExists;
  }

  @Override
  public void executeInit(WorldController world) {
    if (canExecute()) {
      globals.get("init").invoke(new LuaValue[] {CoerceJavaToLua.coerce(world)});
    }
  }

  @Override
  public void executeKeyPressed(String key, WorldController world) {
    if (canExecute()) {
      globals.get("keyPressed").invoke(new LuaValue[] {
              CoerceJavaToLua.coerce(key),
              CoerceJavaToLua.coerce(world)
      });
    }
  }
}
