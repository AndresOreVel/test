package Objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import Utils.Settings;

public class Spacecraft extends Actor {
    //Diferentes posiciones de la nave: línea recta, arriba, abajo
    public static final int SPACECRAFT_STRAIGHT = 0;
    public static final int SPACECRAFT_UP = 1;
    public static final int SPACECRAFT_DOWN = 2;

    //Parámetros de la nave
    private Vector2 position;
    private int width, height;
    private int direction;

    //CONSTRUCTOR
    public Spacecraft(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x,y);

        //Inicializo la nave al estado normal o en línea recta
        direction = SPACECRAFT_STRAIGHT;
    }

    public void act (float delta){
        // Muevo la nave dependiendo de la dirección controlando que no salga de la pantalla
        switch (direction) {
            case SPACECRAFT_UP:
                if (this.position.y - Settings.SPACECRAFT_VELOCITY * delta >= 0) {
                    this.position.y -= Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
            case SPACECRAFT_DOWN:
                if (this.position.y + height + Settings.SPACECRAFT_VELOCITY * delta <= Settings.GAME_HEIGHT) {
                    this.position.y += Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
            case SPACECRAFT_STRAIGHT:
                break;
        }
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    //?????
    public Vector2 getPosition() {
        return position;
    }

    //GETTERS
    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    //??????
    public int getDirection() {
        return direction;
    }


    //Método para subir
    public void goUp(){
        direction = SPACECRAFT_UP;
    }
    public void goDown(){
        direction = SPACECRAFT_DOWN;
    }
    public void goStraight(){
        direction = SPACECRAFT_STRAIGHT;
    }


}
