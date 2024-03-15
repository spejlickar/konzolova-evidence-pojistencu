package cz.itnetwork;

import java.util.Scanner;

public class Konsole {
    /**
     * instance scanner konzole
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * vypise radek textu do konzole
     * @param text text na vypsani
     */
    public void vypisText(String text){
        System.out.println(text);
    }

    /**
     * vrati NEPRAZDNY text z konzole po zadane otazce
     * @param otazka otazka
     * @return text zadany uzivatelem
     */
    public String zjistiText(String otazka) {
        System.out.print(otazka);
        String odpoved = scanner.nextLine();
        if (odpoved.equals("")) {
            return zjistiText(otazka);
        } else {
            return odpoved;
        }
    }

    /**
     * vrati cislo z konzole pokud nezada cislo, zepta se znovu
     * @param otazka otazka
     * @return cislo
     */
    public int zjistiCislo(String otazka){
        System.out.print(otazka);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return zjistiCislo(otazka);
        }
    }

    public int zjistiKladneCislo(String otazka,int maxCislo){
        int cislo = zjistiCislo(otazka);
        if ((cislo <= 0)||(cislo > maxCislo)) cislo = zjistiKladneCislo(otazka,maxCislo);
        return cislo;
    }
    public static boolean jeCislo(String text) {
        for (char znak:text.toCharArray()){
            if (!Character.isDigit(znak)) return false;
        }
        return true;
    }

    public String zjistiTelefoniCislo(String otazka){
        String odpoved = zjistiText(otazka).replace(" ","");
        if (!jeCislo((odpoved.startsWith("+")) ? odpoved.substring(1, odpoved.length() - 1) : odpoved) || odpoved.length()<9) {
            odpoved = zjistiTelefoniCislo(otazka);
        }
        return odpoved;
    }
}

