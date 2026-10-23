/**
 * Enum definujúci jednotlivé levely a ich vlastnosti.
 *
 * @author Matúš Piroh
 * @version 23.10.2026
 */
public enum Level {
    /** Prvý level hry. */
    LEVEL1("Level1", 90, 1, 260, 410, Smer.DOLE_VPRAVO, 4, 6),
    /** Druhý level hry. */
    LEVEL2("Level2", 60, 2, 180, 380, Smer.DOLE_VPRAVO, 5, 6),
    /** Tretí level hry. */
    LEVEL3("Level3", 40, 3, 300, 410, Smer.HORE_VPRAVO, 6, 6);

    /** Názov levelu. */
    private String nazov;
    /** Veľkosť odrážadla v leveli. */
    private int velkostOdrazadla;
    /** Rýchlosť guličky v leveli. */
    private int rychlostGulicky;
    /** Počiatočná X súradnica guličky. */
    private int xGulicky;
    /** Počiatočná Y súradnica guličky. */
    private int yGulicky;
    /** Počiatočný smer guličky. */
    private Smer smerGulicky;
    /** Počet riadkov prekážok. */
    private int pocetRiadkov;
    /** Počet stĺpcov prekážok. */
    private int pocetStlpcov;

    /**
     * Konštruktor inicializuje hodnoty, ktoré budú definovať level.
     * @param nazov načíta názov levelu.
     * @param velkostOdrazadla načíta dĺžku odrážadla.
     * @param rychlostGulicky ovplyvňuje zrýchľovanie alebo spomaľovanie guličky.
     * @param xGulicky načíta miesto, kde na x súradnici sa má gulička zobraziť.
     * @param yGulicky načíta miesto, kde na y súradnici sa má gulička zobraziť.
     * @param smerGulicky načíta smer, ktorým sa gulička po vytvorení hry bude pohybovať.
     * @param pocetRiadkov načíta, koľko riadkov má pole prekážok obsahovať.
     * @param pocetStlpcov načíta, koľko stĺpcov má pole prekážok obsahovať.
     */
    Level(String nazov, int velkostOdrazadla, int rychlostGulicky, int xGulicky, int yGulicky, Smer smerGulicky, int pocetRiadkov, int pocetStlpcov) {
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
     * @return názov levelu
     */
    public String getNazov() {
        return this.nazov;
    }

    /**
     * Metóda vráti veľkosť odrážadla.
     * @return veľkosť odrážadla
     */
    public int getVelkostOdrazadla() {
        return this.velkostOdrazadla;
    }

    /**
     * Metóda vráti rýchlosť guličky.
     * @return rýchlosť guličky
     */
    public int getRychlostGulicky() {
        return this.rychlostGulicky;
    }

    /**
     * Metóda vráti x-sovú súradnicu guličky.
     * @return X súradnica
     */
    public int getXGulicky() {
        return this.xGulicky;
    }

    /**
     * Metóda vráti y-novú súradnicu guličky.
     * @return Y súradnica
     */
    public int getYGulicky() {
        return this.yGulicky;
    }

    /**
     * Metóda vráti smer guličky.
     * @return smer guličky
     */
    public Smer getSmerGulicky() {
        return this.smerGulicky;
    }

    /**
     * Metóda vráti počet riadkov, ktoré bude mať pole prekážok.
     * @return počet riadkov
     */
    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }

    /**
     * Metóda vráti počet stĺpcov, ktoré bude mať pole prekážok.
     * @return počet stĺpcov
     */
    public int getPocetStlpcov() {
        return this.pocetStlpcov;
    }
}