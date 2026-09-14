
/**
 * Enum možností výberu farieb.
 * 
 * 
 * @author Matúš Piroh
 * @version 3.1.2026
 */
public enum Farba {
    MODRA("blue"),
    ZLTA("yellow"),
    ZELENA("green"),
    CERVENA("red"),
    RUZOVA("#FF69B4"),
    CIERNA("black"),
    BIELA("white");
    
    
    private String farbaKarty;
    
    /**
     * Konštruktor načíta farbaKarty každej inštancii.
     */
    Farba(String farbaKarty) {
        this.farbaKarty = farbaKarty;
    }
    
    /**
     * Metóda vráti farbu inštancie.
     */
    public String getFarbaKarty() {
        return this.farbaKarty;
    }
}
