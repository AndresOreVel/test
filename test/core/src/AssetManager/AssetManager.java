package AssetManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {
    //Sonidos
    public static Sound explosionSound;
    public static Music music;

    //                     GRÁFICOS
    //Hojas del sprite
    public static Texture sheet;
    //Nave y fondo
    public static TextureRegion spacecraft, spacecraftDown, spacecraftUp, background;
    //Asteroide
    public static TextureRegion[] asteroid;
    public static Animation asteroidAnim;
    //Explosión
    public static TextureRegion[] explosion;
    public static Animation explosionAnim;

    public static void load(){
        // Cargamos las texturas y las aplicamos al método de escalado 'nearest'
        sheet = new Texture(Gdx.files.internal("sheet.png"));
        sheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        //Sprites de la nave
        spacecraft = new TextureRegion(sheet,0,0,36,15);
        spacecraft.flip(false,true);

        spacecraftUp = new TextureRegion(sheet, 36,0,36,15);
        spacecraftUp.flip(false,true);

        spacecraftDown = new TextureRegion(sheet,72,0,36,15);
        spacecraftDown.flip(false,true);

        //Cargamos los 16 estados del asteroide
        asteroid = new TextureRegion[16];
        for(int i = 0; i < asteroid.length; i++){
            asteroid[i] = new TextureRegion(sheet,i * 34, 15, 34, 34);
            asteroid[i].flip(false, true);
        }

        //Creamos la animación del asteroide y hacemos que se ejecute continuamente en sentido antihorario
        asteroidAnim = new Animation(0.05f,asteroid);
        asteroidAnim.setPlayMode(Animation.PlayMode.LOOP_REVERSED);

        //Creamos los 16 estados de la explosión
        explosion = new TextureRegion[16];
        //Cargamos los 16 estados de la explosión
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                explosion[index++] = new TextureRegion(sheet, j * 64, i * 64 + 49, 64, 64);
                explosion[index - 1].flip(false, true);
            }
        }

        explosionAnim = new Animation(0.04f, explosion);
        explosionAnim.setPlayMode(Animation.PlayMode.NORMAL);

        //Fondo de pantalla
        background = new TextureRegion(sheet, 0, 177, 480, 135);
        background.flip(false,true);

        ///*******SONIDOS******
        //Explosión
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));

        //Música del juego
        music = Gdx.audio.newMusic(Gdx.files.internal("Afterburner.ogg"));
        music.setVolume(0.2f);
        music.setLooping(true);
    }

    public static void dispose(){
        //Descartamos los recursos
        sheet.dispose();
        explosionSound.dispose();
        music.dispose();
    }
}
