package no.vestein.snake.lua;

import no.vestein.snake.world.WorldController;

/**
 * Created by Vestein Dahl
 * Date: 03.10.2016
 * Time: 20.42
 */
public interface Script {

  boolean canExecute();

  void executeInit(WorldController world);

  void executeKeyPressed(String key, WorldController world);

}
