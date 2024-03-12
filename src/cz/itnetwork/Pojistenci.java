package cz.itnetwork;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Pojistenci {
    /**
     * seznam pojistencu
     */
    private List<Pojistenec> pojistenci = new LinkedList<>();

    /**
     * vrati kolekci vsech pojistencu
     * @return kolekce pojistencu
     */
    public List<Pojistenec> vypisVsechnyPojistence(){
        return Collections.unmodifiableList(pojistenci);
    }

    /**
     * vyhleda pojistence na zaklade jmena a prijmeni
     * @param jmeno jmeno hledaneho
     * @param prijmeni prijmeni hledaneho
     * @return
     */
    public List<Pojistenec> vyhledejPojistence(String jmeno, String prijmeni){
        return Collections.unmodifiableList(pojistenci
                .stream().filter(a->jmeno.equals(a.getJmeno()))
                .filter(a->prijmeni.equals(a.getPrijmeni())).collect(Collectors.toList()));
    }

    /**
     * pridani pojistence
     * @param pojistenec novy pojistenec
     */
    public void pridejPojistence(Pojistenec pojistenec){
        pojistenci.addLast(pojistenec);
    }

    /**
     * vrati informace o poctu pojistencu
     * @return pocet pojistencu
     */
    @Override
    public String toString() {
        return "Pojistenci pocet: " + pojistenci.size();
    }
}
