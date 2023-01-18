package Dane;

import java.util.Objects;

public class Pasazer {
    private String imie;
    private String nazwisko;
    private String numerPaszportu;

    public Pasazer(String imie, String nazwisko, String numerPaszportu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerPaszportu = numerPaszportu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumerPaszportu() {
        return numerPaszportu;
    }

    public void setNumerPaszportu(String numerPaszportu) {
        this.numerPaszportu = numerPaszportu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasazer pasazer = (Pasazer) o;
        return imie.equals(pasazer.imie) && nazwisko.equals(pasazer.nazwisko) && numerPaszportu.equals(pasazer.numerPaszportu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, numerPaszportu);
    }
}
