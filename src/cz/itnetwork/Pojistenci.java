package cz.itnetwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pojistenci {
    /**
     * seznam pojistencu
     */
    private final List<Pojistenec> pojistenci = new ArrayList<>();

    /**
     * vrati kolekci vsech pojistencu
     *
     * @return kolekce pojistencu
     */
    public List<Pojistenec> vypisVsechnyPojistence() {
        return Collections.unmodifiableList(pojistenci);
    }

    /**
     * vyhleda pojistence na zaklade jmena a prijmeni
     *
     * @param jmeno    jmeno hledaneho
     * @param prijmeni prijmeni hledaneho
     * @return seznam pojistencu
     */
    public List<Pojistenec> vyhledejPojistence(String jmeno, String prijmeni) {
        return pojistenci.stream().filter(a -> jmeno.equalsIgnoreCase(a.getJmeno()))
                .filter(a -> prijmeni.equalsIgnoreCase(a.getPrijmeni()))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * pridani pojistence
     *
     * @param pojistenec novy pojistenec
     */
    public void pridejPojistence(Pojistenec pojistenec) {
        pojistenci.add(pojistenec);
    }

    /**
     * vrati informace o poctu pojistencu
     *
     * @return pocet pojistencu
     */
    @Override
    public String toString() {
        return "Pojistenci" + super.toString() + "pocet: " + pojistenci.size();
    }
}
