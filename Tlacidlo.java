import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;
/**
 * Trieda umožňuje vytvárať tlačidlá, ktoré sa využívajú v triede Hra.
 * 
 * @author Matúš Piroh
 * @version 3.1.2026
 */
public class Tlacidlo {
    private static Farba farbaBloku = Farba.CIERNA;
    private int sirkaBloku;
    private int vyskaBloku;
    private int blokX;
    private int blokY;
    private Blok level;
    private BlokTextu text;
    /**
     * Podľa parametra sirkaBloku a vyskaBloku sa vytvorí blok, 
     * ktorý sa umiestni na súradnice z parametra blokX a blokY, pričom farba bloku bude vždy čierna.
     * Podľa nich sa vypočítá presné miesto, kde sa umiestni text načítaný z parametra text.
     * @param text načíta text na vypísanie.
     * @param blokX načíta x-sovú súradnicu miesta, kde sa má blok vykresliť.
     * @param blokY načíta y-novú súradnicu miesta, kde sa má blok vykresliť.
     * @param sirkaBloku načíta šírku bloku.
     * @param vyskaBloku načíta výšku bloku.
     */
    public Tlacidlo(String text, int blokX, int blokY, int sirkaBloku, int vyskaBloku) {
        this.sirkaBloku = sirkaBloku;
        this.vyskaBloku = vyskaBloku;
        this.blokX = blokX;
        this.blokY = blokY;
        this.level = new Blok(this.farbaBloku, this.sirkaBloku, this.vyskaBloku);
        this.level.zmenPolohu(blokX, blokY);
        this.level.zobraz();
        this.text = new BlokTextu(text, blokX + 1, blokY + 23);
        this.text.zmenFarbu("white");
        this.text.zmenFont("Calibri", StylFontu.BOLD, 25);
        this.text.zobraz();
    }
    
    /**
     * Metóda vráti hodnotu, na ktorej sa nachádza x-sová súradnica tlačidla. 
     */
    public int getBlokX() {
        return this.blokX;
    }
    
    /**
     * Metóda vráti hodnotu, na ktorej sa nachádza y-nová súradnica tlačidla. 
     */
    public int getBlokY() {
        return this.blokY;
    }
    
    /**
     * Metóda vráti výšku tlačidla.
     */
    public int getVyskaBloku() {
        return this.vyskaBloku;
    }
    
    /**
     * Metóda vráti šírku tlačidla.
     */
    public int getSirkaBloku() {
        return this.sirkaBloku;
    }
}
