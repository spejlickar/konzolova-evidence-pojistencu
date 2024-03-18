package cz.itnetwork;

import java.util.List;
import java.util.Scanner;

public class Konsole {
    /**
     * instance scanner konzole
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * vypise radek textu do konzole
     *
     * @param text text na vypsani
     */
    public void vypisRadek(String text) {
        System.out.println(text);
    }

    /**
     * vypise prazdny radek
     */
    public void vypisRadek() {
        System.out.println();
    }

    /**
     * vypise text do konzole
     *
     * @param text text na vypsani
     */
    public void vypisText(String text) {
        System.out.print(text);
    }

    /**
     * vypise caru
     */
    public void vypisCaru() {
        vypisRadek("------------------------------------------------------------");
    }

    /**
     * vypise pojistence do konsole, pokud je prazdna kolekce vypise text "--- Zadni pojisteneci nenalezeni ----"
     *
     * @param pojistenci           kolekce pro vypis do konzole
     */
    public void vypisPojistencu(List<Pojistenec> pojistenci) {
        if (pojistenci != null) {
            if (!pojistenci.isEmpty()) {
                vypisRadek(Pojistenec.textHlavicka());
                vypisCaru();
                for (Pojistenec pojistenec : pojistenci) {
                    vypisRadek(pojistenec + "");
                }
            } else {
                vypisRadek();
                vypisRadek("--- Zadni pojisteneci nenalezeni ----");
            }
        }
    }

    /**
     * vrati NEPRAZDNY TEXT(bez venkovnich mezer) od uzivatele po zadane otazce
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @return NEPRAZDNY TEXT zadany uzivatelem
     */
    public String zjistiText(String otazka) {
        vypisText(otazka);
        String odpoved = scanner.nextLine().trim();
        if (odpoved.isEmpty()) {
            return zjistiText("Chybne zadano (neobsahuje zadne znaky), zadej znovu:");
        } else {
            return odpoved;
        }
    }

    /**
     * vrati SLOVO(bez vnitrnich mezer) od uzivatele po zadane otazce
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @return SLOVO zadany uzivatelem
     */
    public String zjistiSlovo(String otazka) {
        String odpoved = zjistiText(otazka);
        if (odpoved.contains(" ")) {
            return zjistiSlovo("Chybne zadano (zadano vice slov), zadej znovu:");
        } else {
            return odpoved;
        }
    }

    /**
     * vrati CELE CISLO od uzivatele
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @return CELE CISLO od uzivatele
     */
    public int zjistiCislo(String otazka) {
        try {
            return Integer.parseInt(zjistiText(otazka));
        } catch (Exception e) {
            return zjistiCislo("Chybne zadano (neni cele cislo), zadej znovu:");
        }
    }

    /**
     * Vrati cele cislo v danem intervalu od "minCislo" do "maxCislo" od uzivatele
     *
     * @param otazka   otazka pro zjistkáni odpovedi
     * @param minCislo minimalni cislo zadani
     * @param maxCislo maximalni cislo zadani
     * @return cele cislo v intervalu ("minCislo","maxCislo") od uzivatele
     */
    public int zjistiCisloVIntervalu(String otazka, int minCislo, int maxCislo) {
        int cislo = zjistiCislo(otazka);
        if ((cislo <= 0) || (cislo > maxCislo)) {
            return zjistiCisloVIntervalu(
                    String.format("Chybne zadano (cislo neni v rozmezi od %d do %d), zadej znovu:", minCislo, maxCislo),
                    minCislo, maxCislo);
        }
        return cislo;
    }

    /**
     * Zjisti zda je text slozen jen z cifer
     *
     * @param text testovaci text
     * @return vysledek testu
     */
    public static boolean jeCislo(String text) {
        for (char znak : text.toCharArray()) {
            if (!Character.isDigit(znak)) return false;
        }
        return true;
    }

    /**
     * Vrati telefoni cislo od uzivatele
     * (vyrusi mezery, toleruje plus na zacatku, kontrla minimalniho poctu cifer dle ne/mezinarodniho formatu 9/12)
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @return vysledny telefoni cislo bez mezer
     */
    public String zjistiTelefoniCislo(String otazka) {
        //odstraneni vsech mezer v "odpoved" na "otazka"
        String odpoved = zjistiText(otazka).replace(" ", "");
        //vyruseni znaku "+" nebo "00" v "opoved" a ulozeni znaku "+" nebo "00" do "znakyNaZacatku"
        String znakyNaZacatku = "";
        if (odpoved.startsWith("+")) {
            znakyNaZacatku = "+";
            odpoved = odpoved.substring(1);
        } else if (odpoved.startsWith("00")) {
            znakyNaZacatku = "00";
            odpoved = odpoved.substring(2);
        }
        //zepta se znovu pri necifernym nebo malym poctu cifer ( ne/mezinarodniho formatu minimum 9/12 znaku )
        if (((znakyNaZacatku.isEmpty()) && (odpoved.length() < 9)) ||
                ((!znakyNaZacatku.isEmpty()) && (odpoved.length() < 12)) ||
                !jeCislo(odpoved)) {
            return zjistiTelefoniCislo("Chybne zadano zadej znovu:");
        }
        return znakyNaZacatku + odpoved;
    }
}

