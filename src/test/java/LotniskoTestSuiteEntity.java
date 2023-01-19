import Dane.LotTest;
import Dane.TestEntity;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Categories.SuiteClasses({LotTest.class, AplikacjaTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestEntity.class)
public class LotniskoTestSuiteEntity {
}
