package no.vestein.snake;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Vestein on 12.03.2016.
 */
public class CameraHelper implements Updatable {

  private static final String TAG = CameraHelper.class.getName();

  private final float MAX_ZOOM_IN = 0.25f;
  private final float MAX_ZOOM_OUT = 10.0f;

  private Vector2 position;
  private float zoom;
  private Sprite target;

  public CameraHelper() {
    position = new Vector2();
    zoom = 1.0f;
  }

  public void update(float deltaTime) {
    if (!hastarget()) {
      return;
    }

    position.x = target.getX() + target.getOriginX();
    position.y = target.getY() + target.getOriginY();
  }

  public void setPosition(final float x, final float y) {
    this.position.set(x, y);
  }

  public Vector2 getPosition() {
    return position;
  }

  public void addZoom(final float amount) {
    setZoom(zoom + amount);
  }

  public void setZoom(final float zoom) {
    this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT);
  }

  public float getZoom() {
    return zoom;
  }

  public void setTarget(Sprite target) {
    this.target = target;
  }

  public Sprite getTarget() {
    return target;
  }

  public boolean hastarget() {
    return target != null;
  }

  public boolean hastarget(Sprite target) {
    return hastarget() && this.target.equals(target);
  }

  public void applyTo(OrthographicCamera camera) {
    camera.position.x = position.x;
    camera.position.y = position.y;
    camera.zoom = zoom;
    camera.update();
  }

}
