package ermolaeva;

import com.codeborne.selenide.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.avito.ru/favorites
public class FavoritesListPage {

    private final ElementsCollection countFavoriteItemsInCategories = $$x("//div[contains(@class,\"category-content\")]");
    private final ElementsCollection favoriteItems = $$("div[class*=\"item-snippet\"] div a");

    public FavoritesListPage(String pageUrl){
        Selenide.open(pageUrl);
    }
    public FavoritesListPage categoriesCountShouldBeGreaterThan(int count){
        countFavoriteItemsInCategories.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(count));
        return this;
    }
    public FavoritesListPage allFavoriteItemsCountShouldBeGreaterThan(int count){
        String result = countFavoriteItemsInCategories.first().find("span", 1).getText();
        assertTrue(Integer.parseInt(result) > count);
        return this;
    }

    public FavoritesListPage categoryFavoriteItemsCountShouldBeGreaterThan(String categoryName, int count){
        SelenideElement category = countFavoriteItemsInCategories.filterBy(Condition.text(categoryName)).first();
        String result = category.find("span", 1).getText();
        assertTrue(Integer.parseInt(result) > count);
        return this;
    }
    public FavoritesListPage favoriteListShouldContainItem(String itemLink, String itemName){
        favoriteItems.filterBy(Condition.attribute("href", itemLink)).
                shouldHave(CollectionCondition.sizeGreaterThan(1));
        favoriteItems.filterBy(Condition.text(itemName)).
                shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }
}