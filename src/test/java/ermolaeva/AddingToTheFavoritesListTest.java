package ermolaeva;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddingToTheFavoritesListTest extends InitTest {
    private final static String URL = "https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363";
    private final static String DATA_ICON_BEFORE = "favorites";
    private final static String DATA_ICON_AFTER = "favorites-filled";
    private final static String BUTTON_CONTENT_BEFORE = "Добавить в избранное";
    private final static String BUTTON_CONTENT_AFTER = "В избранном";
    private final static String CATEGORY_NAME = "Книги и журналы";
    private static ItemPage itemPage;
    private static FavoritesListPage favoritesListPage;
    private static String itemName;
    @BeforeAll
    public static void openURL(){
        itemPage = new ItemPage(URL);
    }
    @Test
    @Order(1)
    @DisplayName("Check initial state of item")
    public void checkNotFavoriteItem(){
        assertFalse(itemPage.HeartIconShouldHaveData(DATA_ICON_BEFORE).
                AddFavoriteButtonShouldHaveText(BUTTON_CONTENT_BEFORE).
                AddFavoriteButtonShouldHaveTitle(BUTTON_CONTENT_BEFORE).
                checkIfItemIsFavorite());
    }
    @Test
    @Order(2)
    @DisplayName("Check state of favorite item")
    public void itemCanBeAddedToFavoritesList(){
        itemName = itemPage.getItemName();
        String pageURL = itemPage.AddToTheFavoriteList();
        assertTrue(itemPage.HeartIconShouldHaveData(DATA_ICON_AFTER).
                AddFavoriteButtonShouldHaveText(BUTTON_CONTENT_AFTER).
                AddFavoriteButtonShouldHaveTitle(BUTTON_CONTENT_AFTER).
                checkIfItemIsFavorite());
        favoritesListPage = new FavoritesListPage(pageURL);
    }

//    @Test
//    @Order(3)
//    @DisplayName("Check that item was added to the favorite list")
//    public void itemIsInTheFavoriteList(){
//        favoritesListPage.categoriesCountShouldBeGreaterThan(1).
//                allFavoriteItemsCountShouldBeGreaterThan(0).
//                categoryFavoriteItemsCountShouldBeGreaterThan(CATEGORY_NAME, 0).
//                favoriteListShouldContainItem(URL, itemName);
//    }
}
