package ru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.pages.PracticeFormPage;
import ru.pages.YandexSearchPage;

public class SearchTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void mentoringPriceTest() {
        /*
        Проверить, что предоплата по обучению - 47000 рублей
         */
        new YandexSearchPage()
                .openPage()
                .search("bulgakov qa")
                .submit()
                .closePopup()
                .openSite("ivanbulgakovqa.ru")
                .goToPricing()
                .clickBuyButton()
                .priceShouldBe("47 000.00");
    }

    @Test
    void studentRegistrationFormTest() {
        new PracticeFormPage()
                .openPage()
                .setFirstName("Nikita")
                .setLastName("QA")
                .setEmail("nikita@test.com")
                .setPhone("1234567890")
                .selectGender("Male")
                .selectHobby("Sports")
                .setSubject("English")
                .setAddress("Test address")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit()
                .resultShouldHave(
                        "Thanks for submitting the form",
                        "Nikita QA",
                        "nikita@test.com",
                        "Male",
                        "1234567890",
                        "Sports",
                        "English",
                        "Test address",
                        "NCR Delhi"
                );
    }
}