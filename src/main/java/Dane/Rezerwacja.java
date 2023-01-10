package Dane;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Rezerwacja {
    private Lot lot;
    private Miejsce miejsce;
    private Pasazer pasazer;
    private int numerRezerwacji;

    public Rezerwacja(Lot lot, Miejsce miejsce, Pasazer pasazer, HashMap<Integer, Rezerwacja> rezerwacje) {
        this.lot = lot;
        this.miejsce = miejsce;
        this.miejsce.setCzyZajete(true);
        this.pasazer = pasazer;

        Random random = new Random();

        do{
            this.numerRezerwacji = random.nextInt(1000);
        }while (rezerwacje.containsKey(this.numerRezerwacji));

    }


    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Miejsce getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(Miejsce miejsce) {
        this.miejsce = miejsce;
    }

    public Pasazer getPasazer() {
        return pasazer;
    }

    public void setPasazer(Pasazer pasazer) {
        this.pasazer = pasazer;
    }

    public int getNumerRezerwacji() {
        return numerRezerwacji;
    }

    public void setNumerRezerwacji(int numerRezerwacji) {
        this.numerRezerwacji = numerRezerwacji;
    }

    @Override
    public String toString() {
        return "Dane.Rezerwacja{" +
                " numerRezerwacji = " + numerRezerwacji +
                ", lot=" + lot.getRelacja() +
                ", godzina=" + lot.getGodzina() +
                ", miejsce = " + miejsce.getNumer() +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rezerwacja that = (Rezerwacja) o;
        return numerRezerwacji == that.numerRezerwacji && lot.equals(that.lot) && miejsce.equals(that.miejsce) && pasazer.equals(that.pasazer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lot, miejsce, pasazer, numerRezerwacji);
    }
}
