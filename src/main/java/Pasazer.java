public class Pasazer {
    private String imie;
    private String nazwisko;
    private int numerPaszportu;

    public Pasazer(String imie, String nazwisko, int numerPaszportu) {
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

    public int getNumerPaszportu() {
        return numerPaszportu;
    }

    public void setNumerPaszportu(int numerPaszportu) {
        this.numerPaszportu = numerPaszportu;
    }
}
