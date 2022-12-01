import java.util.HashMap;
import java.util.Random;

public class Rezerwacja {
    private Lot lot;
    private Miejsce miejsce;
    private Pasazer pasazer;
    private int numerRezerwacji;

    public Rezerwacja(Lot lot, Miejsce miejsce, Pasazer pasazer, HashMap<Integer, Rezerwacja> rezerwacje) {
        this.lot = lot;
        this.miejsce = miejsce;
        this.pasazer = pasazer;

        Random random = new Random();

        do{
            this.numerRezerwacji = random.nextInt();
        }while (!rezerwacje.containsKey(this.numerRezerwacji));

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
}
