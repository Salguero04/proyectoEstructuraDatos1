package ordenamientoPokedex;

import javax.swing.ImageIcon;

public class Pokemon {
    private int id;
    private String nombre;
    private String spriteUrl;
    private ImageIcon sprite; // se cargará después

    public Pokemon(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // Sprite estilo GBA (frontal, de los juegos de tercera generación)
        this.spriteUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/" + id + ".png";
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getSpriteUrl() { return spriteUrl; }
    public ImageIcon getSprite() { return sprite; }
    public void setSprite(ImageIcon sprite) { this.sprite = sprite; }

    @Override
    public String toString() {
        return "#" + id + " " + nombre;
    }
}