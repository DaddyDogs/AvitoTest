package ermolaeva;

import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

public class FavoritesTest extends InitTest {
    private final static String URL = "https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363";
    private static ItemPage itemPage;
    @Test
    @Order(1)
    @DisplayName("Check if adding works okay")
    public void checkAdding(){
        itemPage = new ItemPage(URL);
        itemPage.clickOnButton();
        //itemPage.getAddButton().shouldHave(Condition.attribute("title", "В избранном"));
    }
    @Test
    @Order(2)
    @DisplayName("Check if adding has worked okay")
    public void checkResult(){
        itemPage.getAddButton().shouldHave(Condition.attribute("data-is-favorite", "true"));
    }
}
