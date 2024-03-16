package cz.itnetwork;

import java.util.List;

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
        vypisCaru();
        konsole.vypisRadek("Evidence pojistenych");
        vypisCaru();
        konsole.vypisRadek("");
        konsole.vypisRadek("1 - Pridat noveho pojisteneho");
        konsole.vypisRadek("2 - Vypsat vsechny pojistene");
        konsole.vypisRadek("3 - Vyhledat pojisteneho");
        konsole.vypisRadek("4 - Konec");
    }
    /**
     * vypise caru
     */
    private void vypisCaru() {
        konsole.vypisRadek("------------------------------------------------------------");

    }

    public void SpustiEvidenci() {
        int akce;
        do {
            vypisHlavicku();
            do {
                akce = konsole.zjistiCislo("Vyberte si akci:");
            } while (!((akce >= 1) && (akce <= 4)));
            List<Pojistenec> vypisPojistencu;
            konsole.vypisRadek("");
            switch (akce) {
                case 1:
                    //pridani uzivateel
                    pojistenci.pridejPojistence(new Pojistenec(
                            konsole.zjistiSlovo("Zadej jmeno pojistneho:"),
                            konsole.zjistiSlovo("Zadejte prijmeni:"),
                            konsole.zjistiTelefoniCislo("Zadejte telefoni cislo:"),
                            konsole.zjistiKladneCislo("Zadejte vek:", 150)));
                    konsole.vypisRadek("---- Data ulozeny ----");
                    break;
                case 2:
                    //vypis vsech pojistencu
                    vypisPojistencu = pojistenci.vypisVsechnyPojistence();
                    if (!vypisPojistencu.isEmpty()) {
                        konsole.vypisRadek(Pojistenec.textHlavicka());
                        vypisCaru();
                        for (Pojistenec pojistenec : vypisPojistencu) {
                            konsole.vypisRadek(pojistenec + "");
                        }
                    } else konsole.vypisRadek("--- Zadne data k zobrazeni ----");
                    break;
                case 3:
                    //vypis pojistencu dle jmena a prijmeni
                    vypisPojistencu = pojistenci.vyhledejPojistence(
                            konsole.zjistiSlovo("Zadej jmeno:"),
                            konsole.zjistiSlovo("Zadej prijmeni:"));
                    if (!vypisPojistencu.isEmpty()) {
                        konsole.vypisRadek(Pojistenec.textHlavicka());
                        vypisCaru();
                        for (Pojistenec pojistenec : vypisPojistencu) {
                            konsole.vypisRadek(pojistenec + "");
                        }
                    } else konsole.vypisRadek("Pojistenec nenalezen.");
                    break;
            }
            konsole.vypisRadek("");
        } while (akce != 4);
    }
}
