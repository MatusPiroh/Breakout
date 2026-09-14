/**
 * Trieda definuje základné vlastnosti, teda v čom sa budú levely odlišovať.
 * 
 * @author Matúš Piroh 
 * @version 19.12.2025
 */
public class Level {
    private String nazov;
    private int velkostOdrazadla;
    private int rychlostGulicky;
    private int xGulicky;
    private int yGulicky;
    private Smer smerGulicky;
    private int pocetRiadkov;
    private int pocetStlpcov;
    
    /**
     * Konštruktor inicializuje hondoty, ktoré budú definovať level.
     * @param nazov načíta názov levelu.
     * @param velkostOdrazadla načíta dĺžku odrážadla.
     * @param rychlostGulicky ovplyvňuje zrýchľovanie alebo spomaľovanie guličky.
     * @param xGulicky načíta miesto, kde na x súradnici sa má gulicka zobraziť.
     * @param yGulicky načíta miesto, kde na y súradnici sa má gulicka zobraziť.
     * @param smerGulicky načíta smer, ktorým sa gulička po vytvorení hry bude pohybovať.
     * @param pocetRiadkov načíta, koľko riadkov má pole prekážok obsahovať.
     * @param pocetStlpcov načíta, koľko stĺpcov má pole prekážok obsahovať.
     */
    public Level(String nazov, int velkostOdrazadla, int rychlostGulicky, int xGulicky, int yGulicky, Smer smerGulicky, int pocetRiadkov, int pocetStlpcov) {
        this.nazov = nazov;
        this.velkostOdrazadla = velkostOdrazadla;
        this.rychlostGulicky = rychlostGulicky;
        this.xGulicky = xGulicky;
        this.yGulicky = yGulicky;
        this.smerGulicky = smerGulicky;
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
    }
    
    /**
     * Metóda vráti názov levelu.
     */
    public String getNazov() {
        return this.nazov;
    }
    
    /**
     * Metóda vráti veľkosť odrážadla.
     */
    public int getVelkostOdrazadla() {
        return this.velkostOdrazadla;
    }
    
    /**
     * Metóda vráti rýchlosť guličky.
     */
    public int getRychlostGulicky() {
        return this.rychlostGulicky;
    }
    
    /**
     * Metóda vráti x-sovú súradnicu guličky.
     */
    public int getXGulicky() {
        return this.xGulicky;
    }
    
    /**
     * Metóda vráti y-novú súradnicu guličky.
     */
    public int getYGulicky() {
        return this.yGulicky;
    }
    
    /**
     * Metóda vráti smer guličky.
     */
    public Smer getSmerGulicky() {
        return this.smerGulicky;
    }
    
    /**
     * Metóda vráti počet riadkov, ktoré bude mať pole prekážok.
     */
    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }
    
    /**
     * Metóda vráti počet stĺpcov, ktoré bude mať pole prekážok.
     */
    public int getPocetStlpcov() {
        return this.pocetStlpcov;
    }
}
