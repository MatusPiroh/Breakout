/**
 * Trieda vytvorí okraje plochy a plochu, na ktorej sa bude hrať.
 * 
 * @author Matúš Piroh 
 * @version 3.1.2026
 */
public class Oramovanie {
    private Blok okraj;
    private Blok vnutro;
    //predstavuje začiatok orámovania pre šírku (x)
    private int zaciatokX;
    private int sirka;
    //predstavuje začiatok orámovania pre výšku (y)
    private int zaciatokY;
    private int vyska;
    /**
     * Konštruktor vytvorí dva bloky,
     * blok okraj je väčší a reprezentuje orámovanie,
     * blok vnutro je o trochu menší a vďaka tomu zvýrazňuje miesta kde konči okraj,
     * bloky sa posunú tak, aby do seba zapadali a následne sa vykreslia tak, aby bol atribút vnutro navrchu. 
     */
    public Oramovanie() {
        this.zaciatokX = 165;
        this.sirka = 450;
        this.zaciatokY = 20;
        this.vyska = 550;
        this.okraj = new Blok(Farba.CIERNA, this.sirka, this.vyska);
        this.vnutro = new Blok(Farba.BIELA, this.sirka - 4, this.vyska - 4);
        this.okraj.posunVodorovne(this.zaciatokX - 50);
        this.vnutro.posunVodorovne(this.zaciatokX - 48);
        this.vnutro.posunZvisle(this.zaciatokY - 18);
        this.okraj.zobraz();
        this.vnutro.zobraz();
    }
    
    /**
     * Metóda vráti hodnotu atribútu zaciatokX, teda miesto, kde záčína ľavý okraj orámovania.
     */
    public int getZaciatokSirky() {
        return this.zaciatokX;
    }
    
    /**
     * Metóda vráti hodnotu, ktorá zistí kde konči pravý okraj orámovania.
     */
    public int getKoniecSirky() {
        return this.zaciatokX + this.sirka;
    }
    
    /**
     * Metóda vráti hodnotu atribútu zaciatokY, teda miesto, kde začína horný okraj orámovania.
     */
    public int getZaciatokVysky() {
        return this.zaciatokY;
    }
    
    /**
     * Metóda vráti hodnotu, ktorá zistí kde končí dolný okraj orámovania.
     */
    public int getKoniecVysky() {
        return this.zaciatokY + this.vyska;
    }
}
