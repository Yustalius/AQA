package ru.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YandexSearchResultsPage {

    private final SelenideElement closePopupButton = $(".DistributionButtonClose");

    public YandexSearchResultsPage closePopup() {
        if (closePopupButton.exists()) {
            closePopupButton.click();
        }
        return this;
    }

    public MentorSitePage openSite(String siteName) {
        $(byText(siteName)).click();
        switchTo().window(1);
        return new MentorSitePage();
    }
}