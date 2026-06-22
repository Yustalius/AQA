package ru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
    @Test
    void mentoringPriceTest(){
        /*
        Проверить, что предоплата по обучению - 47000 рублей
         */
        Configuration.holdBrowserOpen = true;

        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();
        $(".DistributionButtonClose").click();
        $(byText("ivanbulgakovqa.ru")).click();

        sleep(2000);
        switchTo().window(1);
        $$(".t-menu__list li").last().click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        $("body").shouldHave(text("47 000.00"));
            }


    @Test
    void studentRegistrationFormTest() {
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("QA");
        $("#userEmail").setValue("nikita@test.com");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#currentAddress").setValue("Test address");
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").scrollIntoView(true).click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Nikita QA"));
        $(".modal-content").shouldHave(text("nikita@test.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("1234567890"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("English"));
        $(".modal-content").shouldHave(text("Test address"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
    }
}


