package Dane;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Dane {



    public static final HashMap<Integer, Lot> loty = new HashMap<>();
    static {
        loty.put(0, new Lot(0,0, "Warszawa - Berlin", LocalDateTime.now()));
        loty.put(1, new Lot(1,50, "Warszawa - Paryż", LocalDateTime.now()));
        loty.put(2, new Lot(2,50, "Warszawa - Londyn", LocalDateTime.now()));
        loty.put(3, new Lot(3,50, "Warszawa - Amsterdam", LocalDateTime.now()));

        Lot lot2 = loty.get(1);
        ArrayList<Miejsce> miejsca = lot2.getMiejsca();
        for (Miejsce miejsce:miejsca) {
            miejsce.setCzyZajete(true);
        }

        Lot lot3 = loty.get(2);
        miejsca = lot3.getMiejsca();
        for(int i = 0; i < miejsca.size()-1; i++)
            miejsca.get(i).setCzyZajete(true);

    }


   public static final HashMap<Integer, Rezerwacja> rezerwacje = new HashMap<>();
    static {
        Pasazer pasazer1 = new Pasazer("Maciej", "Demucha", "AB1234567");
        Pasazer pasazer2 = new Pasazer("Maciej", "Demucha", "");
        Pasazer pasazer3 = new Pasazer("Mac3iej", "Demucha", "AB1234567");
        rezerwacje.put(0, new Rezerwacja(0 ,loty.get(1), loty.get(1).getMiejsca().get(0), pasazer1));
        rezerwacje.put(1, new Rezerwacja(1 ,loty.get(2), loty.get(2).getMiejsca().get(0), pasazer2));
        rezerwacje.put(2, new Rezerwacja(2 ,loty.get(3), loty.get(3).getMiejsca().get(0), pasazer3));
    }




    public  Dane(){

        Lot lot1 = new Lot(0,50, "Warszawa - Berlin", LocalDateTime.now());
        Lot lot2 = new Lot(1,50, "Warszawa - Paryż", LocalDateTime.now());
        Lot lot3 = new Lot(2,50, "Warszawa - Londyn", LocalDateTime.now());
        Lot lot4 = new Lot(3,50, "Warszawa - Amsterdam", LocalDateTime.now());








        //Rezerwacja rezerwacja = new Rezerwacja(1 ,lot4, lot4.getMiejsca().get(0), pasazer);

    }

}
