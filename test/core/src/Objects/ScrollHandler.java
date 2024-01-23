package Objects;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

import Utils.Methods;
import Utils.Settings;

public class ScrollHandler extends Group {
    //Fondo de pantalla
    Background bg, bg_back;

    //Asteroides
    int numAsteroids;
    ArrayList<Asteroid> asteroids;

    //Objeto random
    Random r;

    public ScrollHandler(){
        //Creo los dos fondos que se irán concatenando para dar la sensación de fondo infinito
        bg = new Background(0,0, Settings.GAME_WIDTH * 2, Settings.SPACECRAFT_HEIGHT, Settings.BG_SPEED);
        bg_back = new Background(bg.getTailX(),0,Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);

        //Añado los fondos (actores) al grupo
        addActor(bg);
        addActor(bg_back);

        //Creo el objeto random
        r = new Random();

        //Comenzamos con 3 asteroides
        numAsteroids = 3;

        //Creo el ArrayList
        asteroids = new ArrayList<Asteroid>();

        //Defino una medida aleatoria entre el mínimo y el máximo
        float newSize = Methods.randomFloat(Settings.MIN_ASTEROID, Settings.MAX_ASTEROID) * 34;

        //Añado el primer asteroide al array y al grupo
        Asteroid asteroid = new Asteroid(Settings.GAME_WIDTH, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Settings.ASTEROID_SPEED);
        asteroids.add(asteroid);
        addActor(asteroid);

        //Desde el segundo hasta el último asteroide
        for (int i = 1; i < numAsteroids; i++) {
            // Creamos la medida aleatoria
            newSize = Methods.randomFloat(Settings.MIN_ASTEROID, Settings.MAX_ASTEROID) * 34;
            // Añadimos el asteroide
            asteroid = new Asteroid(asteroids.get(asteroids.size() - 1).getTailX() + Settings.ASTEROID_GAP, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Settings.ASTEROID_SPEED);
            // Añadimos el asteroide al ArrayList
            asteroids.add(asteroid);
            // Añadimos el asteroide al grup de actores
            addActor(asteroid);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // Si algún elemento se encuentra fuera de la pantalla, hacemos un reset del elemento
        if (bg.isLeftOfScreen()) {
            bg.reset(bg_back.getTailX());

        } else if (bg_back.isLeftOfScreen()) {
            bg_back.reset(bg.getTailX());

        }

        for (int i = 0; i < asteroids.size(); i++) {

            Asteroid asteroid = asteroids.get(i);
            if (asteroid.isLeftOfScreen()) {
                if (i == 0) {
                    asteroid.reset(asteroids.get(asteroids.size() - 1).getTailX() + Settings.ASTEROID_GAP);
                } else {
                    asteroid.reset(asteroids.get(i - 1).getTailX() + Settings.ASTEROID_GAP);
                }
            }
        }
    }

    public ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }
}
