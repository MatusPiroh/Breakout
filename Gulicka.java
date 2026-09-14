import fri.shapesge.Kruh;

/**
 * Trieda vytvorí guličku, s ktorou bude pracovať trieda Hra.
 * 
 * @author Matúš Piroh 
 * @version 6.12.2025
 */
public class Gulicka {
    private Kruh gulicka;
    // aktuálna vodorovná súradnica x
    private int x;
    // aktuálna zvislá súradnica y
    private int y;
    private int priemer;
    /**
     * Konštruktor vytvorí guličku o veľkosti, ktorú načíta z parametra priemer.
     * Guličke sa zmení veľkosť, farba, poloha a na konci sa zobrazí.  
     * @param priemer predstavuje priemer guličky.
     * @param x predstavuje kam na x-sovú súradnicu sa má gulička presunúť. 
     * @param y predstavuje kam na y-novú súradnicu sa má gulička presunúť. 
     */
    public Gulicka(int priemer, int x, int y) {
        this.priemer = priemer;
        this.gulicka = new Kruh();
        this.gulicka.zmenFarbu("#FF6600");
        this.gulicka.zmenPriemer(this.priemer);
        this.x = x;
        this.y = y;
        this.gulicka.zmenPolohu(this.x, this.y); 
        this.gulicka.zobraz();
    }
    
    /**
     * Metóda vráti priemer guličky.
     */
    public int getPriemer() {
        return this.priemer;
    }
    
    /**
     * Metóda vráti vodorovnú súradnicu guličky.
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Metóda vráti zvislú súradnicu guličky.
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Metóda vráti posunutú polohu guličky,
     * k atribútom x a y sa pripočíta parameter smer,
     * gulička sa posunie na nové súradnice.
     * @param smer načíta do akého smeru sa má gulička posunúť.
     */
    public Kruh getPosunutaPoloha(Smer smer) {
        this.x += smer.getVektorX();
        this.y += smer.getVektorY();
        this.gulicka.zmenPolohu(this.x, this.y);
        return this.gulicka;
    }
    
    /**
     * Metóda zväčší priemer guličky o 5.
     */
    public void zvacsi() {
        this.priemer += 5;
        this.gulicka.zmenPriemer(this.priemer);
    }
    
    /**
     * Metóda zmenší priemer guličky o 5.
     */
    public void zmensi() {
        this.priemer -= 5;
        this.gulicka.zmenPriemer(this.priemer);
    }
    
    /**
    * Metóda skryje guličku.
    */
    public void skry() {
        this.gulicka.skry();
    }
}

