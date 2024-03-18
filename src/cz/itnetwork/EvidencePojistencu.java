package cz.itnetwork;


public class EvidencePojistencu {
    /**
     * evidence pojistencu
     */
    private final Pojistenci pojistenci = new Pojistenci();
    /**
     * konsole pro komunikaci s uzivatelem
     */
    private final Konsole konsole = new Konsole();

    /**
     * vypise hlavicku
     */
    private void vypisHlavicku() {
        konsole.vypisCaru();
        konsole.vypisRadek("Evidence pojistenych");
        konsole.vypisCaru();
        konsole.vypisRadek();
        konsole.vypisRadek("1 - Pridat noveho pojisteneho");
        konsole.vypisRadek("2 - Vypsat vsechny pojistene");
        konsole.vypisRadek("3 - Vyhledat pojisteneho");
        konsole.vypisRadek("4 - Konec");
    }

    public void SpustiEvidenci() {
        int akce;
        do {
            vypisHlavicku();
            akce = konsole.zjistiCisloVIntervalu("Vyberte si akci:",1,4);
            konsole.vypisRadek();
            switch (akce) {
                case 1:
                    //pridani uzivatele
                    pojistenci.pridejPojistence(new Pojistenec(
                            konsole.zjistiSlovo("Zadej jmeno pojistneho:"),
                            konsole.zjistiSlovo("Zadejte prijmeni:"),
                            konsole.zjistiTelefoniCislo("Zadejte telefoni cislo:"),
                            konsole.zjistiCisloVIntervalu("Zadejte vek:", 1,150)));
                    konsole.vypisRadek("---- Data ulozeny ----");
                    break;
                case 2:
                    //vypis vsech pojistencu
                    konsole.vypisPojistencu(pojistenci.vypisVsechnyPojistence());
                    break;
                case 3:
                    //vypis pojistencu dle jmena a prijmeni
                    konsole.vypisPojistencu(pojistenci.vyhledejPojistence(
                                    konsole.zjistiSlovo("Zadej jmeno:"),
                                    konsole.zjistiSlovo("Zadej prijmeni:")));
                    break;
            }
            konsole.vypisRadek();
        } while (akce != 4);
    }
}
