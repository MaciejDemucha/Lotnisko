import Dane.LotTest;
import Dane.TestControl;
import Dane.TestEntity;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({LotTest.class, AplikacjaTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
public class LotniskoTestSuiteControl {
}
