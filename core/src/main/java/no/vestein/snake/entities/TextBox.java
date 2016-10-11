package no.vestein.snake.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import no.vestein.snake.eventhandler.SubToEvent;
import no.vestein.snake.eventhandler.events.KeyPressedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vestein Dahl
 * Date: 10.10.2016
 * Time: 19.03
 */
public class TextBox extends Entity {

  private Text text;
  private final int lines;
  private final int characters;

  public TextBox(final int lines, final int characters) {
    this.lines = lines;
    this.characters = characters;
    text = new Text(lines, characters);
  }

  @SubToEvent
  public void keyPressed(KeyPressedEvent keyPressedEvent) {
    Gdx.app.log("Textbox", Input.Keys.toString(keyPressedEvent.keyCode));
    String input = Input.Keys.toString(keyPressedEvent.keyCode);

    switch (input) {
      case "Delete":
        text.deleteCharacter();
        break;
      case "Space":
        text.addSpace();
        break;
      case "Up":
        text.prevLine();
        break;
      case "Enter":
      case "Down":
        text.nextLine();
        break;
      default:
        text.addCharacter(input);
        break;
    }
  }

  public Text getText() {
    return text;
  }

  public List<String> getTextAsList() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i<lines; i++) {
      list.add(text.getLine(i));
    }
    return list;
  }

  public class Text {

    private final int lines;
    private final int characters;

    private List<List<String>> text = new ArrayList<>();
    private int activeLine = 0;
    private int activePos = 0;

    Text(final int lines, final int characters) {
      this.lines = lines;
      this.characters = characters;
      for (int i=0; i<lines; i++) {
        text.add(new ArrayList<>());
      }
    }

    public List<String> getLineAsList(final int lineNumber) {
      return new ArrayList<>(text.get(lineNumber));
    }

    public String getLine(final int lineNumber) {
      String line = "";
      for (String s : text.get(lineNumber)) {
        line = line + s;
      }
      return line;
    }

    public int getActivePos() {
      return activePos;
    }

    public int getActiveLine() {
      return activeLine;
    }

    public void nextLine() {
      if (activeLine == lines-1) {
        return;
      }
      activeLine++;
      activePos = 0;
    }

    public void prevLine() {
      if (activeLine == 0) {
        return;
      }
      activeLine--;
      activePos = 0;
    }

    public void deleteCharacter() {
      List<String> line = text.get(activeLine);
      if (line.size() == 0) {
        prevLine();
        return;
      }
      line.remove(line.size() - 1);
      activePos--;
    }

    public void addSpace() {
      addCharacter(" ");
    }

    public void addCharacter(String newChar) {
      List<String> line = text.get(activeLine);
      if (line.size() == characters) {
        return;
      }
      line.add(newChar);
      activePos++;
    }

  }

}
