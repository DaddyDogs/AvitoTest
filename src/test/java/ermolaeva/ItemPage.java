package ermolaeva;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class ItemPage {
    private final SelenideElement addFavoriteButton = $x("//div[contains(@class, 'add-favorite')]/button");
    private final SelenideElement heartIcon = $("div[class*=\"add-favorite\"] [role=\"img\"]");
    private final SelenideElement favoritesLink = $("a[href*=\"favorites/\"]");
    private static final String hrefRegex = "https://www.avito.ru/favorites/.*";

    private final SelenideElement itemName = $(".title-info-title-text");
    public ItemPage(String pageUrl){
        Selenide.open(pageUrl);
    }
    public String AddToTheFavoriteList(){
        addFavoriteButton.click();
        favoritesLink.shouldHave(attributeMatching("href", hrefRegex));
        return favoritesLink.getAttribute("href");
    }
    public ItemPage HeartIconShouldHaveData(String data){
        heartIcon.shouldHave(attribute("data-icon", data));
        return this;
    }
    public ItemPage AddFavoriteButtonShouldHaveTitle(String data){
        addFavoriteButton.shouldHave(attribute("title", data));
        return this;
    }
    public ItemPage AddFavoriteButtonShouldHaveText(String text){
        addFavoriteButton.shouldHave(text(text));
        return this;
    }
    public Boolean checkIfItemIsFavorite(){
        return Objects.equals(addFavoriteButton.getAttribute("data-is-favorite"), "true");
    }
    public String getItemName(){
        return itemName.getText();
    }
}