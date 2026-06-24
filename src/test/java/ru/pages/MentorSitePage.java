package ru.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MentorSitePage {

    public MentorSitePage goToPricing() {
        $$(".t-menu__list li").last().click();
        return this;
    }

    public PaymentPage clickBuyButton() {
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();

        $(byText("Бегу оплачивать"))
                .shouldBe(visible)
                .click();

        switchTo().window(2);

        return new PaymentPage();
    }
}