/**
 * Enum smerov, ktoré môže gulička mať.
 * 
 * @author Matúš Piroh
 * @version 6.12.2025
 */
public enum Smer {
    DOLE_VPRAVO (1, 1),
    DOLE_VLAVO (-1, 1),
    HORE_VPRAVO (1, -1),
    HORE_VLAVO (-1, -1),
    ZIADNY (0, 0);
    
    private int vektorX;
    private int vektorY;
    
    /**
     * Konštruktor načíta vektorX a vektorY každej inštancii.
     */
    Smer(int vektorX, int vektorY) {
        this.vektorX = vektorX;
        this.vektorY = vektorY;
    }
    
    /**
     * Metóda vráti vektorX.
     */
    public int getVektorX() {
        return this.vektorX;
    }
    
    /**
     * Metóda vráti vektorY.
     */
    public int getVektorY() {
        return this.vektorY;
    }
}
