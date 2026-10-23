import fri.shapesge.Manazer;
import fri.shapesge.BlokTextu;
import java.util.ArrayList;

/**
 * Trieda Hra spája jednotlivé triedy a vytvára logiku na hranie.
 *
 * @author Matúš Piroh
 * @version 5.1.2026
 */
public class Hra {

    private Odrazadlo odrazadlo;
    private Manazer manazer;
    private Oramovanie oramovanie;
    private Prekazky prekazky;
    private Gulicka gulicka;
    private Smer smer;
    private int zrychliTik;
    private int skryte;
    private Sipky sipka;
    private Level level;
    private ArrayList<Tlacidlo> tlacidla;
    private BlokTextu text;
    private int lenRaz;

    /**
     * Koštruktor na začiatku zapne prvý level, vytvorí orámovanie, tlačidlá a zavolá metódu,
     * ktorá vytvorí hráčsku plochu a dá manažérovi spravovať daný objekt.
     */
    public Hra() {
        this.level = Level.LEVEL1;
        this.oramovanie = new Oramovanie();
        this.tlacidla = new ArrayList<Tlacidlo>();
        this.tlacidla.add(new Tlacidlo("Level1", 50, 50, 71, 30));
        this.tlacidla.add(new Tlacidlo("Level2", 50, 100, 71, 30));
        this.tlacidla.add(new Tlacidlo("Level3", 50, 150, 71, 30));
        this.tlacidla.add(new Tlacidlo("Koniec", 50, 200, 71, 30));
        this.vytvorPlochu();
        this.text = new BlokTextu("", 0, 0);
        this.lenRaz = 0;
        this.manazer.spravujObjekt(this);
    }

    /**
     * Metóda zisťuje, nastavuje a vráti hodnotu smeru guličky.
     * Popisuje čo má robiť ak sa gulička odrazí od odrážadla, orámovania
     * alebo ak sa chytí spodnej časti orámovania(hra skončí).
     */
    public Smer getSmerOkolie() {
        // Odraz pre odrážádlo.
        if (this.gulicka.getX() > this.odrazadlo.getX() - this.gulicka.getPriemer()
            && this.gulicka.getX() < this.odrazadlo.getX() + this.odrazadlo.getSirka()
            && this.gulicka.getY() == this.odrazadlo.getY() - this.gulicka.getPriemer()) {
            if (this.sipka == Sipky.VPRAVO) {
                this.smer = Smer.HORE_VPRAVO;
                this.sipka = Sipky.ZIADNA;
            } else if (this.sipka == Sipky.VLAVO) {
                this.smer = Smer.HORE_VLAVO;
                this.sipka = Sipky.ZIADNA;
            } else {
                if (this.smer == Smer.DOLE_VPRAVO) {
                    this.smer = Smer.HORE_VPRAVO;
                } else {
                    this.smer = Smer.HORE_VLAVO;
                }
            }
        }

        // Pokial sa gulička dotkne spodného okraju, tak už sa viac neodrazí a znamená to, že hráč prehral.
        if (this.gulicka.getY() == this.oramovanie.getKoniecVysky() - this.gulicka.getPriemer()) {
            if (this.lenRaz == 0) {
                this.smer = Smer.ZIADNY;
                BlokTextu pomocna = new BlokTextu("Prehral si", 365, 350);
                pomocna.zmenFarbu("black");
                this.text = pomocna;
                this.text.zobraz();
                this.lenRaz = 1;
            }
        }

        // Táto časť hovorí o tom, čo má robiť gulička ak sa dotkne hornej časti orámovania.
        if (this.gulicka.getY() == this.oramovanie.getZaciatokVysky()) {
            if (this.smer == Smer.HORE_VPRAVO) {
                this.smer = Smer.DOLE_VPRAVO;
            } else {
                this.smer = Smer.DOLE_VLAVO;
            }
        }

        // Táto časť hovorí o tom, čo má robiť gulička ak sa dotkne pravej časti orámovania.
        if (this.gulicka.getX() == this.oramovanie.getKoniecSirky() - this.gulicka.getPriemer()) {
            if (this.smer == Smer.HORE_VPRAVO) {
                this.smer = Smer.HORE_VLAVO;
            } else {
                this.smer = Smer.DOLE_VLAVO;
            }
        }

        // Táto časť hovorí o tom, čo má robiť gulička ak sa dotkne ľavej časti orámovania.
        if (this.gulicka.getX() == this.oramovanie.getZaciatokSirky()) {
            if (this.smer == Smer.HORE_VLAVO) {
                this.smer = Smer.HORE_VPRAVO;
            } else {
                this.smer = Smer.DOLE_VPRAVO;
            }
        }

        // Po skontrolovaní všetkých podmienok vráti smer.
        return this.smer;
    }

    /**
     * Metóda zisťuje či sa súradnice guličky zhodujú s nejakým zobrazeným blokom v prekážkach,
     * ak áno, tak zavolá metódu na skrytie guličky a vráti správny smer, do ktorého sa má gulička odraziť.
     */
    public Smer getDotknutaPrekazka() {
        for (int riadok = 0; riadok < this.prekazky.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < this.prekazky.getPocetStlpcov(); stlpec++) {
                if (this.prekazky.getBlok(riadok, stlpec).jeZobrazeny()) {
                    // ak gulička narazí zhora
                    if (this.gulicka.getY() == (30 + (35 * riadok))
                        && this.gulicka.getX() >= (122 + (55 * (stlpec + 1)) + this.prekazky.getBlok(riadok, stlpec).getSirka())
                        && this.gulicka.getX() <= (122 + (55 * (stlpec + 1))) + (2 * this.prekazky.getBlok(riadok, stlpec).getSirka())) {
                        if (this.smer == Smer.DOLE_VPRAVO) {
                            this.smer = Smer.HORE_VPRAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        } else {
                            this.smer = Smer.HORE_VLAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        }
                    // ak gulička narazí zľava
                    } else if (this.gulicka.getX() == 122 + (55 * (stlpec + 1)) + this.prekazky.getBlok(riadok, stlpec).getSirka() - this.gulicka.getPriemer()
                        && this.gulicka.getY() >= (30 + (35 * riadok)) + this.prekazky.getBlok(riadok, stlpec).getVyska()
                        && this.gulicka.getY() <= (30 + (35 * riadok)) + (2 * this.prekazky.getBlok(riadok, stlpec).getVyska())) {
                        if (this.smer == Smer.HORE_VPRAVO) {
                            this.smer = Smer.HORE_VLAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        } else {
                            this.smer = Smer.DOLE_VLAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        }
                    // ak gulička narazí sprava
                    } else if (this.gulicka.getX() == (122 + (55 * (stlpec + 1))) + (2 * this.prekazky.getBlok(riadok, stlpec).getSirka())
                        && this.gulicka.getY() >= (30 + (35 * riadok)) + this.prekazky.getBlok(riadok, stlpec).getVyska()
                        && this.gulicka.getY() <= (30 + (35 * riadok)) + (2 * this.prekazky.getBlok(riadok, stlpec).getVyska())) {
                        if (this.smer == Smer.HORE_VLAVO) {
                            this.smer = Smer.HORE_VPRAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        } else {
                            this.smer = Smer.DOLE_VPRAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        }
                    // ak gulička narazí zdola
                    } else if (this.gulicka.getX() > 122 + (55 * (stlpec + 1)) + this.prekazky.getBlok(riadok, stlpec).getSirka()
                        && this.gulicka.getX() < (122 + (55 * (stlpec + 1))) + (2 * this.prekazky.getBlok(riadok, stlpec).getSirka())
                        && this.gulicka.getY() > (30 + (35 * riadok)) + this.prekazky.getBlok(riadok, stlpec).getVyska()
                        && this.gulicka.getY() < (30 + (35 * riadok)) + (2 * this.prekazky.getBlok(riadok, stlpec).getVyska())) {
                        if (this.smer == Smer.HORE_VPRAVO) {
                            this.smer = Smer.DOLE_VPRAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        } else if (this.smer == Smer.HORE_VLAVO) {
                            this.smer = Smer.DOLE_VLAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        } else if (this.smer == Smer.DOLE_VPRAVO) {
                            this.smer = Smer.DOLE_VLAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        } else {
                            this.smer = Smer.DOLE_VPRAVO;
                            this.skrytiePrekazok(riadok, stlpec);
                        }
                    }
                }
            }
        }

        return this.smer;
    }

    /**
     * Metóda vyhondotí výhru hráča,
     * zavolá metódu getSmerOkolie a metódu getDotknutaOsoba,
     * aby zistila smer, do ktorého sa má posúvať guličku.
     * Na začiatku je využitý cyklus for pre zrýchlenie pohybu guličky.
     */
    public void tik() {
        if (this.skryte == this.prekazky.getPocetPrekazok()) {
            if (this.lenRaz == 0) {
                this.smer = Smer.ZIADNY;
                BlokTextu pomocna = new BlokTextu("Vyhral si", 365, 350);
                pomocna.zmenFarbu("black");
                this.text = pomocna;
                this.text.zobraz();
                this.lenRaz = 1;
            }
        }

        for (int zrychly = 0; zrychly <= this.zrychliTik; zrychly++) {
            this.getSmerOkolie();
            this.getDotknutaPrekazka();

            switch (this.smer) {
                case DOLE_VPRAVO:
                    this.gulicka.getPosunutaPoloha(Smer.DOLE_VPRAVO);
                    break;
                case DOLE_VLAVO:
                    this.gulicka.getPosunutaPoloha(Smer.DOLE_VLAVO);
                    break;
                case HORE_VPRAVO:
                    this.gulicka.getPosunutaPoloha(Smer.HORE_VPRAVO);
                    break;
                case HORE_VLAVO:
                    this.gulicka.getPosunutaPoloha(Smer.HORE_VLAVO);
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * Metóda zabezpečuje ovládanie odrážadla pri stlačení šipky vpravo.
     * Podmienka zisťuje či sa odrážadlo nenachádza pri pravom okraji,
     * ak áno nedovolí sa mu posuňúť.
     */
    public void posunOdrazadloVpravo() {
        if (this.odrazadlo.getX() < this.oramovanie.getKoniecSirky() - this.odrazadlo.getSirka()) {
            this.odrazadlo.doprava();
        }
        this.sipka = Sipky.VPRAVO;
    }

    /**
     * Metóda zabezpečuje ovládanie odrážadla pri stlačení šipky vľavo.
     * Podmienka zisťuje či sa odrážadlo nenachádza pri ľavom okraji,
     * ak áno nedovolí sa mu posuňúť.
     */
    public void posunOdrazadloVlavo() {
        if (this.odrazadlo.getX() > this.oramovanie.getZaciatokSirky()) {
            this.odrazadlo.dolava();
        }
        this.sipka = Sipky.VLAVO;
    }

    /**
     * Metóda zistí, kde sa nachádza hráčsky kurzor po kliknutí
     * a zisťuje, či sa dané súradnice nezhodujú so súradnicami tlačitiek.
     * @param x predstavuje x-sovú súradnicu myšky.
     * @param y predstavuje y-novú súradnicu myšky.
     */
    public void vyberMenu(int x, int y) {
        for (int i = 0; i < this.tlacidla.size(); i++) {
            if (x >= this.tlacidla.get(i).getBlokX()
                && x <= this.tlacidla.get(i).getBlokX() + this.tlacidla.get(i).getSirkaBloku()
                && y >= this.tlacidla.get(i).getBlokY()
                && y <= this.tlacidla.get(i).getBlokY() + this.tlacidla.get(i).getVyskaBloku()) {
                if (i == 0) {
                    this.skryMeniaceCasti();
                    this.level = Level.LEVEL1;
                    this.vytvorPlochu();
                } else if (i == 1) {
                    this.skryMeniaceCasti();
                    this.level = Level.LEVEL2;
                    this.vytvorPlochu();
                } else if (i == 2) {
                    this.skryMeniaceCasti();
                    this.level = Level.LEVEL3;
                    this.vytvorPlochu();
                } else {
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Pomocná metóda, ktorá vytvára novú plochu.
     */
    private void vytvorPlochu() {
        this.manazer = new Manazer();
        this.prekazky = new Prekazky(this.level.getPocetRiadkov(), this.level.getPocetStlpcov());
        this.gulicka = new Gulicka(20, this.level.getXGulicky(), this.level.getYGulicky());
        this.smer = this.level.getSmerGulicky();
        this.odrazadlo = new Odrazadlo(this.level.getVelkostOdrazadla(), 20);
        this.zrychliTik = this.level.getRychlostGulicky();
        this.skryte = 0;
        this.sipka = Sipky.ZIADNA;
        this.lenRaz = 0;
    }

    /**
     * Pomocná metóda skryje odrážadlo, guličku, prekážky a text.
     */
    private void skryMeniaceCasti() {
        this.odrazadlo.skry();
        this.gulicka.skry();
        this.prekazky.skry();
        this.text.skry();
    }

    /**
     * Pomocná metóda, ktorá podľa farby bloku vykoná dané vylepšenie,
     * skryje blok a pripočíta k atribútu skryté jednotku.
     * @param riadok načíta, v ktorom riadku sa prekážka nachádza.
     * @param stlpec načíta, v ktorom stĺpci sa prekážka nachádza.
     */
    private void skrytiePrekazok(int riadok, int stlpec) {
        switch (this.prekazky.getFarba(riadok, stlpec)) {
            case ZLTA:
                this.zrychliTik *= 2;
                this.prekazky.getBlok(riadok, stlpec).skry();
                this.skryte++;
                break;
            case CERVENA:
                this.zrychliTik /= 2;
                this.prekazky.getBlok(riadok, stlpec).skry();
                this.skryte++;
                break;
            case RUZOVA:
                this.gulicka.zvacsi();
                this.prekazky.getBlok(riadok, stlpec).skry();
                this.skryte++;
                break;
            case ZELENA:
                this.gulicka.zmensi();
                this.prekazky.getBlok(riadok, stlpec).skry();
                this.skryte++;
                break;
            default:
                this.prekazky.getBlok(riadok, stlpec).skry();
                this.skryte++;
                return;
        }
    }
}
