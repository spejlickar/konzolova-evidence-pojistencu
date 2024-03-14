package cz.itnetwork;

public class EvidencePojistencu {
    /**
     * evidence pojistencu
     */
    private Pojistenci pojistenci = new Pojistenci();
    /**
     * konsole pro komunikaci s uzivatelem
     */
    private Konsole konsole = new Konsole();
    /**
     * vypise hlavicku
     */
    private void vypisHlavicku(){
        konsole.vypisText("----------------------------------");
        konsole.vypisText("Evidence pojistenych");
        konsole.vypisText("----------------------------------");
        konsole.vypisText("");
        konsole.vypisText("1 - Pridat noveho pojisteneho");
        konsole.vypisText("2 - Vypsat vsechny pojistene");
        konsole.vypisText("3 - Vyhledat pojisteneho");
        konsole.vypisText("4 - Konec");
    }

    public void SpustiEvidenci() {
        int akce = 4;
        do {
            vypisHlavicku();
            do {
                akce = konsole.zjistiCislo("Vyberte si akci:");
            } while (!((akce >= 1)&&(akce <= 4)));
            switch (akce){
                case 1:
                    pojistenci.pridejPojistence(new Pojistenec(
                            konsole.zjistiText("Zadej jmeno pojistneho:"),
                            konsole.zjistiText("Zadejte prijmeni:"),
                            konsole.zjistiText("Zadejte telefoni cislo:"),
                            konsole.zjistiCislo("Zadejte vek:")));
                    konsole.vypisText("Data ulozeny\n");
                    break;
                case 2:
                    for (Pojistenec pojistenec: pojistenci.vypisVsechnyPojistence()){
                        konsole.vypisText(pojistenec.toString()+"\n");
                    }
                    break;
                case 3:
                    for (Pojistenec pojistenec: pojistenci.vyhledejPojistence(
                            konsole.zjistiText("Zadej jmeno:"),
                            konsole.zjistiText("Zadej prijmeni:"))){
                        konsole.vypisText(pojistenec.toString()+"\n");
                    }
                    break;

            }

        } while (akce != 4);
    }
}
