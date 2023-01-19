import Dane.Lot;
import Dane.Pasazer;
import Dane.Rezerwacja;
import com.sun.security.auth.module.JndiLoginModule;
import mockit.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

public class AplikacjaTestJMockit {
    @Mocked
    Pasazer pasazer;

    @Mocked
    Aplikacja aplikacja;

    @Injectable
    Lot lot1, lot2, lot3;

    @Test
    public void testEquals(){
        Pasazer pasazer1 = new Pasazer("Imie", "Nazwisko", "AB1234567");
        Lot lot1 = new Lot(0,50, "Warszawa - Berlin", LocalDateTime.now());
        Rezerwacja[] rezerwacje = new Rezerwacja[]{new Rezerwacja(1,lot1, lot1.getMiejsca().get(1), pasazer), new Rezerwacja(1,lot1, lot1.getMiejsca().get(1), pasazer1)};
        for (int i = 0; i < 1; i++)
            for (int j = i; j < 2; j++)
                if (i == j)
                    Assert.assertTrue(rezerwacje[i].equals(rezerwacje[i]));
                else
                    Assert.assertFalse(rezerwacje[i].equals(rezerwacje[j]));
        new VerificationsInOrder() {{
            pasazer.equals(any);
            maxTimes = 2;
        }};
    }

    @Test
    public void wyszukajLotTest(){
        lot1.setNumerLotu(0);
        lot2.setNumerLotu(1);
        lot3.setNumerLotu(2);
        Lot[] loty = new Lot[]{lot1,lot2,lot3};
        int[] numery = new int[]{0,1,2};

        for (int i = 0; i < 3; i++)
            Assert.assertEquals(Aplikacja.wyszukajLot(numery[i]), loty[i]); //dodatkowy test assertEquals

        new VerificationsInOrder() {{
            lot1.equals(any);
            times = 2;
            lot2.equals(any);
            times = 3;
            lot3.equals(any);
            times = 4;
        }};
    }

    @Test(expected=IllegalArgumentException.class)
    public void testPobierzAtrybutyBlednyformat() {
       String imie = "Maciej";
       String nazwisko = "Demucha";
       String nrPaszportu = "";
        new Expectations() {
            {
               aplikacja.pobierzAtrybuty(imie, nazwisko, nrPaszportu);
                result=new IllegalArgumentException();
            }
        };

    }
}

