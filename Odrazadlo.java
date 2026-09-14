/**
 * Trieda vytvorí odrážadlo, od ktorého sa neskôr bude odrážat gulička.
 * 
 * @author Matúš Piroh 
 * @version 3.1.2026
 */
public class Odrazadlo {
    private Blok odrazadlo;
    // predstavuje momentánu vodorovnú súradnicu začiatku odrážadla
    private int x;
    private int sirka;
    // predstavuje momentálnu zvislú súradnicu začiatku odrážadla
    private int y;
    private int vyska;
    /**
     * Konštruktor vytvorí odrážadlo, ktoré posunieme na danú pozíciu.
     * @param sirka predstavuje šírku odrážadla
     * @param vyska predstavuje výšku odrážadla.
     */
    public Odrazadlo(int sirka, int vyska) {
        this.x = 345;
        this.sirka = sirka;
        this.y = 530;
        this.vyska = vyska;
        this.odrazadlo = new Blok(Farba.CIERNA, this.sirka, this.vyska);
        this.odrazadlo.posunVodorovne(295);
        this.odrazadlo.posunZvisle(510);
        this.odrazadlo.zobraz();
    }
    
    /**
     * Metóda vráti x-sovú súradnicu začiatku odrážadla (v ľavom hornom rohu).
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Metóda vráti šírku odrážadla.
     */
    public int getSirka() {
        return this.sirka;
    }
    
    /**
     * Metóda vráti y-novú súradnicu začiatku odrážadla.
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Metóda vráti výšku odrážadla.
     */
    public int getVyska() {
        return this.vyska;
    }
    
    /**
     * Metóda posunie vodorovne odrážadlo (doprava) o 10 a pripočíta k atribútu x hodnotu 10.
     */
    public void doprava() {
        this.odrazadlo.posunVodorovne(10);
        this.x += 10;
    }
    
    /**
     * Metóda posunie vodorovne odrážadlo (doľava) o 10 a odpočíta od atribútu x hodnotu 10.
     */
    public void dolava() {
        this.odrazadlo.posunVodorovne(-10);
        this.x -= 10;
    }
    
    /**
    * Metóda skryje všetky prvky typu Blok;
    */
    public void skry() {
        this.odrazadlo.skry();
    }
}
