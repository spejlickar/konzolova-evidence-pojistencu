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
     * vrati text z konzole po zadane otazce
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
        /*System.out.print(otazka);
        boolean jeSpravne = false;
        int cislo = 0;
        while (!jeSpravne) {
            try {
                cislo = Integer.parseInt(scanner.nextLine());
                jeSpravne = true;
            } catch (Exception e) {
                System.out.print("Zadej znovu:");
            }
        }
        return cislo;*/
        System.out.print(otazka);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                return zjistiCislo(otazka);
            }

        }
    }

