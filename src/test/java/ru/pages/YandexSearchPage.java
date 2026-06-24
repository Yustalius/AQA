package ru.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchPage {

    private final SelenideElement searchInput = $("#text");
    private final SelenideElement submitButton = $("[type=submit]");

    public YandexSearchPage openPage() {
        open("https://ya.ru/");
        return this;
    }

    public YandexSearchPage search(String query) {
        searchInput.setValue(query);
        return this;
    }

    public YandexSearchResultsPage submit() {
        submitButton.click();
        return new YandexSearchResultsPage();
    }
}