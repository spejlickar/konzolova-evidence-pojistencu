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
     *
     * @param otazka
     * @return
     */
    public String zjistiText(String otazka){
        return scanner.nextLine();
    }
    public int zjistiCislo(String otazka){
        System.out.print(otazka);
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
        return cislo;
    }
}
