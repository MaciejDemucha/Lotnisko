import java.time.LocalDateTime;
import java.util.*;

public class Lot {
    private int numerLotu;
    private ArrayList<Miejsce> miejsca;
    private String relacja;
    private LocalDateTime godzina;

    public Lot(int liczbaMiejsc, String relacja, LocalDateTime godzina) {
        this.miejsca = new ArrayList<>();
        for (int i = 0; i < liczbaMiejsc; i++){
            this.miejsca.add(new Miejsce(i+1));
        }
        this.relacja = relacja;
        this.godzina = godzina;
        this.numerLotu = 0;
    }

    public int getNumerLotu() {
        return numerLotu;
    }

    public void setNumerLotu(int numerLotu) {
        this.numerLotu = numerLotu;
    }

    public List<Miejsce> getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(ArrayList<Miejsce> miejsca) {
        this.miejsca = miejsca;
    }

    public String getRelacja() {
        return relacja;
    }

    public void setRelacja(String relacja) {
        this.relacja = relacja;
    }

    public LocalDateTime getGodzina() {
        return godzina;
    }

    public void setGodzina(LocalDateTime godzina) {
        this.godzina = godzina;
    }

    public boolean czyJestWolneMiejsce(){

        for (Miejsce miejsce : miejsca){
            if(!miejsce.getCzyMiejsceJestZajete())
                return true;
        }
        return false;
    }

    public Miejsce wybierzMiejsce(){
        Scanner scanner = new Scanner(System.in);
        Miejsce miejsce;
        System.out.println("Podaj numer miejsca: ");
        int numer = Integer.parseInt(scanner.nextLine());
        miejsce = miejsca.get(numer);
        return miejsce;

    }

    public Miejsce wylosujMiejsce(){
        Random random = new Random();
        Miejsce miejsce;
        do{
            miejsce = miejsca.get(random.nextInt(miejsca.size()));
        }while (miejsce.getCzyMiejsceJestZajete());

            return miejsce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return miejsca.equals(lot.miejsca) && relacja.equals(lot.relacja) && godzina.equals(lot.godzina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miejsca, relacja, godzina);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "numerLotu = " + numerLotu +
                ", miejsca = " + miejsca.size() +
                ", relacja = '" + relacja + '\'' +
                ", data = " + godzina +
                '}';
    }
}
