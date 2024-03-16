package cz.itnetwork;

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
     * vypise text do konzole
     *
     * @param text text na vypsani
     */
    public void vypisText(String text) {
        System.out.print(text);
    }

    /**
     * vrati NEPRAZDNY TEXT od uzivatele po zadane otazce
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @return text zadany uzivatelem
     */
    public String zjistiText(String otazka) {
        vypisText(otazka);
        String odpoved = scanner.nextLine().trim();
        if (odpoved.isEmpty()) {
            return zjistiSlovo("Chybne zadano zadej znovu:");
        } else {
            return odpoved;
        }
    }
    /**
     * vrati NEPRAZDNY SLOVO od uzivatele po zadane otazce
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @return slovo zadany uzivatelem
     */
    public String zjistiSlovo(String otazka) {
        String odpoved = zjistiText(otazka);
        if (odpoved.contains(" ")) {
            return zjistiSlovo("Chybne zadano zadej znovu:");
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
        vypisText(otazka);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return zjistiCislo("Chybne zadano zadej znovu:");
        }
    }

    /**
     * Vrati kladne cislo od uzivatel o maximalni hodnote
     *
     * @param otazka otazka pro zjistkáni odpovedi
     * @param maxCislo maximalni cislo zadani
     * @return kladne cislo od uzivatel
     */
    public int zjistiKladneCislo(String otazka, int maxCislo) {
        int cislo = zjistiCislo(otazka);
        if ((cislo <= 0) || (cislo > maxCislo)) return zjistiKladneCislo("Chybne zadano zadej znovu:", maxCislo);
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

