import java.time.LocalDateTime;
import java.util.*;

public class Lot {
    private List<Miejsce> miejsca = new ArrayList<>();
    private String relacja;
    private LocalDateTime godzina;

    public Lot(List<Miejsce> miejsca, String relacja, LocalDateTime godzina) {
        this.miejsca = miejsca;
        this.relacja = relacja;
        this.godzina = godzina;
    }

    public List<Miejsce> getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(List<Miejsce> miejsca) {
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

    }

    public Miejsce wylosujMiejsce(){
        Random random = new Random();
        Miejsce miejsce;
        do{
            miejsce = miejsca.get(random.nextInt(miejsca.size()));
        }while (!miejsce.getCzyMiejsceJestZajete());

            return miejsce;
    }
}
