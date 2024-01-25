package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

import AssetManager.AssetManager;
import Utils.Methods;
import Utils.Settings;

public class Asteroid extends Scrollable{

    private float runTime;

    //Getter del runTime
    public float getRunTime() {
        return runTime;
    }

    public Asteroid(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
        runTime = Methods.randomFloat(0,1);
    }

    public void reset(float newX){
        super.reset(newX);
        //Obtengo un número aleatorio entre MIN y MAX
        float newSize = Methods.randomFloat(Settings.MIN_ASTEROID, Settings.MAX_ASTEROID);
        //Mofificamos la altura y el ancho según el asteroide anterior
        width = height = 34 * newSize;
        //La posición será un valor aleatorio entre 0 y la altura de la aplicación menos la altura del asteroide
        position.y = new Random().nextInt(Settings.GAME_HEIGHT - (int) height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        runTime += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw((Texture) AssetManager.asteroidAnim.getKeyFrame(runTime), position.x, position.y, width, height);
    }
}
