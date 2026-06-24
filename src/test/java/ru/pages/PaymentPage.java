package ru.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    public PaymentPage priceShouldBe(String expectedPrice) {
        $("body").shouldHave(text(expectedPrice));
        return this;
    }
}