package com.mygdx.game;
import AssetManager.AssetManager;
import Objects.Asteroid;
import Objects.ScrollHandler;
import Objects.Spacecraft;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

import Utils.Settings;

public class GameScreen2 implements Screen {

    private Stage stage;
    private Spacecraft spacecraft;
    private ScrollHandler scrollHandler;

    //Representación de figuras geométricas
    private ShapeRenderer shapeRenderer;
    //Para obtener el batch del stage (escenario)
    private Batch batch;


    public Stage getStage() {
        return stage;
    }

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }


    public GameScreen2(){
        //Creo el ShapeRenderer
        shapeRenderer = new ShapeRenderer();
        //Creo la cámara de las dimensiones del juego
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        //Poniendo el parámetro a true configuramos la cámara para que
        //haga servir el sistema de coordenadas Y-Down
        camera.setToOrtho(true);

        //Creamos el viewport con las mismas dimensiones que la cámara
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT, camera);

        //Creo el escenario y lo asigno al viewport
        stage = new Stage(viewport);

        batch = stage.getBatch();

        //Creo la nave y el resto de objetos
        spacecraft = new Spacecraft(Settings.SPACECRAFT_STARTX, Settings.SPACECRAFT_STARTY,Settings.SPACECRAFT_WIDTH, Settings.SPACECRAFT_HEIGHT);
        scrollHandler = new ScrollHandler();
        //Los añado al escenario
        stage.addActor(scrollHandler);
        stage.addActor(spacecraft);
        //Inicio la música
        AssetManager.music.play();
    }

    private void drawElements(){
        /* 1 */
        // Pintem el fons de negre per evitar el "flickering"
        //Gdx.gl20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        //Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /* 2 */
        // Recollim les propietats del Batch de l'Stage
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        // Inicialitzem el shaperenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        /* 3 */
        // Definim el color (verd)
        shapeRenderer.setColor(new Color(0, 1, 0, 1));
        // Pintem la nau
        shapeRenderer.rect(spacecraft.getX(), spacecraft.getY(), spacecraft.getWidth(), spacecraft.getHeight());

        /* 4 */
        // Recollim tots els Asteroid
        ArrayList<Asteroid> asteroids = scrollHandler.getAsteroids();
        Asteroid asteroid;

        for (int i = 0; i < asteroids.size(); i++) {

            asteroid = asteroids.get(i);
            switch (i) {
                case 0:
                    shapeRenderer.setColor(1,0,0,1);
                    break;
                case 1:
                    shapeRenderer.setColor(0,0,1,1);
                    break;
                case 2:
                    shapeRenderer.setColor(1,1,0,1);
                    break;
                default:
                    shapeRenderer.setColor(1,1,1,1);
                    break;
            }
            shapeRenderer.circle(asteroid.getX() + asteroid.getWidth()/2, asteroid.getY() + asteroid.getWidth()/2, asteroid.getWidth()/2);
        }
        /* 5 */
        shapeRenderer.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Fondo Rojo
        //Gdx.gl.glClearColor(1, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
        //Llamo al método para pintar los asteroides
        //drawElements();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
