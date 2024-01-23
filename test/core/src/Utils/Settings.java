package Utils;

public class Settings {
    // Rango de valores para cambiar la medida del asteroide
    public static final float MAX_ASTEROID = 1.5f;
    public static final float MIN_ASTEROID = 0.5f;

    // Configuración para el scrollable
    public static final int ASTEROID_SPEED = -150;
    public static final int ASTEROID_GAP = 75;
    public static final int BG_SPEED = -100;

    // Mida del juego, se escalará según las necesidades del usuario
    public static final int GAME_WIDTH = 240; //Ancho de la pantalla
    public static final int GAME_HEIGHT = 135; //Alto de la pantalla

    // Propiedades de la nave
    public static final float SPACECRAFT_VELOCITY = 50; //Velocidad
    public static final int SPACECRAFT_WIDTH = 36; //Ancho de la nave
    public static final int SPACECRAFT_HEIGHT = 15; //Altura de la nave
    //Posiciones en la que empieza la nave inicialmente
    public static final float SPACECRAFT_STARTX = 20;
    public static final float SPACECRAFT_STARTY = GAME_HEIGHT/2 - SPACECRAFT_HEIGHT/2;
}
