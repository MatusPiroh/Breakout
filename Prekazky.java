
/**
 * Trieda vytvorý prekážky, do ktorých bude neskôr narážať gulička.
 * 
 * @author Matúš piroh
 * @version 6.12.2025
 */
public class Prekazky {
    private Blok[][] prekazky;
    private int pocetRiadkov;
    private int pocetStlpcov;
    /**
     * Konštruktor vytvorí pole a zavolá metódu na vytvorenie a vykreslenie prekážok.
     * @param pocetRiadkov predstavuje množstvo riadkov, ktoré bude mať pole.
     * @param pocetStlpcov predstavuje množstvo stĺpcov, ktoré bude mať pole.
     */
    public Prekazky(int pocetRiadkov, int pocetStlpcov) {
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        this.prekazky = new Blok[this.pocetRiadkov][this.pocetStlpcov];
        this.vytvorPrekazky();
        this.vykresliPrekazky();
    }
    
    /**
     * Metóda vráti počet riadkov poľa prekážok.
     */
    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }
    
    /**
     * Metóda vráti počet stĺpcov poľa prekážok.
     */
    public int getPocetStlpcov() {
        return this.pocetStlpcov;
    }
    
    /**
     * Metóda vráti počet prekážok(obsah obdĺžnika).
     */
    public int getPocetPrekazok() {
        return this.pocetRiadkov * this.pocetStlpcov;
    }
    
    /**
     * Metóda vráti farbu bloku podľa parametra riadok a parametra stlpec.
     * @param riadok predstavuje riadok v poli prekážok, v ktorom sa daný blok nachádza.
     * @param stlpec predstavuje stĺpec v poli prekážok, v ktorom sa daný blok nachádza.
     */
    public Farba getFarba(int riadok, int stlpec) {
        return this.prekazky[riadok][stlpec].getFarba();
    }
    
    /**
     * Metóda vráti blok podľa parametra riadok a parametra stlpec.
     * @param riadok redstavuje riadok v poli prekážok, v ktorom sa daný blok nachádza.
     * @param stlpec predstavuje stĺpec v poli prekážok, v ktorom sa daný blok nachádza.
     */
    public Blok getBlok(int riadok, int stlpec) {
        return this.prekazky[riadok][stlpec]; 
    }
       
    /**
     * Metóda vytvorí prekážky,
     * jednotlivé farby prekážok budú neskôr reprezentovať čo sa po zničení daného bloku stane.
     * Podmienku som využíval na vytvorenie blokov, ktoré budú mať neskôr špeciálne vlastnosti.
     */
    private void vytvorPrekazky() {
        for (int riadok = 0; riadok < this.pocetRiadkov; riadok++) {
            for (int stlpec = 0; stlpec < this.pocetStlpcov; stlpec++) {
                if (riadok == 1 && stlpec == 1 || riadok == 2 && stlpec == 4) {
                    this.prekazky[riadok][stlpec] = new Blok(Farba.ZLTA, 50, 30);
                } else if (riadok == 1 && stlpec == 2 || riadok == 2 && stlpec == 3) {
                    this.prekazky[riadok][stlpec] = new Blok(Farba.CERVENA, 50, 30);
                } else if (riadok == 1 && stlpec == 3 || riadok == 2 && stlpec == 2) {
                    this.prekazky[riadok][stlpec] = new Blok(Farba.RUZOVA, 50, 30);
                } else if (riadok == 1 && stlpec == 4 || riadok == 2 && stlpec == 1) {
                    this.prekazky[riadok][stlpec] = new Blok(Farba.ZELENA, 50, 30);
                } else {
                    this.prekazky[riadok][stlpec] = new Blok(Farba.MODRA, 50, 30);
                }
            }
        }
    }
    
    /**
     * Metóda vykreslí prekážky,
     * lokálna premenná zabezpečí, že sa všetky prekážky budú vykreslovať až od požadovaných súradníc.
     */
    public void vykresliPrekazky() {
        for (int riadok = 0; riadok < this.pocetRiadkov; riadok++) {
            for (int stlpec = 0; stlpec < this.pocetStlpcov; stlpec++) {
                Blok pomocna = this.prekazky[riadok][stlpec];
                pomocna.posunVodorovne(122 + (55 * (stlpec + 1)));
                pomocna.posunZvisle(30 + (35 * riadok));
                pomocna.zobraz();
            }
        }
    }
    
    /**
     * Metóda skryje všetky prekážky.
     */
    public void skry() {
        for (Blok[] riadok : this.prekazky) {
            for (Blok policka : riadok) {
                policka.skry();
            }
        }
    }
}
