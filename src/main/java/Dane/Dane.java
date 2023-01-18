package Dane;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Dane {


   public HashMap<Integer, Lot> loty = new HashMap<>();
   public HashMap<Integer, Rezerwacja> rezerwacje = new HashMap<>();

    public Dane(){
        Lot lot1 = new Lot(0,50, "Warszawa - Berlin", LocalDateTime.now());
        Lot lot2 = new Lot(1,50, "Warszawa - Paryż", LocalDateTime.now());
        Lot lot3 = new Lot(2,50, "Warszawa - Londyn", LocalDateTime.now());
        Lot lot4 = new Lot(3,50, "Warszawa - Amsterdam", LocalDateTime.now());

        ArrayList<Miejsce> miejsca = lot2.getMiejsca();
        for (Miejsce miejsce:miejsca) {
            miejsce.setCzyZajete(true);
        }

        miejsca = lot3.getMiejsca();
        for(int i = 0; i < miejsca.size()-1; i++)
            miejsca.get(i).setCzyZajete(true);

        loty.put(lot1.getNumerLotu(), lot1);
        loty.put(lot2.getNumerLotu(), lot2);
        loty.put(lot3.getNumerLotu(), lot3);
        loty.put(lot4.getNumerLotu(), lot4);

        Pasazer pasazer = new Pasazer("Maciej", "Demucha", "AB1234567");

        Rezerwacja rezerwacja = new Rezerwacja(1 ,lot4, lot4.getMiejsca().get(0), pasazer);
        rezerwacje.put(rezerwacja.getNumerRezerwacji(), rezerwacja);
    }

}
