import fri.shapesge.Obdlznik;

/**
 * Trieda vytvára šablónu pre bloky, ktoré využívajú iné triedy.
 * 
 * @author Matúš Piroh
 * @version 3.1.2026
 */
public class Blok {
    private Farba farba;
    private Obdlznik blok;
    private int sirka;
    private int vyska;
    private boolean zobrazeny;
    
    /**
     * Konštruktor vytvorí nový blok, ktorý bude vyzerať ako obdĺžnik.
     * @param farba sa uloží do atribútu farba a bude predstavovať farbu obdĺžnika.
     * @param sirka predstavuje šírku obdĺžnika.
     * @param vyska predstavuje výšku obdĺžnika.
     */
    public Blok(Farba farba, int sirka, int vyska) {
        this.farba = farba;
        this.sirka = sirka;
        this.vyska = vyska;
        this.zobrazeny = false;
        this.blok = new Obdlznik();
        this.blok.zmenStrany(sirka, vyska);
        this.blok.zmenPolohu(50, 20);
        this.blok.zmenFarbu(farba.getFarbaKarty());
    }
    
    /**
     * Metóda vráti farbu bloku.
     */
    public Farba getFarba() {
        return this.farba;
    }
    
    /**
     * Metóda vráti šírku bloku.
     */
    public int getSirka() {
        return this.sirka;
    }
    
    /**
     * Metóda vráti výšku bloku.
     */
    public int getVyska() {
        return this.vyska;
    }
    
    /**
     * Metóda vráti hodnotu, ktorá povie či blok je alebo nie je zobrazeny.
     */
    public boolean jeZobrazeny() {
        return this.zobrazeny;
    }
    
    /**
     * Metóda zobrazí blok.
     */
    public void zobraz() {
        this.blok.zobraz();
        this.zobrazeny = true;
    }
    
    /**
     * Metóda skryje blok.
     */
    public void skry() {
        this.blok.skry();
        this.zobrazeny = false;
    }
    
    /**
     * Metóda posunie vodorovne blok o načítanú vzdialenosť z parametra.
     * @param oKolko zisťuje o akú vzdialenosť chceme posunúť blok.
     */
    public void posunVodorovne(int oKolko) {
        this.blok.posunVodorovne(oKolko);
    }
    
    /**
     * Metóda posunie zvisle blok o načítanú vzdialenosť z parametra.
     * @param oKolko zisťuje o akú vzdialenosť chceme posunúť blok.
     */
    public void posunZvisle(int oKolko) {
        this.blok.posunZvisle(oKolko);
    }
    
    /**
     * Metóda presunie blok na súradnice.
     * @param x predstavuje x-sovú súradnicu, kde sa má blok presunúť.
     * @param y predstavuje y-novú súradnicu, kde sa má blok presunúť.
     */
    public void zmenPolohu(int x, int y) {
        this.blok.zmenPolohu(x, y);
    }
}
