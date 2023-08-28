package ermolaeva;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363
public class ItemPage {
    private final SelenideElement addButton = $x("//div[contains(@class, 'add-favorite')]/button");
    private final SelenideElement addButton2 = $(".style-header-add-favorite-M7nA2 button[data-marker*=\"favorite-button\"]");
    public ItemPage(String pageUrl){
        Selenide.open(pageUrl);
    }
    public void clickOnButton(){
        //addButton = $$("button[data-marker*=\"favorite-button\"]").filter(Condition.visible).first();
        addButton.shouldBe(Condition.visible);
        addButton.click();
    }
    public SelenideElement getAddButton(){
        return addButton;
    }
}