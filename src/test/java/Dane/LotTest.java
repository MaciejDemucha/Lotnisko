package Dane;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

@Category({TestControl.class, TestEntity.class})
@RunWith(Parameterized.class)
public class LotTest {
    Dane dane;

    @Parameterized.Parameter(value = 0)
    public int numerLotu;

    @Parameterized.Parameter(value = 1)
    public boolean czyJestWolneExpected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{
                {0, true}, {1, false},{2, true} };
        return Arrays.asList(data1);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp(){
        dane= new Dane();
    }

   @Test
    public void wybierzMiejsceTest() {
       String userInput = String.format("1aa%s", System.lineSeparator());
       ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
       System.setIn(bais);
       exception.expect(NumberFormatException.class);
       //Assert.assertThrows(NumberFormatException.class, dane.loty.get(numerLotu)::wybierzMiejsce);
       dane.loty.get(numerLotu).wybierzMiejsce();
    }

    @Test
    public void czyJestWolneMiejsceTest(){
        Assert.assertEquals(czyJestWolneExpected, dane.loty.get(numerLotu).czyJestWolneMiejsce());
    }
}