package cz.itnetwork;

public class Pojistenec {
    /**
     * jmeno pojistenece
     */
    private String jmeno;
    /**
     * prijmeni pojistenece
     */
    private String prijmeni;
    /**
     * telefoni cislo pojistence
     */
    private String telefon;
    /**
     * vek pojistenece
     */
    private int vek;
    /**
     * format textoveho vytupu objektu
     */
    private final static String formatTextovyVystup = "%-15s%-15s%-6s%-20s";

    /**
     * vytvvori novou instanci pojistenec
     *
     * @param jmeno    jmeno pojistence
     * @param prijmeni prijmeni pojistence
     * @param telefon  telefonni cislo pojistence
     * @param vek      vek pojistence
     */
    public Pojistenec(String jmeno, String prijmeni, String telefon, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.vek = vek;
    }

    /**
     * vypis jmnena pojisteneho
     *
     * @return vrati jmeno pojisteneho
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * zmeni jmeno pojisteneho
     *
     * @param jmeno nove jmeno pojisteneho
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * vypis prijmeni pojisteneho
     *
     * @return vrati jmeno pojisteneho
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * nastavi nove jmeno pojisteneho
     *
     * @param prijmeni nove prijmeni pojisteneho
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * vypise telefoni cislo
     *
     * @return vrati telefoni cislo pojisteneho
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * nastavi nove jmeno pojisteneho
     *
     * @param telefon nove cislo pojisteneho
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * vypise vek pojisteneho
     *
     * @return vrati vek pojisteneho
     */
    public int getVek() {
        return vek;
    }

    /**
     * zmeni vek pojisteneho
     *
     * @param vek novy vek pojisteneho
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * vrati informaci o objektu formatovany "formatTextovyVystup"
     *
     * @return info informaci o objektu
     */
    @Override
    public String toString() {
        return String.format(formatTextovyVystup, getJmeno(), getPrijmeni(), Integer.toString(getVek()), getTelefon());
    }

    /**
     * vrati popis k "toString" formatovany "formatTextovyVystup"
     *
     * @return vrati popis k "toString"
     */
    public static String textHlavicka() {
        return String.format(formatTextovyVystup, "Jmeno", "Prijmeni", "Vek", "Telefon");
    }
}

